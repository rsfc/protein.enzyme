package protein.enzyme.dal;

import java.util.List;
 

 
/**驱动表格接口，抽象表格对象的操作
 * @author fjy 
 * @version 2014年8月5日 上午1:30:56 
 */
/**
 * @author fjy 
 * @version 2016年3月1日 下午4:18:06 
 */
public interface IDvTable {
	 
	/**设置实体
	 * @author   fjy
	 * @version 2014年8月5日 下午3:07:35 
	 * @param Entity
	 */
	void setEntity(IEntityBase Entity);
	@Deprecated   
	/**获取实体，该方法已经过时，原有方法针对实体类的实例本身，职责不明确。
	 * 对实例的操作应该将职责细分到具体场景
	 * @author   fjy
	 * @version 2014年8月5日 下午3:07:53 
	 * @return
	 */
	IEntityBase getEntity();
	
	/**获取实体对象的实例
	 * @author   fjy
	 * @version 2016年2月17日 下午11:51:48 
	 * @return
	 */
	IEntityBase getInstance();
	
	/**获取实体名称 
	 * @author   fjy
	 * @version 2016年2月17日 下午11:28:08 
	 * @return
	 */
	String getEntityName();
	
	/**获取实体映射名称，如果不存在映射名称则返回实体名称
	 * @author   fjy
	 * @version 2016年2月17日 下午11:28:06 
	 * @return
	 */
	String getMapName();
	
	/**设置该实体映射的名称，当存在映射名称时，驱动表格
	 * @author   fjy
	 * @version 2016年2月17日 下午11:29:16 
	 * @param name
	 */
	void setMapName(String name);
	
	/**设置联立实体类包装对象
	 * @author   fjy
	 * @version 2014年8月5日 下午3:08:31 
	 * @param Join
	 */
	void setJoinEntity(IJoinEntity Join);
	
	/**获取联立实体类包装对象
	 * @author   fjy
	 * @version 2014年8月5日 下午3:08:58 
	 * @return
	 */
	IJoinEntity getJoinEntity();
 
	/**获取条件子语句列表
	 * @author   fjy
	 * @version 2014年8月5日 下午3:13:25 
	 * @return
	 */
	List<IDvWhere> getDvWhereList(); 
	
	/**获取筛选过滤器列表
	 * @author   fjy
	 * @version 2014年8月5日 下午3:13:57 
	 * @return
	 */
	List<IFilter> getFilterlist();
	
	/**设置分组对象
	 * @author   fjy
	 * @version 2014年8月5日 下午3:14:52 
	 * @param GetGroupBy
	 */
	void setGroupBy(IGroupBy  GroupBy);
	
	/**获取分组对象
	 * @author   fjy
	 * @version 2014年8月5日 下午3:15:12 
	 * @return
	 */
	IGroupBy getGroupBy();
	
	/**in子语句设置 该方法欠考虑 暂时用
	 * @author   fjy
	 * @version 2014年8月5日 下午3:15:43 
	 * @param InClause
	 */
	void setClause(InClauseOperator InClause); 
	
	/**获取属性值
	 * @author   fjy
	 * @version 2016年3月1日 下午4:18:09 
	 * @return
	 */
	String getAttribute();
	
    /**创建条件子语句，只用于主实体对象
     * @param FieldName 字段名
     * @param OperatorType 运算符
     * @param LinkNextOperator 其后的逻辑操作符，当存在多个条件时，确定他们之间的关系
     * @throws Exception 
     */
    void WhereClause(String FieldName, DalOperator OperatorType, LinkOperator LinkNextOperator) throws Exception;
 
    /**创建条件子语句，指定要作为条件子语句的实体对象
     * @param JoinEntity 在联立的实体对象中查找
     * @param FieldName 字段名
     * @param OperatorType 运算符
     * @param LinkNextOperator 其后的逻辑操作符，当存在多个条件时，确定他们之间的关系
     * @throws Exception 
     */
    void WhereClause(IEntityBase JoinEntity, String FieldName, DalOperator OperatorType, LinkOperator LinkNextOperator) throws Exception;
   
    /**设置条件子语句
     * @author   fjy
     * @version 2016年3月1日 下午4:16:06 
     * @param attribute
     */
    void WhereClause(String attribute);
    
    /**将该表格对象插入数据库中
     * @return
     */
    int Insert(); 
    
    /**根据存在的条件子语句查询该单位
     * @return
     */
    IDataHelper Select();
 
    /** 暂时无用 可以不实现
     * @author   fjy
     * @version 2015年4月7日 下午3:57:32 
     * @param parName
     * @param parValue
     * @return
     */
    IDataHelper Select(String parName,Object parValue);
     
    /**根据条件语句删除数据
     * @return
     */
    int Delete();
    
    /**根据条件语句更新对象的所有值
     * @return
     */
    int Update();
 
    
    /**查询过滤器
     * @param OperatorType
     * @param FieldName
     */
    void SetFilter(DalOperator OperatorType,String FieldName);
     
 
    /**设置分组字段
     * @param FieldName
     */
    void SetGroupBy(String FieldName);
 
    /**测试选择
	 * @author   fjy
	 * @version 2016年6月6日 下午8:51:48 
	 * @return
	 */
    IDataHelper SelectTest();
}
