package protein.enzyme.design;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import protein.enzyme.io.PtFile;
import protein.enzyme.message.MessageBus;
import protein.enzyme.message.content.BasisText;
import protein.enzyme.message.content.ContentErrorLog;
import protein.enzyme.message.content.ContentNoteLog;

/** 框架类驱动 
 * @author fjy
 * @version 2014年8月12日 下午2:01:53
 */
public class ClassDrive { 
	 

	/**获取字段值
	 * @author   fjy
	 * @version 2016年6月29日 下午6:15:32 
	 * @param fieldName
	 * @param object
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object getFieldValue(Object object,String fieldName){
		Field[] fields = object.getClass().getDeclaredFields(); 
		for (int j = 0; j < fields.length; j++) {   
            if((fields[j].getName().equals(fieldName)
        		|| fields[j].getName().indexOf(fieldName)>-1 )&& fields[j].getType().equals(Method.class))
            {
            	try {
            		fields[j].setAccessible(true);  
            		Object result=fields[j].get(object);
            		Method m=(Method)result;
            		Object resulObject=m.invoke(object);
					return resulObject;
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            } 
             
        }  
		return null; 
	}
	/**
	 * 通过代理实例化指定类型,指定自定义的拦截监听
	 * 
	 * @author fjy
	 * @version 2014年8月12日 下午3:37:11
	 * @param Interface
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T ProxyInstance(Class<T> TargetClass, IProxySet Seter,
			@SuppressWarnings("rawtypes") Class[] ArgsTypes, Object[] Values) {
		@SuppressWarnings("rawtypes")
		CglibProxy cp = new CglibProxy();
		T result = null;
		if (ArgsTypes == null) {
			result = (T) cp.createProxy(TargetClass);
		} else {
			result = (T) cp.createProxy(TargetClass, ArgsTypes, Values);
		}
		Seter.SetProxyAction(cp);
		return result;
	}

	/**  通过代理实例化指定类型,指定自定义的拦截监听、参数 
	 * @author fjy
	 * @version 2014年8月24日 下午11:05:11
	 * @param TargetClass
	 * @param Seter
	 * @param Values
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T ProxyInstance(Class<T> TargetClass, Object[] Values) {
		IProxySet ppsd = new ProxyDefaul();
		@SuppressWarnings("rawtypes")
		CglibProxy cp = new CglibProxy();
		T result = null;
		if (Values == null) {
			result = (T) cp.createProxy(TargetClass);
		} else {
			result = (T) cp.createProxy(TargetClass, Values);
		}
		ppsd.SetProxyAction(cp);
		return result;
	}

	/**
	 * 通过代理实例化指定类型,添加默认的aop拦截监听
	 * 
	 * @author fjy
	 * @version 2014年8月12日 下午3:37:11
	 * @param Interface
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public <T> T ProxyInstance(Class<T> TargetClass, Class[] ArgsTypes,
			Object[] Values) {
		IProxySet pd = new ProxyDefaul();
		T result = this.ProxyInstance(TargetClass, pd, ArgsTypes, Values);
		return result;
	}

	/**根据类全名加载代理类
	 * @author   fjy
	 * @version 2014年9月17日 下午2:46:00 
	 * @param InsType
	 * @param ClassFullName
	 * @param ArgsTypes
	 * @param Values
	 * @return
	 * @throws MalformedURLException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	@SuppressWarnings({ "resource", "unchecked", "rawtypes" })
	public <T> T ProxyInstance(Class<T> InsType,
			String ClassFullName, Class[] ArgsTypes, Object[] Values)
			throws MalformedURLException, ClassNotFoundException,
			InstantiationException, IllegalAccessException { 
		T resulT = null;  
		IProxySet pd = new ProxyDefaul();  
		Class c = Class.forName(ClassFullName);
		resulT = (T) this.ProxyInstance(c, pd, ArgsTypes, Values); 
		return resulT;
	}
	
	/**
	 * 通过代理实例化程序集,添加默认的aop拦截监听
	 * 
	 * @author fjy
	 * @version 2014年8月12日 下午10:28:46
	 * @param InsType
	 * @param JarUrl
	 * @param ClassFullName
	 * @return
	 * @throws MalformedURLException
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	@SuppressWarnings({ "resource", "unchecked", "rawtypes" })
	public <T> T ProxyInstance(Class<T> InsType, String JarUrl,
			String ClassFullName, Class[] ArgsTypes, Object[] Values)
			throws MalformedURLException, ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		if (JarUrl.toLowerCase().indexOf(".jar") == -1) {
			JarUrl = JarUrl + ".jar";
		}
		T resulT = null;
		File file = new File(JarUrl);
		if (file.exists()) {
			IProxySet pd = new ProxyDefaul();
			URL url = new URL("file:" + JarUrl);
			URLClassLoader loader = new URLClassLoader(new URL[] { url });
			Class c = loader.loadClass(ClassFullName);
			resulT = (T) this.ProxyInstance(c, pd, ArgsTypes, Values);
		}
		return resulT;
	}

	/**
	 * 根据文件路径获取url列表
	 * 
	 * @author fjy
	 * @version 2014年9月16日 上午12:38:46
	 * @param fileName
	 * @return
	 * @throws MalformedURLException
	 */
	private URL[] getURLs(List<String> fileName) throws MalformedURLException {
		List<URL> tmpList = new ArrayList<URL>();
		for (String s : fileName) {
			URL url = new URL("file:" + s);
			tmpList.add(url);
		}
		URL[] tmpUrls = new URL[tmpList.size()];
		tmpList.toArray(tmpUrls);
		return tmpUrls;
	}

