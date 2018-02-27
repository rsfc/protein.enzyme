package protein.enzyme.repository;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;  
import com.sun.jndi.cosnaming.CNCtx; 
import protein.enzyme.ExtendConfig.ECC;
import protein.enzyme.dal.EntityTypeAdapterGenerics;
import protein.enzyme.dal.IDBInfo;
import protein.enzyme.dal.IEntityFactory;
import protein.enzyme.design.ClassDrive;
import protein.enzyme.layout.CustomSectionDb;
import protein.enzyme.layout.CustomSectionSetting;
import protein.enzyme.layout.configuration.DataBaseConfig;
import protein.enzyme.layout.configuration.DbDal;
import protein.enzyme.layout.configuration.ExConfig;
import protein.enzyme.layout.configuration.PtSetting;
import protein.enzyme.layout.mechanisms.MEntityHandler;
import protein.enzyme.layout.mechanisms.MachineExConfig;

 
/**֧��������
 * @author fjy 
 * @version 2014��8��18�� ����1:56:04 
 */
public class ProteinHandler {
 
    /**��ȡ��չ���ö���,֧�����ͳһ�����û�ȡ���
     * @author   fjy
     * @version 2014��8��18�� ����1:56:37 
     * @param ClassType
     * @return
     */
    public static <T> T getExtendConfig(Class<T> cin)
    {
        ECC ecc = MachineExConfig.getExConfigInit();
        T resulT=(T)ecc.getExtendConfig(cin);
        //�������򴴽��µ������ļ�
        if(resulT==null)
        {
        	try {
				resulT=cin.newInstance();
				if(resulT!=null)
				{
					setExtendConfig(resulT);
				} 
			} catch (InstantiationException | IllegalAccessException e) { 
				e.printStackTrace();
			} 
        }
        return resulT; 
    }
    
    /**������չ���ö���
     * @author   fjy
     * @version 2014��9��16�� ����4:17:03 
     * @param configObject
     */
    public static <T> void setExtendConfig(T configObject)
    {
		CustomSectionSetting css=null;
		try {
			css = new CustomSectionSetting();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
	 
			 
		}
		PtSetting pSetting=css.getSetting(); 
		ECC ecc = MachineExConfig.getExConfigInit();
		for (ExConfig config : pSetting.ExConfigs)
		{ 
			if(configObject.getClass().getSimpleName().equals(config.ExName))
			{
				ecc.SaveExtendConfig(config.ConfigXML,configObject);  
			}else{
//				if(configObject.getClass().toString().replace("class", "").trim().equals(config.ExName)){
//					ecc.SaveExtendConfig(config.ConfigXML,configObject); 
//				}
			}
			
		}   
    }
    
    public <T, TC> void  setEntityTypeAdapter(Class<T> CinT,Class<TC> CinTC,Integer index) 
    { 
        IEntityFactory efac=null;
		try {
			efac = getEntityFactory(index);
		} catch (FileNotFoundException | UnsupportedEncodingException
				| MalformedURLException | ClassNotFoundException
				| InstantiationException | IllegalAccessException e) { 
			 
		} 
        if(efac!=null)
        {
	        EntityTypeAdapterGenerics<T, TC> s = new EntityTypeAdapterGenerics<T, TC>();
	        s.SetEntityKeyv(CinT, CinTC);
	        efac.AddAdapter(s); 
        }
    }
    /**����ʵ������������
     * @author   fjy
     * @version 2014��8��20�� ����11:35:09 
     */
    public <T, TC> void  setEntityTypeAdapter(Class<T> CinT,Class<TC> CinTC,String dbKey) 
    { 
        IEntityFactory efac=null;
		try {
			efac = getEntityFactory(dbKey);
		} catch (FileNotFoundException | UnsupportedEncodingException
				| MalformedURLException | ClassNotFoundException
				| InstantiationException | IllegalAccessException e) { 
			 
		} 
        if(efac!=null)
        {
	        EntityTypeAdapterGenerics<T, TC> s = new EntityTypeAdapterGenerics<T, TC>();
	        s.SetEntityKeyv(CinT, CinTC);
	        efac.AddAdapter(s); 
        }
    }
    
    /**��ȡ���ݿ������ʵ���๤������
     * @author   fjy
     * @version 2014��8��11�� ����4:29:45 
     * @return
     * @throws UnsupportedEncodingException 
     * @throws FileNotFoundException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     * @throws ClassNotFoundException 
     * @throws MalformedURLException 
     */
    public IEntityFactory getEntityFactory(String dbKey) throws FileNotFoundException, UnsupportedEncodingException, MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    { 
    	IEntityFactory resultEntityFactory=MEntityHandler.getEntityFactory(dbKey); 
        return resultEntityFactory; 
    }
    public IEntityFactory getEntityFactory(Integer index) throws FileNotFoundException, UnsupportedEncodingException, MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    { 
    	IEntityFactory resultEntityFactory=MEntityHandler.getEntityFactory(index); 
        return resultEntityFactory; 
    }
    /**��ȡ���ݿ������ʵ���๤������
     * @author   fjy
     * @version 2014��9��24�� ����5:11:03 
     * @param index
     * @param dbinfo
     * @return
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     * @throws MalformedURLException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public IEntityFactory getEntityFactory(String dbKey,IDBInfo dbinfo) throws FileNotFoundException, UnsupportedEncodingException, MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
    	IEntityFactory resultEntityFactory=MEntityHandler.getEntityFactory(dbKey,dbinfo); 
        return resultEntityFactory; 
    }
     
}
