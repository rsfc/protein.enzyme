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

/**setting配置功能的垂直管理类
 * @author fjy 
 * @version 2014年8月18日 下午1:53:46 
 */
public class CustomSectionSetting {
		
	private PtSetting setting=null;
	
	/**获取设置
	 * @author   fjy
	 * @version 2014年8月18日 下午2:00:56 
	 * @return
	 */
	public PtSetting getSetting()
	{
		return this.setting;
	}
	
	/**设置设置对象
	 * @author   fjy
	 * @version 2014年8月18日 下午2:00:54 
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
	
	/**读取和初始设置配置
	 * @author   fjy
	 * @version 2014年8月18日 下午2:02:15 
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
	
	/**初始化
	 * @author   fjy
	 * @version 2014年8月18日 下午2:04:24 
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
