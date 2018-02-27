package protein.enzyme.dal;

import java.util.List;

/**分组聚合接口
 * @author fjy
 *
 */
public interface IGroupBy {
	 
    
    /**获取聚合的字段
     * @author   fjy
     * @version 2014年8月5日 下午4:11:25 
     * @return
     */
    List<String> getUseField();
    

    /**获取要输出的字段
     * @author   fjy
     * @version 2014年8月5日 下午4:10:50 
     * @return
     */
    String getOutPutFieldChar();
    /**设置过滤 操作符号 操作字段
     * @param FieldName
     */
    void SetField(String FieldName);
}
