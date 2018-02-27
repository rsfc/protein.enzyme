package protein.enzyme.dal;

import java.lang.reflect.Field; 

 /**实体基本操作接口
 * @author fjy
 *
 */
public interface IEntityBase {
	 
//	/**获取类属性字段
//	 * @param FieldName
//	 * @return
//	 */
//	Field getField(String FieldName);
    
//    /**获取类所有的属性字段
//     * @return
//     */
//    List<Field> getFields();
//     
//    /**获取类属性所有字段的名称字符串
//     * @return
//     */
//    List<String> getStrFields();
//     
    /**获取实体主键 所有主外键都用方法获取 这个主键应该换成一个接口 下面的外联键也应该是一个接口 两者组合使用
     * @return
     */
    Field primaryKey();

    
}
