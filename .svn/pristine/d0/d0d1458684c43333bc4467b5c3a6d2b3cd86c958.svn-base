package protein.enzyme.dal;

import java.util.List;
import java.util.Set;


/**数据层管理接口 该接口用于管理数据层物理对象编辑功能
 * @author fjy 
 * @version 2014年8月8日 下午4:54:06 
 */
public interface IDALManager {
 
	/**获取数据库信息
	 * @author   fjy
	 * @version 2014年9月7日 下午2:41:37 
	 * @return
	 */
	IDBInfo getDbInfo();
	
	
    /**实体是否存在
     * @author   fjy
     * @version 2014年8月8日 下午4:53:54 
     * @param Entity
     * @return
     */
    <T> Boolean IsEntityExist(Class<T> cin);
    
    /**实体是否存在
     * @author   fjy
     * @version 2016年2月23日 上午12:08:34 
     * @param mapName
     * @return
     */
    Boolean IsEntityExist(String mapName);
    
    /**删除实体
     * @author cyf
     * @version 2017年4月17日 下午5:00:00
     * @param mapName
     * @return
     */
    Boolean DropEntity(String mapName);
    
    /**创建实体
     * @author   fjy
     * @version 2014年8月8日 下午4:53:56 
     * @param Entity
     * @return
     */
    Boolean CreateEntity(IEntityBase Entity);
    
    /**删除实体
     * @author cyf
     * @version 2017年4月27日 下午5:53:00
     * @param Entity
     * @return
     */
    Boolean DropEntity(IEntityBase Entity);
    
    /**创建数据库
     * @author  hxb
     * @version 2014年9月25日 上午11:42:59
     * @return Boolean
     */
    Boolean CreateDB();
    
    /**判断数据库是否存在
     * @author  hxb
     * @version 2014年9月25日 上午11:43:57
     * @param cin
     * @return Boolean
     */
    Boolean IsDBExist();
    /**
     * 判断数据库服务是否开启
     * @author   fjy
     * @version 2015年1月31日 下午8:57:31 
     * @return
     */
    Boolean isDBServiceOpen();
    
    /**获取所有实体名称
     * @author cyf
     * @version 2017年4月28日 下午4:32:20
     * @return
     */
    Set<String> getAllEntityName();
    
    /**启动数据库服务
     * @author   fjy
     * @version 2015年1月31日 下午8:59:38 
     * @return
     */
    Boolean startUpDBService();
    
    /**关闭数据服务
     * @author   fjy
     * @version 2015年1月31日 下午11:25:34 
     * @return
     */
    Boolean shutdownDBService();
    
    Boolean addFieldsToEntity(String entityName,List<String> newFieldNames);
}
