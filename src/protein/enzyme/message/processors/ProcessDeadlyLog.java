package protein.enzyme.message.processors;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import protein.enzyme.io.TxtHandler;
import protein.enzyme.message.IMessageContent;
import protein.enzyme.message.IProcessor;
import protein.enzyme.message.content.DeadlyErrorLog;
import protein.enzyme.repository.ProteinResource;

@SuppressWarnings("unused")
public class ProcessDeadlyLog implements IProcessor {

	@SuppressWarnings("rawtypes")
	@Override
	public Boolean ProcessMessage(IMessageContent Content) {
		if(Content.getContentType()==DeadlyErrorLog.class)
		{ 
			Date now = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSSS");
			String timestamp = dateFormat.format(now); 
			String outString="->["+timestamp+"][Message]" +((Exception)Content.getContent()).getMessage()+ "[Content]"+((Exception)Content.getContent()).toString();
			try {
				String filename=ProteinResource.getTempOutputPath(true)+"proteinlog.txt";
				TxtHandler txth=new TxtHandler();
				txth.writerChar(outString,filename); 
			} catch (IOException e) {  
			} 
			return true;
		} 
		else {
			return false;
		}
		
	}

}
