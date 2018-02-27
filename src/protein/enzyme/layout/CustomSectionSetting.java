package protein.enzyme.layout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver; 
import protein.enzyme.layout.configuration.LogConfig;
import protein.enzyme.layout.configuration.MessageBusConfig;
import protein.enzyme.layout.configuration.PtSetting;
import protein.enzyme.log.LogType;
import protein.enzyme.repository.ProteinResource;

/**setting���ù��ܵĴ�ֱ������
 * @author fjy 
 * @version 2014��8��18�� ����1:53:46 
 */
public class CustomSectionSetting {
		
	private PtSetting setting=null;
	
	/**��ȡ����
	 * @author   fjy
	 * @version 2014��8��18�� ����2:00:56 
	 * @return
	 */
	public PtSetting getSetting()
	{
		return this.setting;
	}
	
	/**�������ö���
	 * @author   fjy
	 * @version 2014��8��18�� ����2:00:54 
	 * @param SettingObj
	 */
	public void setSetting(PtSetting SettingObj)
	{
		this.setting=SettingObj;
	}
	
	public CustomSectionSetting() throws FileNotFoundException, UnsupportedEncodingException
	{
		SettingConfig();
	}
	
	/**��ȡ�ͳ�ʼ��������
	 * @author   fjy
	 * @version 2014��8��18�� ����2:02:15 
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	protected void SettingConfig() throws FileNotFoundException, UnsupportedEncodingException{  
		String configpathString=ProteinResource.getSysConfigPath(true);
	    File xmlFile=new File(configpathString+"/"+ProteinResource.PTSETTING);
	    if(xmlFile.exists())
	    {
	    	XStream redStream = new XStream(new DomDriver());
	    	this.setting= (PtSetting)redStream.fromXML(xmlFile); 
	    }
	    else {
	    	this.setting=SetInit(); 
	    	PrintWriter pw=  new PrintWriter(xmlFile.getPath(),  "UTF-8" );  
	    	XStream xStream = new XStream(new DomDriver());
	    	xStream.toXML(this.setting, pw);
	    	pw.close();
		}
	}
	
	/**��ʼ��
	 * @author   fjy
	 * @version 2014��8��18�� ����2:04:24 
	 * @return
	 */
	protected  PtSetting  SetInit(){
		PtSetting result=new PtSetting();
		result.MessageOrgan=new MessageBusConfig();
		result.MessageOrgan.HistoryMaxCount=100; 
		result.MessageOrgan.UseHistory=false; 
		result.LogOrgan=new LogConfig();
		result.LogOrgan.RecordLevel=LogType.error; 
		return result;
		
	}
}
