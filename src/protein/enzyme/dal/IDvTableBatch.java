package protein.enzyme.dal;

import java.util.List;

/**驱动表格批量操作接口，批量添加、更新、删除纪录
 * @author fjy 
 * @version 2014年8月8日 下午4:38:49 
 */
public interface IDvTableBatch {
	 
    /**数据库操作
     * @author   fjy
     * @version 2014年8月8日 下午4:39:45 
     * @return
     */
    IDalSql getDalSql();
    
    /**设置数据库操作
     * @author   fjy
     * @version 2014年8月8日 下午4:39:31 
     * @param DalSql
     */
    void setDalSql(IDalSql DalSql);
 
//    /**创建表格操作驱动实例的委托实例
//     * @author   fjy
//     * @version 2014年8月8日 下午4:52:56 
//     * @param be
//     */
//    void  createDriveTableIns(BatchEngine be);
 
    /**根据批量操作的IDalSql对象和参数传入的实体对象创建表格操作驱动对象实例 
     * @author   fjy
     * @version 2014年8月8日 下午4:40:48 
     * @param Entity
     * @return
     */
    IDvTable CreateDriveTable(IEntityBase Entity);
    
 
    /**添加插入操作,以备批量执行
     * @author   fjy
     * @version 2014年8月8日 下午4:40:59 
     * @param Entity
     */
    void AddInsert(IEntityBase Entity);
   
    /**添加更新操作,以备批量执行
     * @author   fjy
     * @version 2014年8月8日 下午4:41:06 
     * @param Table
     */
    void AddUpdate(IDvTable Table);
 
    /**添加删除操作,以备批量执行
     * @author   fjy
     * @version 2014年8月8日 下午4:41:14 
     * @param Table
     */
    void AddDelete(IDvTable Table);
     
    /**执行操作 批量执行所有的插入、更新、删除操作，暂时不做细化的操作结果 只返回影响的数量，不支持回滚操作
     * @author   fjy
     * @version 2014年8月8日 下午4:41:24 
     * @return
     */
    int  Execute();
    
    /**执行操作 批量执行 更新 操作 
     * @author   fjy
     * @version 2014年8月8日 下午4:41:35 
     * @param TableList	表格列表
     * @param IsRollBack	是否回滚，如果发生回滚，返回值为-1
     * @return
     */
    int ExecuteUpdate(List<IDvTable> TableList, Boolean IsRollBack);

  
    /**执行操作 批量执行 更新 操作 
     * @author   fjy
     * @version 2014年8月8日 下午4:42:01 
     * @param Entity 实体
     * @param IsRollBack 是否回滚，如果发生回滚，返回值为-1
     * @return
     */
    int ExecuteInsert(List<IEntityBase> EntityList, Boolean IsRollBack);

 
    /**执行操作 批量执行 更新 操作 
     * @author   fjy
     * @version 2014年8月8日 下午4:42:23 
     * @param TableList 表格列表
     * @param IsRollBack 是否回滚，如果发生回滚，返回值为-1
     * @return
     */
    int ExecuteDelete(List<IDvTable> TableList, Boolean IsRollBack);
    
    /**设置映射
     * @author   fjy
     * @version 2016年2月18日 下午10:13:33 
     * @param name
     */
    void setMapName(String name);
}
