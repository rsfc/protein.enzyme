package protein.enzyme.layout.configuration;

import java.util.List;
 
/**支撑类库的设置实体类
 * @author fjy 
 * @version 2014年8月18日 下午1:24:41 
 */
public class PtSetting {
	
	/**消息配置
	 * @author   fjy
	 * @version 2014年8月18日 下午1:34:17 
	 */
	public MessageBusConfig MessageOrgan=null;
	 
	/**日志配置
	 * @author   fjy
	 * @version 2014年8月18日 下午1:49:45 
	 */
	public LogConfig LogOrgan=null;
	
	/**扩展配置集合
	 * @author   fjy
	 * @version 2014年9月5日 上午12:11:42 
	 */
	public List<ExConfig> ExConfigs=null;
}
