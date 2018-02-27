package protein.enzyme.message;

import java.util.ArrayList;
import java.util.List;

/**�ض����װ
 * @author fjy 
 * @version 2014��8��19�� ����11:09:39 
 */
public class PoolHde {
	 
	/**����
	 * @author   fjy
	 * @version 2014��8��19�� ����11:41:23 
	 */
	private  List<Object> agrs=new ArrayList<Object>();
	
	/**Ŀ������
	 * @author   fjy
	 * @version 2014��8��19�� ����11:41:54 
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
	 
	/**��ȡ����
	 * @author   fjy
	 * @version 2014��8��19�� ����11:43:21 
	 * @return
	 */
	public List<Object> getAgrs()
	{
		return this.agrs;
		
	}
	
	/**��ȡĿ����������
	 * @author   fjy
	 * @version 2014��8��19�� ����11:44:07 
	 * @return
	 */
	public Class getNewProcessorType(){
		return this.targetClass;
	}
	 
}
