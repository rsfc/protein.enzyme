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

/**db���ù��ܵĴ�ֱ������
 * @author fjy 
 * @version 2014��8��12�� ����11:11:49 
 */
public class CustomSectionDb {
	
	private DataBaseConfig dBConfig=null;
	
	/**��ȡ���ݿ�����ʵ��
	 * @author   fjy
	 * @version 2014��8��12�� ����12:19:53 
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
	
	/**��ʼ�����ݿ�����
	 * @author   fjy
	 * @version 2014��8��12�� ����12:15:51 
	 * @throws UnsupportedEncodingException 
	 * @throws FileNotFoundException 
	 */
	protected void DbConfig() throws FileNotFoundException, UnsupportedEncodingException{  
		String configpathString=ProteinResource.getSysConfigPath(true);
	    File xmlFile=new File(configpathString+"/"+ProteinResource.PTDBCONFIG);
	    System.out.println("-----------------");
	    System.out.println("a: "+System.getProperty("user.dir"));
	    File directory = new File("");//�趨Ϊ��ǰ�ļ��� 
	        try {
				System.out.println("b: "+directory.getCanonicalPath());
				System.out.println("b: "+directory.getAbsolutePath());//��ȡ����·��
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//��ȡ��׼��·��
	        
	 
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
	    	dbdl.dalKey="���ݿ������ؼ���"; 
	    	dbdl.dalEntityFactoryFullName="������ʵ�幤����ȫ��"; 
	    	this.dBConfig.DalList.put(dbdl.dalKey,dbdl);
	    	PrintWriter pw=  new PrintWriter(xmlFile.getPath(),  "UTF-8" );  
	    	XStream xStream = new XStream(new DomDriver());
	    	xStream.toXML(this.dBConfig, pw);
	    	pw.close();
		}
	}
	
}
