package protein.enzyme.repository;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
 

/**资源管理类
 * @author fjy 
 * @version 2014年8月14日 上午11:40:34 
 */
public class ProteinResource {
	
	/**数据驱动层配置文件名称
	 * @author   fjy
	 * @version 2014年8月18日 下午1:22:02 
	 */
	public static final String PTDBCONFIG="protein.enzyme.db.xml";
	
	/**pt设置文件
	 * @author   fjy
	 * @version 2014年8月18日 下午1:23:21 
	 */
	public static final String PTSETTING="protein.setting.xml";
	
	
	/**获取支撑类库的临时输出文件夹路径
	 * @author   fjy
	 * @version 2014年9月7日 下午2:19:35 
	 * @param isCreation
	 * @return
	 */
	public static String getTempOutputPath(Boolean isCreation)
	{
		String result=""; 
	    File licdirectory=new File(getProteinLicPath()+"/tmp/");
	    if(!licdirectory.exists())
	    {
	    	if(isCreation)
	    	{ 
	    		if(licdirectory.mkdir())
	    		{
	    			result=licdirectory.getPath();
	    		}
	    	}
	    }
	    else {
	    	result=licdirectory.getPath();
		}
	    return result+"\\";
	}
	
	/**获取支撑类库的基础位置,根据类运行位置获取程序根目录
	 * @author   fjy
	 * @version 2014年9月16日 上午12:30:18 
	 * @return
	 */
	@SuppressWarnings("unused")
	public static String getProteinLicPath()
	{
		String result="";
		File directory = new File("");  
//		result=ProteinResource.class.getProtectionDomain().getCodeSource().getLocation().getFile();
		try {
			result=ProteinResource.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    File licdirectory=new File(result);
	    if(licdirectory.isDirectory())
	    { 
	    	 return licdirectory.getParent();
	    }
	    else if(licdirectory.isFile()) {
	    	File tmpFile=new File(licdirectory.getParent());
	    	return tmpFile.getParent();
		}
	    else {
			return "";
		}
	    
	}
	
//	/**获取运行的程序的lic目录
//	 * @author   fjy
//	 * @version 2014年12月18日 上午10:33:13 
//	 * @return
//	 */
//	public static  String getSysLicPath() { 
//       String realPath = ProteinResource.class .getClassLoader().getResource("").getFile(); 
//       java.io.File file = new java.io.File(realPath); 
//       realPath = file.getAbsolutePath(); 
//       try { 
//           realPath = java.net.URLDecoder.decode (realPath, "utf-8"); 
//       } catch (Exception e) { 
//           e.printStackTrace(); 
//       } 
//       return realPath; 
//    }

//	 
//	/**获取支撑类库的基础位置,根据类运行位置获取程序根目录
//	 * @author   fjy
//	 * @version 2014年9月16日 上午12:30:18 
//	 * @return
//	 */
//	@SuppressWarnings("unused")
//	public static String getSysBasePath()
//	{
//		String libPath=getProteinLicPath(); 
//	    File licdirectory=new File(libPath);
//	    if(licdirectory.isDirectory())
//	    { 
//	    	 return licdirectory.getParent();
//	    } 
//	    else {
//			return "";
//		}  
//	}
 
	
	/**获取支撑类库的config环境文件夹路径
	 * @author   fjy
	 * @version 2014年8月14日 下午12:01:33 
	 * @param isCreation
	 * @return
	 */
	public static String getSysConfigPath(Boolean isCreation)
	{
		String result=""; 
	    File licdirectory=new File(getProteinLicPath()+"/config/");
	    if(!licdirectory.exists())
	    {
	    	if(isCreation)
	    	{ 
	    		if(licdirectory.mkdir())
	    		{
	    			result=licdirectory.getPath();
	    		}
	    	}
	    }
	    else {
	    	result=licdirectory.getPath();
		}
	    return result+"\\";//licdirectory.getPath();
	}
	
	/**获取当前时间
	 * @author   fjy
	 * @version 2014年8月18日 下午2:25:43 
	 * @return
	 */
	public static String getNowDateTime()
	{ 
		  Date d = new Date();
		  long longtime = d.getTime();
		  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");        
		  return sdf.format(longtime);
//		  System.out.println(sdf.format(longtime));
	}
	
	/**判断是否为代理类型，如果是代理类型则获取其源类型
	 * @author   fjy
	 * @version 2014年8月24日 下午11:00:34 
	 * @param tClassInit
	 * @return
	 */
	public static Class getBaseClassType(Object tClassInit)
	{
		Class result=null;
		String classString=tClassInit.getClass().getName();
		if(classString.indexOf("$$")>-1)
		{
			result=tClassInit.getClass().getSuperclass(); 
		} 
		return result;
	}
	
	/**判断是否为代理类型，如果是代理类型则获取其源类型
	 * @author   fjy
	 * @version 2014年8月24日 下午10:13:44 
	 * @return
	 */
	public static Class getBaseClassType(Class tClass,Object tClassInit)
	{
		Class result=tClass;
		String classString=tClass.getName();
		if(classString.indexOf("$$")>-1)
		{
//			String sourceClass=classString.substring(0,classString.indexOf("$$")); 
			result=tClassInit.getClass().getSuperclass(); 
		} 
		return result;
	}
	
	/**判断是否为代理类型，如果是代理类型则获取其源接口
	 * @author   fjy
	 * @version 2014年8月24日 下午10:13:44 
	 * @return
	 */
	public static Class[] getBaseInterfaceType(Class tClass,Object tClassInit)
	{
		Class[] result=null;
		String classString=tClass.getName();
		if(classString.indexOf("$$")>-1)
		{
			result=tClassInit.getClass().getInterfaces(); 
		} 
		return result;
	}
	
	
}
