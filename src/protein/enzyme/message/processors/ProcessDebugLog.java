package protein.enzyme.message.processors;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException; 
import protein.enzyme.layout.CustomSectionSetting;
import protein.enzyme.log.ILogger;
import protein.enzyme.log.LogType;
import protein.enzyme.message.IMessageContent;
import protein.enzyme.message.IProcessor;
import protein.enzyme.message.content.ContentDebugLog;

public class ProcessDebugLog implements IProcessor {

	private ILogger logger=null;
	CustomSectionSetting css=null;
	public ProcessDebugLog(ILogger Logger)
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
		if (LogType.debug.ordinal()< this.css.getSetting().LogOrgan.RecordLevel.ordinal())
	     {
	         return false;
	     } 
		if(Content.getContentType()==ContentDebugLog.class)
		{  
			this.logger.Debug((String)Content.getContent());
			return true;
		}
		else {
			return false;
		}
	}

}
