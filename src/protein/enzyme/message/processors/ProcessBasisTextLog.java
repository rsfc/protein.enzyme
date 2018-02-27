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
 * �������ṩ�Ļ�����־��¼�����������ݿ���־������ʱ�ļ��������ɰ���������������־�ı��ļ�
 * @author fjy
 * @version 2016��9��20�� ����12:11:41
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
