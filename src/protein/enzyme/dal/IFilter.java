package protein.enzyme.dal;

import java.lang.reflect.Field;

/** 查询过滤语句 包含聚合函数
 * @author fjy
 *
 */
public interface IFilter {
	 
    
    /**获取筛选字段
     * @author   fjy
     * @version 2014年8月5日 下午4:01:10 
     * @return
     */
    Field getUseField();
    
    /**输出字段
     * @author   fjy
     * @version 2014年8月5日 下午4:02:16 
     * @return
     */
    String getOutPutFieldChar();
   
    /**获取操作符
     * @author   fjy
     * @version 2014年8月5日 下午4:02:41 
     * @return
     */
    DalOperator getOperatorSign();
    
    /**设置过滤 操作符号 操作字段
     * @param FieldObj
     * @param Oprt
     */
    void SetFilter(Field FieldObj, DalOperator Oprt);
}
