package protein.enzyme.message;

import java.util.ArrayList;
import java.util.List;

/**池对象封装
 * @author fjy 
 * @version 2014年8月19日 下午11:09:39 
 */
public class PoolHde {
	 
	/**参数
	 * @author   fjy
	 * @version 2014年8月19日 下午11:41:23 
	 */
	private  List<Object> agrs=new ArrayList<Object>();
	
	/**目标类型
	 * @author   fjy
	 * @version 2014年8月19日 下午11:41:54 
	 */
	private Class targetClass=null;
	/**
	 * 
	 */
	public PoolHde(IProcessor ProcessInit,List<Object> agrs)
	{
		this.targetClass=ProcessInit.getClass();
		if(agrs!=null)
		{
			this.agrs=agrs;
		}
	} 
	 
	/**获取参数
	 * @author   fjy
	 * @version 2014年8月19日 下午11:43:21 
	 * @return
	 */
	public List<Object> getAgrs()
	{
		return this.agrs;
		
	}
	
	/**获取目标对象的类型
	 * @author   fjy
	 * @version 2014年8月19日 下午11:44:07 
	 * @return
	 */
	public Class getNewProcessorType(){
		return this.targetClass;
	}
	 
}
