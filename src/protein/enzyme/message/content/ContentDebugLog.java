package protein.enzyme.message.content;

import protein.enzyme.log.ILogger;
import protein.enzyme.message.IMessageContent;

/**调试消息
 * @author fjy 
 * @version 2014年9月17日 上午1:15:37 
 */
public class ContentDebugLog implements IMessageContent<String>{

	private String contentString="";
	 
	
	public ContentDebugLog( )
	{ 
	}
	@Override
	public Class getContentType() { 
		return ContentDebugLog.class;
	}

	@Override
	public String getContent() { 
		return this.contentString;
	}

	@Override
	public void setContent(String content) {
		this.contentString=content; 
	}

}
 