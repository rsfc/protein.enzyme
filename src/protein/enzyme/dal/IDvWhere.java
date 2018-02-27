package protein.enzyme.dal;

import java.lang.reflect.Field;

 
/**查询条件，条件子语句的查询条件对象
 * @author fjy 
 * @version 2014年8月5日 上午1:31:12 
 */
public interface IDvWhere {
	 
	/**获取参数序号
	 * @author   fjy
	 * @version 2014年8月5日 下午1:42:13 
	 * @return
	 */
	int getClauseItemIndex();
	
	 
	/**获取实体类
	 * @author   fjy
	 * @version 2014年8月5日 下午1:29:13 
	 * @return
	 */
	IEntityBase getEntity();
    /**设置实体类
     * @author   fjy
     * @version 2014年8月5日 下午1:29:15 
     * @param EntityObj
     */
    void setEntity(IEntityBase EntityObj);
   
    /**
     * @author   fjy
     * @version 2014年8月5日 下午1:36:41 
     * @param Clause
     */
    void setClause(String Clause);
    
    /**
     * @author   fjy
     * @version 2014年8月5日 下午1:36:39 
     * @return
     */
    String getClause();
   
    /**
     * @author   fjy
     * @version 2014年8月5日 下午1:36:37 
     * @param OperatorItem
     */
    void setOperatorItem(DalOperator OperatorItem);
    
    /**
     * @author   fjy
     * @version 2014年8月5日 下午1:36:35 
     * @return
     */
    DalOperator getOperatorItem();
    /**创建对象实体数据项  这个方法的参数有问题 需要使用Operator
     * @param Entity 条件字段
     * @param FieldObj 条件字段
     * @param Operator 操作符
     * @param LinkNextOperator 子语句连接操作符
     */
    void ClauseItem(IEntityBase Entity,Field FieldObj, String Operator, String LinkNextOperator);
    
    
    /**
     * @author   fjy
     * @version 2014年8月5日 下午1:35:06 
     * @param LinknextOperator
     */
    void setLinknextOperator(String LinknextOperator);
    
    /**
     * @author   fjy
     * @version 2014年8月5日 下午1:35:01 
     * @return
     */
    String getLinknextOperator();
   
    /**
     * @author   fjy
     * @version 2014年8月5日 下午1:36:28 
     * @param Usefield
     */
    void setUsefield(Field Usefield);
    
    /**
     * @author   fjy
     * @version 2014年8月5日 下午1:36:31 
     * @return
     */
    Field getUsefield();
    
}
