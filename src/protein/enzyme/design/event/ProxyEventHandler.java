package protein.enzyme.design.event;
import java.lang.reflect.Method;
import java.util.EventObject;  

import net.sf.cglib.proxy.MethodProxy;

 
/**拦截方法事件句柄
 * @author fjy
 *
 */
public class ProxyEventHandler extends EventObject {

	/**
	 * @author   fjy
	 * @version 2014年9月7日 下午8:21:12 
	 */
	private static final long serialVersionUID = 1L;

	public Method getTargetMethod() {
		return targetMethod;
	}
 
	public Object[] getTargetArgsObjects() {
		return targetArgsObjects;
	}

	 

	public Object getProxyobjObject() {
		return proxyobjObject;
	}

	public Object getMethodProxy() {
		return methodProxy;
	}

	private	Method targetMethod=null;
	private Object[] targetArgsObjects=null;
	private Object proxyobjObject=null;
	private MethodProxy methodProxy=null;
	 
	public ProxyEventHandler(Object source,Method method,Object[] args) {
		super(source); 
		this.targetMethod=method;
		this.targetArgsObjects=args;
	}
 
	 	
	public ProxyEventHandler(Object proxy, Method method, Object[] params,MethodProxy methodProxy){
	            super(proxy);
        this.targetMethod=method;
		this.targetArgsObjects=params;
		this.proxyobjObject=proxy;
		this.methodProxy=methodProxy;
	 }
}
