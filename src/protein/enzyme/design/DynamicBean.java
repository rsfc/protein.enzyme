package protein.enzyme.design;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
 










import net.sf.cglib.asm.Type;
import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.BeanMap;
import net.sf.cglib.core.Signature;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InterfaceMaker;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * 动态扩展类实例
 * 
 * @author fjy
 * @version 2016年2月19日 上午2:25:54
 */
public class DynamicBean {
	private Object object = null;
	private BeanMap beanMap = null;
	private HashMap propertyMap=new HashMap();
	private Class[] intfs=null;
	/**
	 * 动态扩展类实例
	 *  
	 */
	public DynamicBean(HashMap map) {
		this.propertyMap=map;
		this.generateBean();
	}
	public DynamicBean(HashMap map,Class[] interfaces) {
		this.propertyMap=map;
		this.intfs=interfaces;
		this.generateBean();
	}
	
	public DynamicBean(HashMap map,Object tagObject)
	{
		this.propertyMap=map;
		blendFiled(tagObject);
		this.generateBean(); 
	}
	/**动态扩展类实例
	 * @param tagObject 原对象实例，将原有的属性和新对象融合
	 */
	public DynamicBean(Object tagObject)
	{
		blendFiled(tagObject);
		this.generateBean();
	}
	
	private void blendFiled(Object tagObject){
		Class clazz = tagObject.getClass();   
        Field[] fields = clazz.getDeclaredFields();  
        for (int i = 0; i < fields.length; i++) {     
            this.propertyMap.put(fields[i].getName(),fields[i].getType());
        }
	}
	
	
	 
	/**
	 * 给bean属性赋值
	 * 
	 * @param property
	 *            属性名
	 * @param value
	 *            值
	 */
	public void setValue(String property, Object value) {
		if(this.beanMap==null) return;
		beanMap.put(property, value);
	}

	/**
	 * 通过属性名得到属性值
	 * 
	 * @param property
	 *            属性名
	 * @return 值
	 */
	public Object getValue(String property) {
		if(this.beanMap==null) return null;
		return beanMap.get(property);
	}

	/**
	 * 得到该实体bean对象
	 * 
	 * @return
	 */
	public Object getObject() {
		return this.object;
	}
	
	/**生成对象
	 * @author   fjy
	 * @version 2016年2月19日 上午2:36:21 
	 */
	public void generateBean(){
		this.object = generateBean(propertyMap);
		this.beanMap = BeanMap.create(this.object);
	}
	
	private Object generateBean(Map propertyMap) { 
		BeanGenerator generator = new BeanGenerator();
		Set keySet = propertyMap.keySet();
		for (Iterator i = keySet.iterator(); i.hasNext();) {
			Object tmpObject=i.next();
			String key = (String)tmpObject;
			generator.addProperty(key, (Class) propertyMap.get(key)); 
			
		}
		Enhancer enhancer = new Enhancer();  
		enhancer.setSuperclass(generator.create().getClass()); 
		if(this.intfs!=null)
		{
//			Class[] ins=new Class[this.intfs.length];
//			for (int j = 0; j < this.intfs.length; j++) {
//				Method[] methods = this.intfs[j].getMethods();  
//				InterfaceMaker im = new InterfaceMaker();   
//		        for (int i = 0; i < methods.length; i++) {     
//			        im.add(new Signature(methods[i].getName(), Type.VOID_TYPE,   
//			                new Type[] { Type.getType(methods[i].getReturnType()) }), null);  
//		        
//		        }
//		        ins[j]=im.create();
//			}
			enhancer.setInterfaces(this.intfs);
			enhancer.setCallback(new MethodInterceptor() {  
		            public Object intercept(Object obj, Method method, Object[] args,  
		            		net.sf.cglib.proxy.MethodProxy proxy) throws Throwable {   
		                return proxy.invokeSuper(obj, args);  
		            }  
        	});  
		} 
		return enhancer.create();
	}
}
