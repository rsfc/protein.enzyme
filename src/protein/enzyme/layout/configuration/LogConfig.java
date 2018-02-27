package protein.enzyme.layout.configuration;

import protein.enzyme.log.LogType; 

/**日志配置
 * @author fjy 
 * @version 2014年8月18日 下午1:35:21 
 */
public class LogConfig {
	
	/**记录消息级别
	 * @author   fjy
	 * @version 2014年8月18日 下午1:35:13 
	 */
	public LogType   RecordLevel =LogType.debug;
	
	/**程序集名称
	 * @author   fjy
	 * @version 2014年8月20日 下午11:43:49 
	 */
	public String DalAssemblyName="";
	
	/**类全名
	 * @author   fjy
	 * @version 2014年8月20日 下午11:43:47 
	 */
	public String DalFullClassName="";
}
