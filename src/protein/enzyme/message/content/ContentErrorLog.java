package protein.enzyme.message.content;

import protein.enzyme.log.ILogger;
import protein.enzyme.message.IMessageContent;

/**异常内容对象
 * @author fjy 
 * @version 2014年8月19日 下午5:59:01 
 */
public class ContentErrorLog implements  IMessageContent<Exception>{ 
	
	/**
	 * @author   fjy
	 * @version 2014年8月19日 下午6:01:16 
	 */
	private Exception error=null;
	
 
	@Override
	public Class getContentType() { 
		return ContentErrorLog.class;
	}

	@Override
	public Exception getContent() { 
		return this.error;
	}

	@Override
	public void setContent(Exception content) {
		 this.error=content;
	}

}