	/** 根据指定的基类型或接口，获取jar文件中所有子类的类型的对象 
	 * @author fjy
	 * @version 2014年9月11日 上午1:51:25
	 * @param cin
	 *            基类活接口
	 * @param fileName
	 *            目的要加载的jar文件
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings({ "resource", "rawtypes", "unchecked" })
	public <T> List<Class> getJarClasses(Class<T> cin, String fileName,
			List<String> jarNames) {
		List<Class> resulTs = new ArrayList<Class>();
		JarFile jarFile = null;
		try {
			jarFile = new JarFile(fileName);
		} catch (IOException e1) {
			System.out.println(e1);
		}
		if (!jarNames.contains(fileName)) {
			jarNames.add(fileName);
		} 
		Enumeration enumeration = jarFile.entries();
		while (enumeration.hasMoreElements()) {
			JarEntry entry = (JarEntry) enumeration.nextElement();
			String name = entry.getName();
			if (name.endsWith(".class")) {
				String cnamedot = name.substring(0, name.indexOf(".class"));
				cnamedot = cnamedot.replace('/', '.');
				Class checkcin = null;
				try { 
					checkcin = Class.forName(cnamedot);
				} catch (NoClassDefFoundError | ClassNotFoundException e) {
					System.out.println(e);
					break;
				}
				if (cin.isInterface()) {
					Class[] iClasses = checkcin.getInterfaces();
					for (Class czz : iClasses) {
						if (czz.getName().equals(cin.getName())) {

							resulTs.add(checkcin);
							break;
						}
					}
				} else {

					if (checkcin.asSubclass(cin) != null) {
						resulTs.add(checkcin);
					}
				}

			}
		}
		return resulTs;
	}

	/**查找泛型类型指定的类型对象
	 * @author   fjy
	 * @version 2014年12月25日 下午2:15:49 
	 * @param cin
	 * @param cinList
	 * @return
	 */
	public <T> List<Class> findClasses(Class<T> cin, List<Class> cinList) {
		List<Class> resulTs = new ArrayList<Class>(); 
		for (Class cinClass : cinList) {
			if (cin.isInterface()) {
				List<Class> findinterfacesClasses=this.findChildClassInterfaces(cinClass);
				if(findinterfacesClasses.size()==0)
				{
					continue;
				}
				Class[] iClasses=new Class[findinterfacesClasses.size()];
				for (int i = 0; i < findinterfacesClasses.size(); i++) {
					iClasses[i]=findinterfacesClasses.get(i);
				}
//				Class[] iClasses=(Class[]) findinterfacesClasses.toArray();
//				Class[] iClasses = cinClass.getInterfaces();
				for (Class czz : iClasses) {
					if (czz.getName().equals(cin.getName())) { 
						resulTs.add(cinClass);
						break;
					}
					else if(isInterface(czz,cin.getName())) {
						resulTs.add(cinClass);
						break;
					}
				}
			} else { 
				if (cinClass.asSubclass(cin) != null) {
					resulTs.add(cinClass);
				}
			}
		}
		 
		return resulTs;
	}
	
