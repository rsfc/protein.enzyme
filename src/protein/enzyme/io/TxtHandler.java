package protein.enzyme.io;

import java.io.FileWriter;
import java.io.IOException;

import protein.enzyme.repository.ProteinResource;

public class TxtHandler {
	
	/**��������쳣��¼
	 * @author   fjy
	 * @version 2014��9��7�� ����2:27:53 
	 * @param tagString
	 * @throws IOException
	 */
	public void writerDealyChar(String tagString) throws IOException{
		String filename=ProteinResource.getTempOutputPath(true)+"proteinlog.txt";
		FileWriter fileWriter=new FileWriter(filename, true);
		fileWriter.write(tagString);
		fileWriter.flush();  
		fileWriter.close();
	}
	
	/**��ָ�����ı��ļ�׷���ַ���
	 * @author   fjy
	 * @version 2014��9��30�� ����2:24:55 
	 * @param tagString
	 * @param fileName
	 * @throws IOException
	 */
	public void writerChar(String tagString,String fileName) throws IOException
	{ 
		FileWriter fileWriter=new FileWriter(fileName, true);
		fileWriter.write(tagString+System.getProperty("line.separator"));
		fileWriter.flush();  
		fileWriter.close();
	}
}
