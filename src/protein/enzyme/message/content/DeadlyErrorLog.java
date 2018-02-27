package protein.enzyme.message.content;

import protein.enzyme.message.IMessageContent;

public class DeadlyErrorLog implements  IMessageContent<Exception>{

	private Exception error=null;
	
	@Override
	public Class getContentType() {
		 
		return DeadlyErrorLog.class;
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