	public boolean isInterface(Class c, String szInterface)
    {
        Class[] face = c.getInterfaces();
        for (int i = 0, j = face.length; i < j; i++) 
        {
                if(face[i].getName().equals(szInterface))
                {
                        return true;
                }
                else
                { 
                        Class[] face1 = face[i].getInterfaces();
                        for(int x = 0; x < face1.length; x++)
                        {
                                if(face1[x].getName().equals(szInterface))
                                {
                                        return true;
                                }
                                else if(isInterface(face1[x], szInterface))
                                {
                                        return true;
                                }
                        }
                }
        }
        if (null != c.getSuperclass())
        {
                return isInterface(c.getSuperclass(), szInterface);
        }
        return false;
    }
	/** 获取jar文件中所有子类的类型的对象 
	 * @author   fjy
	 * @version 2014年12月25日 下午2:10:47 
	 * @param fileName
	 * @param jarNames
	 * @return
	 */
	public <T> List<Class> getJarClasses( String fileName,
			List<String> jarNames) {
		 
		List<Class> resulTs = new ArrayList<Class>();
		JarFile jarFile = null;
		try {
			jarFile = new JarFile(fileName);
		} catch (IOException e1) {
//			System.out.println(fileName);
			System.out.println(e1);
		}
		if (!jarNames.contains(fileName)) {
			jarNames.add(fileName);
		} 
		
		MessageBus mBus=new MessageBus();
		BasisText bisnote=new BasisText();
//    	cError.setContent(new Exception("扩展配置加载失败。 xml:" + filename));
//    	mBus.Send(cError); 
		Enumeration enumeration = jarFile.entries();
		while (enumeration.hasMoreElements()) {
			JarEntry entry = (JarEntry) enumeration.nextElement();
			String name = entry.getName();
			if (name.endsWith(".class")) {
				String cnamedot = name.substring(0, name.indexOf(".class"));
				cnamedot = cnamedot.replace('/', '.');
				Class checkcin = null;
				try {  
					bisnote.setContent("getJarClasses: "+cnamedot);
					mBus.Send(bisnote); 
					checkcin = Class.forName(cnamedot); 					
				} catch (NoClassDefFoundError | ClassNotFoundException e) {
//					ContentErrorLog cError=new ContentErrorLog();
//					String ss=e.toString(); 
//		        	cError.setContent(new Exception(ss));
//					mBus.Send(cError);//(e+""+name);
					System.out.println(fileName+"  "+e.toString());
//					System.out.println(e); 
					break;
				}
				resulTs.add(checkcin); 
			}
		}
		return resulTs;
	}
	
	  
	/**从指定路径加载类型列表
	 * @author   fjy
	 * @version 2014年12月25日 下午2:07:38 
	 * @param dirName
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public <T> List<Class> getJarClassesFromDir(String dirName,boolean isHotswap)
			throws IOException, ClassNotFoundException {
		
		List<Class> result = new ArrayList<Class>();
		File file = new File(dirName);
		if (file.isDirectory()) {  
			List<String> jarStrings = new ArrayList<String>();
			for (String fn : file.list()) { 
				File readfile = new File(dirName + "\\" + fn);  
				if (!readfile.isDirectory()) {
					String exnameString = PtFile.getFileExtension(readfile);
					if (exnameString.equals("jar")) {
						jarStrings.add(readfile.getPath());
					}
				}
			}
			for (String f : jarStrings) {
				List<Class> cinlist = null; 
				cinlist=this.getJarClasses(f, jarStrings); 
				result.addAll(cinlist);
			}
		}
		return result;
	}
	
	/**获取指定文件夹下的所有jar文件名
	 * @author   fjy
	 * @version 2014年9月16日 下午4:02:41 
	 * @param dirName
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("rawtypes")
	public List<String> getJars(String dirName)
			throws IOException, ClassNotFoundException {
		List<String> result = new ArrayList<String>();
		File file = new File(dirName);
		if (file.isDirectory()) {  
			for (String fn : file.list()) {
				File readfile = new File(dirName + "\\" + fn);
				if (!readfile.isDirectory()) {
					String exnameString = PtFile.getFileExtension(readfile);
					if (exnameString.equals("jar")) {
						result.add(readfile.getPath());
					}
				}
			} 
		}
		return result;
	}
	
	 
	/**获取指定jar文件中所有类名
	 * @author   fjy
	 * @version 2014年9月16日 下午4:08:26 
	 * @param fileName
	 * @return
	 */
	@SuppressWarnings({ "resource", "rawtypes", "unchecked" })
	public  List<String> getJarClassesName(String fileName) {
		List<String> resuls = new ArrayList<String>();
		JarFile jarFile = null;
		try {
			jarFile = new JarFile(fileName);
		} catch (IOException e1) {
			 
		}
		Enumeration enumeration = jarFile.entries();
		while (enumeration.hasMoreElements()) {
			JarEntry entry = (JarEntry) enumeration.nextElement();
			String name = entry.getName();
			if (name.endsWith(".class")) {
				String cnamedot = name.substring(0, name.indexOf(".class"));
				cnamedot = cnamedot.replace('/', '.');
				resuls.add(cnamedot); 
			}
		}
		return resuls;
	}
	
	
	/**查找指定类列表中的注释类
	 * @author   fjy
	 * @version 2016年4月16日 下午6:56:04 
	 * @param annotationClass
	 * @param cinList
	 * @return
	 * @throws ClassNotFoundException
	 */
	public List<Class> findAnnotatedClasses(String annotationClass
			, List<Class> cinList) throws ClassNotFoundException {
		 
		List<Class> resuls = new ArrayList<Class>();
		for (Class cinClass : cinList) { 
			if(cinClass.isAnnotationPresent(Class.forName(annotationClass)))
			{
				resuls.add(cinClass);
			}
			 
		} 
		return resuls;  
	}
	
	private List<Class> findChildClassInterfaces(Class sourceClass)
	{
		List<Class> result=new ArrayList<Class>();
		result.addAll(Arrays.asList(sourceClass.getInterfaces()));
		if(sourceClass.getSuperclass() != null)
		{
			result.addAll(this.findChildClassInterfaces(sourceClass.getSuperclass()));
		}
		return result;
	}

}
