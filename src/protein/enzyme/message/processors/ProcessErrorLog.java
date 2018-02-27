package protein.enzyme.message.processors;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import protein.enzyme.layout.CustomSectionSetting;
import protein.enzyme.log.ILogger;
import protein.enzyme.log.LogType;
import protein.enzyme.message.IMessageContent;
import protein.enzyme.message.IProcessor; 
import protein.enzyme.message.MessageBus;
import protein.enzyme.message.content.ContentErrorLog;
import protein.enzyme.message.content.DeadlyErrorLog;

/**异常处理器
 * @author fjy 
 * @version 2014年8月19日 下午9:56:18 
 */
public class ProcessErrorLog implements IProcessor {

	CustomSectionSetting css=null;
	/**
	 * @author   fjy
	 * @version 2014年8月19日 下午6:01:14 
	 */
	private ILogger logger=null;
	
	/**
	 * @param Logger
	 */
	public ProcessErrorLog(ILogger Logger)
	{ 
		try {
			this.css=new CustomSectionSetting();
		} catch (FileNotFoundException e) { 
			 
		} catch (UnsupportedEncodingException e) { 
			 
		}
		this.logger=Logger;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public Boolean ProcessMessage(IMessageContent Content) {
		 if (LogType.error.ordinal()< this.css.getSetting().LogOrgan.RecordLevel.ordinal())
	     {
	         return false;
	     } 
		if(Content.getContentType()==ContentErrorLog.class)
		{   
			try {
				this.logger.Error((Exception)Content.getContent());
			} catch (Exception e) {
				DeadlyErrorLog deadlyErrorLog=new DeadlyErrorLog();
				deadlyErrorLog.setContent(new Exception("日志记录失败"));
				MessageBus messageBus=new MessageBus();
				messageBus.Send(deadlyErrorLog);
			} 
			return true;
		}
		else { 
			return false;
		}
	}

 

	 

}
