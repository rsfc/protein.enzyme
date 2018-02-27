package protein.enzyme.message;

/**消息内容接口
 * @author fjy 
 * @version 2014年8月19日 下午1:01:16 
 */
public interface IMessageContent<T> {
	/**获取内容类型
	 * @author   fjy
	 * @version 2014年8月19日 下午5:48:47 
	 * @return
	 */
	Class getContentType(); 
	
	/**获取内容
	 * @author   fjy
	 * @version 2014年8月19日 下午5:52:03 
	 * @return
	 */
	T getContent();
	
	/**设置内容
	 * @author   fjy
	 * @version 2014年8月19日 下午9:58:11 
	 * @param content
	 */
	void setContent(T content);
	
}
