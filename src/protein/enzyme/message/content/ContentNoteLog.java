package protein.enzyme.message.content;

import protein.enzyme.message.IMessageContent;

/**�ı�����
 * @author fjy 
 * @version 2014��8��23�� ����9:23:57 
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
