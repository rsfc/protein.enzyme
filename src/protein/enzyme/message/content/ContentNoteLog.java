package protein.enzyme.message.content;

import protein.enzyme.message.IMessageContent;

/**文本内容
 * @author fjy 
 * @version 2014年8月23日 下午9:23:57 
 */
public class ContentNoteLog implements IMessageContent<String> {
	private String contentString="";

	@Override
	public Class  getContentType() { 
		return ContentNoteLog.class;
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
