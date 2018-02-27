package protein.enzyme.dal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
 

/**ʵ������������
 * @author fjy 
 * @version 2014��8��11�� ����12:42:05 
 */
public abstract  class EntityTypeAdapter { 
	
 
	private EntityTypeAdapter nextadpter=null;
 
	@SuppressWarnings("rawtypes")
	protected Class targettype=null;
	
    /**��ȡ��һ������������
     * @author   fjy
     * @version 2014��8��11�� ����12:45:22 
     * @return
     */
    public   EntityTypeAdapter getNextEntityType()
    { 
    	return this.nextadpter;
    }
    
    /**������һ������������
     * @author   fjy
     * @version 2014��8��11�� ����12:45:51 
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
 
 
    /**����ʵ�������
     * @author   fjy
     * @version 2014��8��11�� ����12:48:35 
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
 
    /**����ʵ��
     * @author   fjy
     * @version 2014��8��11�� ����1:02:47 
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
     
     
    /** �жϴ�������
     * @author   fjy
     * @version 2014��8��11�� ����1:01:20 
     * @param ClassType
     * @return
     */
    @SuppressWarnings("rawtypes")
	protected abstract boolean IsType(Class  ClassType);
   
    
    /**��ȡĿ������
     * @author   fjy
     * @version 2014��8��11�� ����1:02:09 
     * @return
     */
    @SuppressWarnings("rawtypes")
	protected   Class getTargetType()
    {
    	return this.targettype; 
    }
    
    /**����Ŀ������
     * @author   fjy
     * @version 2014��8��11�� ����1:02:04 
     * @param classTyClass
     * @return
     */
    @SuppressWarnings("rawtypes")
	protected void setTargetType(Class classTyClass)
    {
    	this.targettype=classTyClass; 
    }
}
