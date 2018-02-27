package protein.enzyme.message.content;

import protein.enzyme.log.ILogger;
import protein.enzyme.message.IMessageContent;

/**�쳣���ݶ���
 * @author fjy 
 * @version 2014��8��19�� ����5:59:01 
 */
public class ContentErrorLog implements  IMessageContent<Exception>{ 
	
	/**
	 * @author   fjy
	 * @version 2014��8��19�� ����6:01:16 
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
