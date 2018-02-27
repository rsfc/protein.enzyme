package protein.enzyme.message;

import java.util.ArrayList;
import java.util.List;

import protein.enzyme.design.ClassDrive;
import protein.enzyme.repository.ProteinResource;

/**��Ϣ����
 * @author fjy 
 * @version 2014��8��18�� ����2:42:58 
 */
public class MessageBus   {
 
	private ClassDrive cDrive=new ClassDrive();
	
    /**��Ϣ����
     * 
     */
	public MessageBus()
    { 
    	
    }
  
	/**������Ϣ
	 * @author   fjy
	 * @version 2014��8��19�� ����5:41:51 
	 * @param content
	 */
	public Integer Send(IMessageContent content) { 
		Integer result=0;
	 	List<PoolHde> hPoolHdes=ProcessorPool.getIns().getProcessors(content.getContentType());
	 	List<IProcessor> prolistIProcessors=this.InitProcess(hPoolHdes); 
	 	for (IProcessor pocIProcessor :prolistIProcessors) {
	 		Boolean isprc=pocIProcessor.ProcessMessage(content);
	 		if(isprc)
	 		{
	 			result++;
	 		}
		}
	 	return result;
	}
	
	/**��ʼ��������
	 * @author   fjy
	 * @version 2014��8��23�� ����10:34:29 
	 * @param cass
	 * @param hdes
	 * @return
	 */
	private List<IProcessor> InitProcess(List<PoolHde> hdes){
		List<IProcessor> result=new ArrayList<IProcessor>();
		for(PoolHde ph : hdes)
		{
			List<Object> args=ph.getAgrs();
			Class[] cs=null;
			Object[] values=null;
			if(args.size()>0)
			{
				cs=new Class[hdes.size()];
				values=new Object[hdes.size()];
				int index=0;
				for(Object ov :args)
				{
					if(ov!=null)
					{
						cs[index]=ProteinResource.getBaseClassType(ov.getClass(),ov);
						values[index]=ov;
						index++;
					}
					
				}
			}
			@SuppressWarnings("unchecked")
			IProcessor newprc=(IProcessor)cDrive.ProxyInstance(ph.getNewProcessorType(), values);
			result.add(newprc); 
		}
		return result;
	}

	 

}
