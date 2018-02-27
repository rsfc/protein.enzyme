package protein.enzyme.layout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
 

import java.io.UnsupportedEncodingException;

import protein.enzyme.layout.configuration.DataBaseConfig;
import protein.enzyme.layout.configuration.DbDal;
import protein.enzyme.repository.ProteinResource;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**db配置功能的垂直管理类
 * @author fjy 
 * @version 2014年8月12日 下午11:11:49 
 */
public class CustomSectionDb {
	
	private DataBaseConfig dBConfig=null;
	
	/**获取数据库配置实例
	 * @author   fjy
	 * @version 2014年8月12日 下午12:19:53 
	 * @return
	 */
	public DataBaseConfig getDBConfig()
	{
		return this.dBConfig; 
	}
	
	/**
	* @throws UnsupportedEncodingException 
	* @throws FileNotFoundException 
	* 
	*/
	public  CustomSectionDb() throws FileNotFoundException, UnsupportedEncodingException
	{ 
		DbConfig();
	}
	
	/**初始化数据库配置
	 * @author   fjy
	 * @version 2014年8月12日 下午12:15:51 
	 * @throws UnsupportedEncodingException 
	 * @throws FileNotFoundException 
	 */
	protected void DbConfig() throws FileNotFoundException, UnsupportedEncodingException{  
		String configpathString=ProteinResource.getSysConfigPath(true);
	    File xmlFile=new File(configpathString+"/"+ProteinResource.PTDBCONFIG);
	    System.out.println("-----------------");
	    System.out.println("a: "+System.getProperty("user.dir"));
	    File directory = new File("");//设定为当前文件夹 
	        try {
				System.out.println("b: "+directory.getCanonicalPath());
				System.out.println("b: "+directory.getAbsolutePath());//获取绝对路径
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//获取标准的路径
	        
	 
	    System.out.println("-----------------");
	    System.out.println(configpathString);
	    if(xmlFile.exists())
	    {
	    	XStream redStream = new XStream(new DomDriver());
	    	this.dBConfig= (DataBaseConfig)redStream.fromXML(xmlFile);
	    }
	    else {
	    	this.dBConfig=new DataBaseConfig();
	    	DbDal dbdl=new DbDal();
	    	dbdl.dalKey="数据库驱动关键字"; 
	    	dbdl.dalEntityFactoryFullName="驱动层实体工厂类全名"; 
	    	this.dBConfig.DalList.put(dbdl.dalKey,dbdl);
	    	PrintWriter pw=  new PrintWriter(xmlFile.getPath(),  "UTF-8" );  
	    	XStream xStream = new XStream(new DomDriver());
	    	xStream.toXML(this.dBConfig, pw);
	    	pw.close();
		}
	}
	
}
