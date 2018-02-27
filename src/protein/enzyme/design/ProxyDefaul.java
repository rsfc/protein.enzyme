package protein.enzyme.design;
 
import protein.enzyme.design.event.ErrorListener; 

/**代理默认设置拦截监听，只监听异常
 * @author fjy 
 * @version 2014年8月12日 下午5:13:06 
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
