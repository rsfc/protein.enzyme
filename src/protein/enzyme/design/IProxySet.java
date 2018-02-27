package protein.enzyme.design;

public interface IProxySet {

	/**设置代理拦截器异常处理
	 * @author   fjy
	 * @version 2014年8月12日 下午5:01:49 
	 * @param ProxyInter
	 */
	@SuppressWarnings("rawtypes")
	public abstract void SetProxyAction(CglibProxy ProxyInter);

 

}