package protein.enzyme.dal;

import java.util.List;
 

 

/**实体工厂接口
 * @author fjy 
 * @version 2014年8月8日 下午4:29:50  
 */
public interface IEntityFactory {
	  
	/**获取数据库是否可用
	 * @author   fjy
	 * @version 2014年10月1日 上午8:46:12 
	 * @return
	 */
	Boolean getDbHealth();
	
    /**创建实体对象实例
     * @author   fjy
     * @version 2014年8月8日 下午4:34:51 
     * @return
     */
    <T> T CreateEntityInstance(Class<T> Cin,Object ... Parameters);
    
    /**根据字段数据创建实体
     * @author   fjy
     * @version 2016年2月23日 下午7:41:39 
     * @param fields
     * @return
     */
    Object CreateEntityInstance(List<EntityField> fields);
    
    /**获取数据库信息对象类型
     * @author   fjy
     * @version 2015年1月31日 下午9:47:50 
     * @return
     */
    Class  getDBInfoClass();
    /**数据库信息
     * @author   fjy
     * @version 2014年8月8日 下午4:36:06 
     * @return
     */
    IDBInfo getDbInfo();
    /**设置数据库信息对象实体
     * @author   fjy
     * @version 2015年1月31日 下午10:34:13 
     */
    void setDBInfo(IDBInfo dbinfo);
    /**创建表格操作驱动对象
     * @author   fjy
     * @version 2014年8月8日 下午4:36:36 
     * @param Entity
     * @return
     */
    IDvTable CreateDriveTable(IEntityBase Entity);
    IDvTable CreateDriveTable(IEntityBase Entity,String mapping);
    /**根据实体名称创建驱动表格对象，如果不存在该名称或该映射名称的物理数据将返回null
     * @author   fjy
     * @version 2016年2月23日 上午9:21:22 
     * @param entityName
     * @return
     */
    IDvTable  CreateDriveTable(String entityName) ;
     
    /** 创建表格批量操作驱动对象
     * @author   fjy
     * @version 2014年8月8日 下午4:53:08 
     * @return
     */
    IDvTableBatch CreateDriveTableBatch();
    
    /**根据实体名称创建驱动表格批量操作对象，如果不存在该名称或该映射名称的物理数据将返回null
     * @author   fjy
     * @version 2016年6月6日 下午9:34:04 
     * @param entityName
     * @return
     */
    IDvTableBatch CreateDriveTableBatch(String entityName);
    /**管理接口
     * @author   fjy
     * @version 2014年8月8日 下午4:54:19 
     * @return
     */
    IDALManager CreateDALmanager();
 
    /**创建空间分析接口
     * @author   fjy
     * @version 2015年2月1日 下午1:06:38 
     * @return
     */
    ISpatialAnalysis createSpatialAnalysis();
    /** 添加新的实体类型处理适配器
     * @author   fjy
     * @version 2014年8月11日 下午4:25:26 
     * @param NewAdapter
     */
    void AddAdapter(EntityTypeAdapter NewAdapter);
     
    /**关闭工厂
     * @author   fjy
     * @version 2014年9月2日 下午11:02:42 
     */
    void CloseFactory();
    
    /**
     * @author   fjy
     * @version 2014年9月2日 下午11:02:35 
     * @param Entity
     * @param FieldName
     * @return
     */
    Integer GetMaxField(IEntityBase Entity, String FieldName);
    
    /**创建元数据
     * @author   fjy
     * @version 2016年2月24日 下午7:47:39 
     * @param entityName
     * @return
     */
    IMetaData CreateMetaData(String entityName);
    
    /**更新元数据字段，即修改数据源的字段值,目前只增加名称，由于暂时只有mongodb所以不考虑字段类型
     * @author   fjy
     * @version 2016年5月21日 下午11:17:24 
     * @param entityName
     * @param fieldNames
     * @return
     */
    Boolean addMetaDataFields(String entityName,List<String> fieldNames);
    
}
