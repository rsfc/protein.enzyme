package protein.enzyme.design;
 
import protein.enzyme.design.event.ErrorListener; 

/**����Ĭ���������ؼ�����ֻ�����쳣
 * @author fjy 
 * @version 2014��8��12�� ����5:13:06 
 */
public class ProxyDefaul implements IProxySet {
 
    /* (non-Javadoc)
	 * @see protein.enzyme.design.IProxySet#SetProxyError(protein.enzyme.design.CglibProxy)
	 */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public  void SetProxyAction(CglibProxy ProxyInter)
    {
    	ErrorListener eln=new ErrorListener(); 
    	ProxyInter.InvokeExceptionListener.add(eln); 
//    	RecordListener rl=new RecordListener();
//    	ProxyInter.InvokeBeforeListener.add(rl); 
//    	ProxyInter.InvokeAfterListener.add(rl); 
    }
   
    
    
    
}
