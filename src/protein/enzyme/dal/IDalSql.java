package protein.enzyme.dal;

import java.sql.SQLException;
import java.util.List;

/**数据库操作接口
 * @author fjy 
 * @version 2014年8月5日 上午1:28:15 
 */
public interface IDalSql {
	  
	/**获取当前dal操作对象状态是否健康
	 * @author   fjy
	 * @version 2014年8月8日 下午3:16:33 
	 * @return
	 */
	boolean getHasHealth();
    /**
     * 
     */
    IDBInfo DbHelper=null;
    
     
    /**将表对象插入数据库
     * @param Table
     * @return
     * @throws SQLException 
     */
    int Insert(IDvTable Table) throws SQLException;
     
    /**根据表对象数据查询数据
     * @param Table
     * @return
     * @throws SQLException 
     */
    IDataHelper SelectSingle(IDvTable Table) throws SQLException ;
    
    /**删除表中的该对象
     * @param Table
     * @return
     */
    int Delete(IDvTable Table);
 
    /**修改表中的对象数据
     * @param Table
     * @return
     */
    int Update(IDvTable Table); 
   
    /**批量插入数据库记录
     * @param Tables
     * @param IsRollBack 是否允许在操作异常时回滚，true为发生异常是回滚所有操作，false忽略异常记录
     * @return
     */
    int InsertTran(List<IDvTable> Tables,Boolean IsRollBack);
    
    /**批量更新数据库记录
     * @param Tables
     * @param IsRollBack 是否允许在操作异常时回滚，true为发生异常是回滚所有操作，false忽略异常记录
     * @return 影响的记录数量
     */
    int UpdateTran(List<IDvTable> Tables, Boolean IsRollBack);

    
    /**批量删除数据库记录
     * @param Tables
     * @param IsRollBack 是否允许在操作异常时回滚，true为发生异常是回滚所有操作，false忽略异常记录
     * @return 影响的记录数量
     */
    int DeleteTran(List<IDvTable> Tables, Boolean IsRollBack);
    
    
    IDataHelper SelectSingleTest(IDvTable Table) throws SQLException ;
}
