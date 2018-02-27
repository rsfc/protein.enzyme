package protein.enzyme.message.processors;
 
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import protein.enzyme.layout.CustomSectionSetting;
import protein.enzyme.log.ILogger;
import protein.enzyme.log.LogType;
import protein.enzyme.message.IMessageContent;
import protein.enzyme.message.IProcessor;
import protein.enzyme.message.content.ContentNoteLog;

/**�ı�������
 * @author fjy 
 * @version 2014��8��23�� ����9:26:32 
 */
public class ProcessNoteLog implements IProcessor{
 
	/**
	 * @author   fjy
	 * @version 2014��8��19�� ����6:01:14 
	 */
	private ILogger logger=null;
	CustomSectionSetting css=null;
	public ProcessNoteLog(ILogger Logger)
	{ 
		this.logger=Logger;
		try {
			css=new CustomSectionSetting();
		} catch (FileNotFoundException e) {
			 
		} catch (UnsupportedEncodingException e) {
			 
		}
	}
	
	 
	@SuppressWarnings("rawtypes")
	@Override
	public Boolean ProcessMessage(IMessageContent Content) {
		if (LogType.info.ordinal()< this.css.getSetting().LogOrgan.RecordLevel.ordinal())
	     {
	         return false;
	     } 
		if(Content.getContentType()==ContentNoteLog.class)
		{ 
			this.logger.Info(Content.getContent());
			return true;
		} 
		else {
			return false;
		}
	}

}
