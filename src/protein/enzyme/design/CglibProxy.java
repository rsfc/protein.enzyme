package protein.enzyme.design;
 
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List; 

import protein.enzyme.PtEventListener;
import protein.enzyme.design.event.ProxyEventError;
import protein.enzyme.design.event.ProxyEventHandler;
import protein.enzyme.repository.ProteinResource;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


/**cglib的代理
 * @author fjy 
 * @version 2014年8月12日 下午2:30:50 
 */
public class CglibProxy<T> implements MethodInterceptor {
    /**
     * @author   fjy
     * @version 2014年8月12日 下午3:43:32 
     */
    public List<PtEventListener>  InvokeBeforeListener=new ArrayList<PtEventListener>();
	 
	/**
	 * @author   fjy
	 * @version 2014年8月12日 下午3:43:30 
	 */
	public List<PtEventListener>  InvokeAfterListener=new ArrayList<PtEventListener>();
	
	/**
	 * @author   fjy
	 * @version 2014年8月12日 下午4:08:06 
	 */
	public List<PtEventListener>  InvokeExceptionListener=new ArrayList<PtEventListener>();
    /**
     * @author   fjy
     * @version 2014年8月12日 下午3:40:01 
     * @param Interface
     * @return
     */
    @SuppressWarnings("unchecked")
	public   T  createProxy(Class<T> Interface) { 
        Enhancer enhancer = new Enhancer();
        // 设置代理目标
        enhancer.setSuperclass(Interface);
        // 设置回调
        enhancer.setCallback(this);
        enhancer.setClassLoader(Interface.getClassLoader());
        return (T)enhancer.create();
    }
    /**
     * @author   fjy
     * @version 2014年8月12日 下午3:40:01 
     * @param Interface
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public   T  createProxy(Class<T> Interface,Class[] agrsType,Object[] agrsValue) { 
        Enhancer enhancer = new Enhancer();
        // 设置代理目标
        enhancer.setSuperclass(Interface);
        // 设置回调
        enhancer.setCallback(this);
        enhancer.setClassLoader(Interface.getClassLoader());
        return (T)enhancer.create(agrsType,agrsValue);
    }

    /**
     * @author   fjy
     * @version 2014年8月24日 下午10:33:25 
     * @param Interface
     * @param agrsValue
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public   T  createProxy(Class<T> Interface,Object[] agrsValue) { 
    	Class[] agrsType=this.matchConstructType(Interface,agrsValue);
        Enhancer enhancer = new Enhancer();
        // 设置代理目标
        enhancer.setSuperclass(Interface);
        // 设置回调
        enhancer.setCallback(this);
        enhancer.setClassLoader(Interface.getClassLoader());
        return (T)enhancer.create(agrsType,agrsValue);
    }
    
    /**匹配构造函数
     * @author   fjy
     * @version 2014年8月24日 下午10:34:40 
     */
    @SuppressWarnings("rawtypes")
	private Class[]  matchConstructType(Class tClass,Object[] agrsValue){
		Class[]  result=null;
		Constructor[]  cons=tClass.getDeclaredConstructors();
		for ( Constructor con : cons) {  
			Class[] curAgrs=con.getParameterTypes();
			if(this.checkAgrs(curAgrs,agrsValue))
			{
				result=curAgrs;
				break;
			}
		}
    	return result; 
    }
    /**
     * @author   fjy
     * @version 2014年8月24日 下午10:50:32 
     * @param curAgrs
     * @param agrsValue
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	private Boolean checkAgrs(Class[] curAgrs,Object[] agrsValue)
    {
    	for(Class cinClass :curAgrs)
    	{
    		//判断接口
    		if(cinClass.isInterface())
    		{
    			if(!this.checkInterfaceType(cinClass,agrsValue))
    			{
    				return false;
    			}
    		}
    		else {
				 if(!this.checkClassType(cinClass,agrsValue))
				 {
					 return false;
				 }
			}
    	}
		return true; 
    }
    /**检查类的类型
     * @author   fjy
     * @version 2014年8月24日 下午10:57:49 
     * @param interfaceCin
     * @param agrsValue
     * @return
     */
    @SuppressWarnings("rawtypes")
	private Boolean checkClassType(Class classCin, Object[] agrsValue) { 
    	for(Object v :agrsValue)
    	{ 
    		Class tc=ProteinResource.getBaseClassType(v);
    		if(tc==classCin)
    		{
    			return true;
    		}
    	}
		return false; 
	}
    /**检查接口类型
     * @author   fjy
     * @version 2014年8月24日 下午10:52:56 
     * @param interfaceCin
     * @param agrsValue
     * @return
     */
    @SuppressWarnings({ "hiding", "rawtypes", "unused" })
	private  <T> Boolean checkInterfaceType(Class<T>  interfaceCin, Object[] agrsValue)
    {
    	for(Integer i=0;i<agrsValue.length;i++)
    	{
    		Class iClass=agrsValue[i].getClass();
    		
    		if(interfaceCin.isAssignableFrom(agrsValue[i].getClass()))// agrsValue[i].getClass().isAssignableFrom(interfaceCin))
    		{
    			return true;
    		}
    		 
    		Type[] interfacesClasses=iClass.getGenericInterfaces();
//    		 for(Class c: interfacesClasses)
//	   		 {
//	   			 if(c==interfaceCin)
//	   			 {
//	   				 return true;
//	   			 }
//	   		 }
    	}
//    	for(Object v :agrsValue)
//    	{
//    		 for(Class c: v.getClass().getInterfaces())
//    		 {
//    			 if(c==interfaceCin)
//    			 {
//    				 return true;
//    			 }
//    		 }
//    	}
    	return false; 
    }
    /**
     * 在代理实例上处理方法调用并返回结果
     * 
     * @param proxy
     *            代理类
     * @param method
     *            被代理的方法
     * @param params
     *            该方法的参数数组
     * @param methodProxy
     */
    public Object intercept(Object proxy, Method method, Object[] params,
            MethodProxy methodProxy) throws Throwable {
    	EventObject eObject=new ProxyEventHandler(proxy, method, params,methodProxy);
    	try { 
	        Object result = null; 
	        // 调用之前
	        doBefore(eObject);
	        // 调用原始对象的方法
	        result = methodProxy.invokeSuper(proxy, params);
	        // 调用之后
	        doAfter(eObject); 
	        return result;
    	} catch (Exception e) { 
    		//该处缺少一个异常捕捉 使用内置文本异常输出无法处理的异常
    		System.out.println(e);
    		ProxyEventError pee=new ProxyEventError(proxy, method, params,methodProxy,e);
    		doError(pee);
    		return null;
		}
    }

    /**
     * @author   fjy
     * @version 2014年8月12日 下午2:31:11 
     */
    private void doBefore(EventObject eObject) {
        if (this.InvokeBeforeListener != null)
        {  
            for (PtEventListener listener : InvokeBeforeListener) {
            	listener.fireEvent(eObject);
			}
        } 
    }

    /**
     * @author   fjy
     * @version 2014年8月12日 下午2:31:14 
     */
    private void doAfter(EventObject eObject) {
        if (this.InvokeAfterListener != null)
        {  
            for (PtEventListener listener : InvokeAfterListener) {
            	listener.fireEvent(eObject);
			}
        } 
    }

    /**
     * @author   fjy
     * @version 2014年8月12日 下午2:31:14 
     */
    private void doError(EventObject eObject) {
        if (this.InvokeExceptionListener != null)
        {  
            for (PtEventListener listener : InvokeExceptionListener) {
            	listener.fireEvent(eObject);
			}
        } 
    }
}
