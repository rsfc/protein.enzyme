package protein.enzyme.message;

/**处理消息
 * @author fjy 
 * @version 2014年8月18日 下午12:57:39 
 */
public interface IProcessor  {
	 
    /**处理消息
     * @author   fjy
     * @version 2014年8月18日 下午12:58:01 
     * @param Content
     */
    Boolean ProcessMessage(IMessageContent Content);
    
 
}
