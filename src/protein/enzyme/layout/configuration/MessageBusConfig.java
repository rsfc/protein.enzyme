package protein.enzyme.layout.configuration;

 

/**消息总线的机构配置
 * @author fjy 
 * @version 2014年8月18日 下午1:32:09 
 */
public class MessageBusConfig {
	/**是否使用消息总线历史记录
	 * @author   fjy
	 * @version 2014年8月18日 下午1:27:41 
	 */
	public Boolean  UseHistory=false;
	
	/**历史消息最大数量
	 * @author   fjy
	 * @version 2014年8月18日 下午1:30:49 
	 */
	public Integer  HistoryMaxCount=100;
//	/**消息处理级别
//	 * @author   fjy
//	 * @version 2014年8月18日 下午1:28:31 
//	 */
//	public  MessageType  OrganLevel=MessageType.Debug;
}
