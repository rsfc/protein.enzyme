package protein.enzyme.log;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

import protein.enzyme.design.ClassDrive;
import protein.enzyme.layout.CustomSectionSetting;
import protein.enzyme.repository.ProteinResource;

/**
 * @author fjy 
 * @version 2014��8��18�� ����3:06:14 
 */
public class LoggerManager {
 
	/**jar����ַ
	 * @author   fjy
	 * @version 2014��8��20�� ����10:54:40 
	 */
	private String jarUrl="";
	
	/**��ȫ��
	 * @author   fjy
	 * @version 2014��8��20�� ����10:54:42 
	 */
	private String fullClassName="";
	
	/**Ĭ�϶�ȡ�����ļ��е���־����
	 * 
	 */
	public LoggerManager()
	{ 
		try {
			CustomSectionSetting css=new CustomSectionSetting();
			this.jarUrl=css.getSetting().LogOrgan.DalAssemblyName;
			this.fullClassName=css.getSetting().LogOrgan.DalFullClassName;
		} catch (FileNotFoundException | UnsupportedEncodingException e) { 
			 
		}
	}
	
	/**��ȡ��־��¼��ʵ��
	 * @author   fjy
	 * @version 2014��9��17�� ����2:43:42 
	 * @return
	 */
	public ILogger getProteinLogger()
	{
//		String jarurl=ProteinResource.getProteinBasePath()+this.jarUrl+".jar";
		return this.createLogger(this.fullClassName);
	}
	 
    /**������־��¼������
     * @author   fjy
     * @version 2014��8��18�� ����3:06:46 
     * @param JarUrl jar��·��
     * @param FullClassName Ҫʵ����������
     * @return
     */
    protected   ILogger createLogger(String FullClassName)
    {
        ILogger result=null;
        ClassDrive cDrive=new ClassDrive();
        try {
        	result=cDrive.ProxyInstance(ILogger.class, FullClassName, null, null);
		} catch (MalformedURLException | ClassNotFoundException
				| InstantiationException | IllegalAccessException e) { 
		 
		} 
        return result;
    }
}
