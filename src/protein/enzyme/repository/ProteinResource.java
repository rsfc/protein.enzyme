package protein.enzyme.repository;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
 

/**��Դ������
 * @author fjy 
 * @version 2014��8��14�� ����11:40:34 
 */
public class ProteinResource {
	
	/**���������������ļ�����
	 * @author   fjy
	 * @version 2014��8��18�� ����1:22:02 
	 */
	public static final String PTDBCONFIG="protein.enzyme.db.xml";
	
	/**pt�����ļ�
	 * @author   fjy
	 * @version 2014��8��18�� ����1:23:21 
	 */
	public static final String PTSETTING="protein.setting.xml";
	
	
	/**��ȡ֧��������ʱ����ļ���·��
	 * @author   fjy
	 * @version 2014��9��7�� ����2:19:35 
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
	
	/**��ȡ֧�����Ļ���λ��,����������λ�û�ȡ�����Ŀ¼
	 * @author   fjy
	 * @version 2014��9��16�� ����12:30:18 
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
	
//	/**��ȡ���еĳ����licĿ¼
//	 * @author   fjy
//	 * @version 2014��12��18�� ����10:33:13 
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
//	/**��ȡ֧�����Ļ���λ��,����������λ�û�ȡ�����Ŀ¼
//	 * @author   fjy
//	 * @version 2014��9��16�� ����12:30:18 
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
 
	
	/**��ȡ֧������config�����ļ���·��
	 * @author   fjy
	 * @version 2014��8��14�� ����12:01:33 
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
	
	/**��ȡ��ǰʱ��
	 * @author   fjy
	 * @version 2014��8��18�� ����2:25:43 
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
	
	/**�ж��Ƿ�Ϊ�������ͣ�����Ǵ����������ȡ��Դ����
	 * @author   fjy
	 * @version 2014��8��24�� ����11:00:34 
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
	
	/**�ж��Ƿ�Ϊ�������ͣ�����Ǵ����������ȡ��Դ����
	 * @author   fjy
	 * @version 2014��8��24�� ����10:13:44 
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
	
	/**�ж��Ƿ�Ϊ�������ͣ�����Ǵ����������ȡ��Դ�ӿ�
	 * @author   fjy
	 * @version 2014��8��24�� ����10:13:44 
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
