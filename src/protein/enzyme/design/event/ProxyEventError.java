package protein.enzyme.design.event;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method; 

import protein.enzyme.repository.ProteinResource;
import net.sf.cglib.proxy.MethodProxy;

/**代理异常
 * @author fjy 
 * @version 2014年8月12日 下午4:24:59 
 */
public class ProxyEventError  extends ProxyEventHandler {

	/**
	 * @author   fjy
	 * @version 2014年9月7日 下午8:20:55 
	 */
	private static final long serialVersionUID = 1L;
	private Exception errorException=null;
	/**
	 * @author   fjy
	 * @version 2014年8月12日 下午4:26:26 
	 * @return
	 */
	public Exception getError()
	{ 
		return this.errorException;
	}
	/**
	 * @param proxy
	 * @param method
	 * @param params
	 * @param methodProxy
	 * @param e
	 */
	public ProxyEventError(Object proxy, Method method, Object[] params,MethodProxy methodProxy,Exception e) {
		super( proxy, method, params, methodProxy);
		 this.errorException=e;
		 String className=ProteinResource.getBaseClassType(proxy).getName();
		 String methodName=method.getName();
		 String errh="aop:"+className+"."+methodName;
		 //
		 ByteArrayOutputStream baos = new ByteArrayOutputStream();
		 e.printStackTrace(new PrintStream(baos));
		 String exception = baos.toString();
		 System.out.println(errh+"\r\n" + exception);
		 this.errorException=new Exception(errh+"\r\n" + exception);
	}

}
