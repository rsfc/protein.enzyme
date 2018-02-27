package protein.enzyme.message.processors;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import protein.enzyme.io.TxtHandler;
import protein.enzyme.message.IMessageContent;
import protein.enzyme.message.IProcessor;
import protein.enzyme.message.content.BasisText;
import protein.enzyme.message.content.ContentDebugLog;
import protein.enzyme.message.content.ContentNoteLog;
import protein.enzyme.message.content.DeadlyErrorLog;
import protein.enzyme.repository.ProteinResource;

/**
 * 蛋白质提供的基础日志记录，独立于数据库日志，在临时文件夹下生成按照日期命名的日志文本文件
 * @author fjy
 * @version 2016年9月20日 下午12:11:41
 */
@SuppressWarnings("unused")
public class ProcessBasisTextLog implements IProcessor {

	@SuppressWarnings("rawtypes")
	@Override
	public Boolean ProcessMessage(IMessageContent Content) {
		if(Content.getContentType()==BasisText.class )
		{ 
			Date now = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSSS");
			String timestamp = dateFormat.format(now); 
			String outString="->["+timestamp+"][Message]" +Content.getContent()+ "[Content]"+Content.getContent();
			try {
				SimpleDateFormat fileformat = new SimpleDateFormat("yyyy-MM-dd"); 
				String filename=ProteinResource.getTempOutputPath(true)+"ptbt_"+fileformat.format(now)+".txt";
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
