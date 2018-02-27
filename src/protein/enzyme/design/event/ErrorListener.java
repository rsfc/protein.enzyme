package protein.enzyme.design.event;

import java.util.EventObject; 
import protein.enzyme.PtEventListener;
import protein.enzyme.message.MessageBus;
import protein.enzyme.message.content.ContentErrorLog;

/**�쳣����
 * @author fjy 
 * @version 2014��8��12�� ����4:48:16 
 */
public class ErrorListener extends PtEventListener {
	
	@Override
	public   void fireEvent(EventObject e)
	{
		if(e instanceof ProxyEventError)
		{
			ProxyEventError pee=(ProxyEventError)e;
			ContentErrorLog cError=new ContentErrorLog();
			cError.setContent(pee.getError());
			MessageBus mBus=new MessageBus();
			mBus.Send(cError);
			//pee.getError().printStackTrace();
//			(pee.getError().printStackTrace(System.out.g);
//			System.out.print(pee.getError().printStackTrace(System.out).toString());
		}
		//System.out.print("�쳣����δʵ�� ��Ҫ��Ϣ����֧��");
	}
}
