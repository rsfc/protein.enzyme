package protein.enzyme.design.event;

import java.util.EventObject;

import protein.enzyme.PtEventListener; 

/**��¼����
 * @author fjy 
 * @version 2014��8��12�� ����5:03:33 
 */
public class RecordListener extends PtEventListener{

	@Override
	public void fireEvent(EventObject e) {
		System.out.print("��¼������δʵ�� ��Ҫ��Ϣ����֧��");
		
	}

//	/// <summary>
//    /// 
//    /// </summary>
//    /// <param name="Invocation"></param>
//    protected virtual void ProxyInter_InvokeAfter(IInvocation Invocation)
//    {
//        Type tclass = Invocation.Method.DeclaringType; 
//        string str = "Intercept {TIME}  Class:{CLASS}  Method:{METHOD} ";
//        str = str.Replace("{CLASS}", tclass.Name);
//        str = str.Replace("{METHOD}", Invocation.Method.Name);
//        str = str.Replace("{TIME}", "Before");
//        //MessageFactory.GetMegBus().Send(MessageFactory.CreateMessageDebug(str));
//        MessageFactory.GetMegBus().Send(MessageFactory.CreateMessagePtDebug(str)); 
//    }
}
