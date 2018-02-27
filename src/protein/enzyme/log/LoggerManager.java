package protein.enzyme.log;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

import protein.enzyme.design.ClassDrive;
import protein.enzyme.layout.CustomSectionSetting;
import protein.enzyme.repository.ProteinResource;

/**
 * @author fjy 
 * @version 2014年8月18日 下午3:06:14 
 */
public class LoggerManager {
 
	/**jar包地址
	 * @author   fjy
	 * @version 2014年8月20日 下午10:54:40 
	 */
	private String jarUrl="";
	
	/**类全名
	 * @author   fjy
	 * @version 2014年8月20日 下午10:54:42 
	 */
	private String fullClassName="";
	
	/**默认读取配置文件中的日志对象
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
	
	/**获取日志记录器实例
	 * @author   fjy
	 * @version 2014年9月17日 下午2:43:42 
	 * @return
	 */
	public ILogger getProteinLogger()
	{
//		String jarurl=ProteinResource.getProteinBasePath()+this.jarUrl+".jar";
		return this.createLogger(this.fullClassName);
	}
	 
    /**创建日志记录器对象
     * @author   fjy
     * @version 2014年8月18日 下午3:06:46 
     * @param JarUrl jar包路径
     * @param FullClassName 要实例化类名称
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
