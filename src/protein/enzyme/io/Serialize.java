package protein.enzyme.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException; 

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**���л�������
 * @author fjy 
 * @version 2014��8��19�� ����1:14:09 
 */
public class Serialize {
	
	/**�������л�Ϊxml�ļ�
	 * @author   fjy
	 * @version 2014��8��19�� ����1:31:24 
	 * @param FileName
	 * @param SourceObject
	 */
	public void objectToFile(String FileName,Object SourceObject){
		File xmlFile=new File(FileName); 
		PrintWriter pw=null;
		try {
			pw = new PrintWriter(xmlFile.getPath(),  "UTF-8" );
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			 
		}  
    	XStream xStream = new XStream(new DomDriver());
    	xStream.toXML(SourceObject, pw);
    	pw.close(); 
	}
	
	/**�������л�Ϊ�ַ���
	 * @author   fjy
	 * @version 2014��8��19�� ����1:31:24 
	 * @param FileName
	 * @param SourceObject
	 */
	public String objectToString(Object SourceObject){ 
    	XStream xStream = new XStream(new DomDriver());
    	return xStream.toXML(SourceObject);  
	}
	
	/**����xml�ַ������з����л�
	 * @author   fjy
	 * @version 2014��8��19�� ����1:48:45 
	 * @param Cin
	 * @param SourceXML
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T objectFormString(Class<T> Cin, String SourceXML){
		T resulT=null;
		XStream redStream = new XStream(new DomDriver());
		resulT= (T)redStream.fromXML(SourceXML);
		return resulT; 
	}
}
