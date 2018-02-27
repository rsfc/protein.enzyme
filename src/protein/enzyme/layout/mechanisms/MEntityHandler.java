package protein.enzyme.layout.mechanisms;
 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver; 

import protein.enzyme.dal.IDBInfo;
import protein.enzyme.dal.IEntityFactory;
import protein.enzyme.design.ClassDrive;
import protein.enzyme.layout.CustomSectionDb;
import protein.enzyme.layout.configuration.DataBaseConfig;
import protein.enzyme.layout.configuration.DbDal;
import protein.enzyme.repository.ProteinResource;

/**支撑机制的实体功能
 * @author fjy 
 * @version 2014年8月13日 上午10:21:04 
 */
public class MEntityHandler {
	 
	private static MEntityHandler meh = null;
	
	private Map<String, IEntityFactory> facmap=new HashMap<String, IEntityFactory>();
	/**
	 * 
	 */
	private MEntityHandler()
	{
		
	}
	 
    /**获取实体工厂的实例
     * @author   fjy
     * @version 2014年8月13日 上午10:45:42 
     * @return
     * @throws UnsupportedEncodingException 
     * @throws FileNotFoundException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     * @throws ClassNotFoundException 
     * @throws MalformedURLException 
     */
    public static IEntityFactory getEntityFactory(String dbKey) throws FileNotFoundException, UnsupportedEncodingException, MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
    	
    	IEntityFactory resultEntityFactory=null;
        if (meh == null)
        {
            meh = new MEntityHandler(); 
        }
        if(meh.facmap.containsKey(dbKey))
        {
        	resultEntityFactory=meh.facmap.get(dbKey);
        }
        else {
        	resultEntityFactory=meh.CreateEntityFactory(dbKey);  
        	meh.facmap.put(dbKey, resultEntityFactory);
		}
        return resultEntityFactory;
    }

    public static IEntityFactory getEntityFactory(Integer index) throws FileNotFoundException, UnsupportedEncodingException, MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
    	IEntityFactory resultEntityFactory=null;
        if (meh == null)
        {
            meh = new MEntityHandler(); 
        }
        Set set = meh.facmap.entrySet();    
		Iterator i = set.iterator();  
		Integer cutindex=0;
		while (i.hasNext()) { 
			if(cutindex==index)
			{
				Map.Entry me = (Map.Entry)i.next(); 
				resultEntityFactory=(IEntityFactory) me.getValue();
			}
			else {
				i.next();
			}
			cutindex++;
		} 
        if(resultEntityFactory==null)
        {
        	CustomSectionDb cSection=new CustomSectionDb();
        	DataBaseConfig dbc=cSection.getDBConfig();
        	DbDal tagDal= dbc.getDal(index); 
        	resultEntityFactory=meh.CreateEntityFactory(index);  
        	meh.facmap.put(tagDal.dalKey, resultEntityFactory);
        } 
        return resultEntityFactory;
    }
    
    /**根据索引指定的实体类工厂和参数提供的数据库信息创建实体类工厂
     * @author   fjy
     * @version 2014年9月24日 下午5:08:41 
     * @param index
     * @param dbinfo
     * @return
     * @throws UnsupportedEncodingException 
     * @throws FileNotFoundException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     * @throws ClassNotFoundException 
     * @throws MalformedURLException 
     */
    public static   IEntityFactory getEntityFactory(String dbKey ,IDBInfo dbinfo) throws FileNotFoundException, UnsupportedEncodingException, MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {  
        CustomSectionDb cSection=new CustomSectionDb();
    	DataBaseConfig dbc=cSection.getDBConfig();
    	DbDal tagDal= dbc.getDal(dbKey); 
    	if(tagDal!=null)
    	{  
    		return createEntityFac(tagDal,dbinfo);
    	}
    	else {
			return null;
		}
    }
    
    /**创建实体工厂,数据库连接字符串,实体类适配器
     * @author   fjy
     * @version 2014年8月13日 上午10:43:33 
     * @throws UnsupportedEncodingException 
     * @throws FileNotFoundException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     * @throws ClassNotFoundException 
     * @throws MalformedURLException 
     */
    protected   IEntityFactory CreateEntityFactory(String dbKey) throws FileNotFoundException, UnsupportedEncodingException, MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {    
    	CustomSectionDb cSection=new CustomSectionDb();
    	DataBaseConfig dbc=cSection.getDBConfig();
    	DbDal tagDal= dbc.getDal(dbKey); 
    	if(tagDal!=null)
    	{  
    		return createEntityFac(tagDal);
    	}
    	else {
			return null;
		}
    }
    protected   IEntityFactory CreateEntityFactory(Integer index) throws FileNotFoundException, UnsupportedEncodingException, MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {    
    	CustomSectionDb cSection=new CustomSectionDb();
    	DataBaseConfig dbc=cSection.getDBConfig();
    	DbDal tagDal= dbc.getDal(index); 
    	if(tagDal!=null)
    	{  
    		return createEntityFac(tagDal);
    	}
    	else {
			return null;
		}
    }
    @SuppressWarnings("unused")
	private static IEntityFactory createEntityFac(DbDal dalObjeDal) throws FileNotFoundException, UnsupportedEncodingException, MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
    	IEntityFactory resultEntityFactory=null;
    	ClassDrive cDrive=new ClassDrive(); 
		resultEntityFactory=cDrive.ProxyInstance(IEntityFactory.class,dalObjeDal.dalEntityFactoryFullName,null,null);
		if(resultEntityFactory!=null)
		{ 
//			IDBInfo dbinfo=(IDBInfo)cDrive.ProxyInstance(resultEntityFactory.getDBInfoClass(),dalObjeDal.dalInfoFullName,null,null);
			String configpathString=ProteinResource.getSysConfigPath(true);
			File xmlFile=new File(configpathString+"/"+dalObjeDal.dalKey+".xml");
		    if(xmlFile.exists())
		    {  
		    	XStream redStream = new XStream(new DomDriver());
		    	IDBInfo  dbinfo= (IDBInfo)redStream.fromXML(xmlFile);
				resultEntityFactory.setDBInfo(dbinfo); 
		    }  
		    
		} 
        return resultEntityFactory;
    }
    
    @SuppressWarnings("unused")
   	private static IEntityFactory createEntityFac(DbDal dalObjeDal,IDBInfo dbinfo) throws FileNotFoundException, UnsupportedEncodingException, MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
       	IEntityFactory resultEntityFactory=null;
       	ClassDrive cDrive=new ClassDrive(); 
   		resultEntityFactory=cDrive.ProxyInstance(IEntityFactory.class,dalObjeDal.dalEntityFactoryFullName,null,null);
   		if(resultEntityFactory!=null)
   		{ 
   			resultEntityFactory.setDBInfo(dbinfo);  
   		    
   		} 
           return resultEntityFactory;
       }
    
}
