package protein.enzyme.ExtendConfig;

import java.io.File; 
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List; 

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver; 

import protein.enzyme.layout.configuration.ExConfig;
import protein.enzyme.message.MessageBus;
import protein.enzyme.message.content.ContentErrorLog;
import protein.enzyme.repository.ProteinResource;

/**��չ������ӿ�
 * @author fjy 
 * @version 2014��9��5�� ����12:01:35 
 */
public class ECC implements IECContainer {

	protected  List<Object> container=null;
	
	public ECC()
	{
	    this.container = new ArrayList<Object>(); 
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public <T> T getExtendConfig(Class<T> cin) {
		for (Object obj : this.container)
        {
            if (obj == null)
            {
                continue;
                //throw new Exception("��չ�������ͻ�ȡʧ�ܣ�ԭ����ʵ����ʧ�ܣ�" + tagT.FullName);
            }
            if (cin.isInterface())
            {
            	for(Class pClass :obj.getClass().getInterfaces())
            	{
            		if(pClass == cin)
            		{
            			return (T)obj;
            		}
            	}  
            }
            else
            {
                if (obj.getClass() == cin)
                {
                    return (T)obj;
                }
                else if (obj.getClass().getName() == cin.getName())
                {
                    return (T)obj;
                }
            } 
        }
		return null;
	}

	@Override
	public void addExtendConfig(Object NewObject) {
		 this.container.add(NewObject);
	}

	@Override
	public void addExtendConfig(ExConfig ExConfig) {
		String filename=ProteinResource.getSysConfigPath(false)+ExConfig.ConfigXML;
		File xmlFile=new File(filename);
	    if(xmlFile.exists())
	    {
    		XStream redStream = new XStream(new DomDriver());
    		Object obj= redStream.fromXML(xmlFile);
    		if (obj != null)
	        {
	            addExtendConfig(obj);
	        }
	        else
	        {
	        	MessageBus mBus=new MessageBus();
	        	ContentErrorLog cError=new ContentErrorLog();
	        	cError.setContent(new Exception("��չ���ü���ʧ�ܡ� xml:" + filename));
	        	mBus.Send(cError); 
	        }
	    }
	    else {
	    	MessageBus mBus=new MessageBus();
        	ContentErrorLog cError=new ContentErrorLog();
        	cError.setContent(new Exception("��չ�����ļ������ڡ� xml:" + filename));
        	mBus.Send(cError);  
		}
        
	}
	
	/**��������
	 * @author   fjy
	 * @version 2014��9��16�� ����4:24:21 
	 * @param XmlFile
	 * @param Obj
	 */
	public <T> void SaveExtendConfig(String XmlFile,T Obj)
    {
		String filename=ProteinResource.getSysConfigPath(false)+XmlFile;
        Boolean hassave=SaveConfig(filename, Obj);  
    }
 
    protected <T> Boolean SaveConfig(String XmlFile, T Obj)
    {
        try
        {
        	PrintWriter pw=  new PrintWriter(XmlFile,  "UTF-8" );  
        	XStream xStream = new XStream(new DomDriver());
        	xStream.toXML(Obj, pw);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
    
	 
	
}
