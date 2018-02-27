package protein.enzyme.dal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
 

/**实体类型适配器
 * @author fjy 
 * @version 2014年8月11日 下午12:42:05 
 */
public abstract  class EntityTypeAdapter { 
	
 
	private EntityTypeAdapter nextadpter=null;
 
	@SuppressWarnings("rawtypes")
	protected Class targettype=null;
	
    /**获取下一个类型适配器
     * @author   fjy
     * @version 2014年8月11日 下午12:45:22 
     * @return
     */
    public   EntityTypeAdapter getNextEntityType()
    { 
    	return this.nextadpter;
    }
    
    /**设置下一个类型适配器
     * @author   fjy
     * @version 2014年8月11日 下午12:45:51 
     * @param TypeAdapter
     */
    public void setNextEntityType(EntityTypeAdapter TypeAdapter)
    { 
    	 if (this.nextadpter == null)
         {
             this.nextadpter = TypeAdapter;
         }
         else
         {
             if (this.nextadpter == TypeAdapter)
             {
                 return;
             }
             this.nextadpter.setNextEntityType(TypeAdapter);
         }
    }
 
 
    /**定义实体类对象
     * @author   fjy
     * @version 2014年8月11日 下午12:48:35 
     * @param EntityType
     * @param object
     * @return
     * @throws SecurityException 
     * @throws NoSuchMethodException 
     * @throws InvocationTargetException 
     * @throws IllegalArgumentException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
    public  <T> T Definition(Class<T> Cin, Object ... Parameters) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
    {
        T result =null;
        if (this.IsType(Cin))
        {
            result = CreateInstance(Cin,Parameters);
        }
        else if (this.nextadpter != null)
        {
            result = this.nextadpter.Definition(Cin, Parameters);
        }
        return result;
    }
 
    /**创建实例
     * @author   fjy
     * @version 2014年8月11日 下午1:02:47 
     * @throws InvocationTargetException 
     * @throws IllegalArgumentException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     * @throws SecurityException 
     * @throws NoSuchMethodException 
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	protected <T> T CreateInstance(Class<T> Cin, Object ... args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
    {
    	T ins = null;
    	if(this.targettype==null)
    	{
    		return null;
    	}                                	    
    	Class[] argsClass = new Class[args.length];                                   	    
    	for (int i = 0, j = args.length; i < j; i++) {                                	        
    		argsClass[i] = args[i].getClass();                                        	    
		}	 
		Constructor cons = this.targettype.getConstructor(argsClass);
		ins=(T)cons.newInstance(args);
		return  ins;  
 
    }
     
     
    /** 判断处理类型
     * @author   fjy
     * @version 2014年8月11日 下午1:01:20 
     * @param ClassType
     * @return
     */
    @SuppressWarnings("rawtypes")
	protected abstract boolean IsType(Class  ClassType);
   
    
    /**获取目标类型
     * @author   fjy
     * @version 2014年8月11日 下午1:02:09 
     * @return
     */
    @SuppressWarnings("rawtypes")
	protected   Class getTargetType()
    {
    	return this.targettype; 
    }
    
    /**设置目标类型
     * @author   fjy
     * @version 2014年8月11日 下午1:02:04 
     * @param classTyClass
     * @return
     */
    @SuppressWarnings("rawtypes")
	protected void setTargetType(Class classTyClass)
    {
    	this.targettype=classTyClass; 
    }
}
