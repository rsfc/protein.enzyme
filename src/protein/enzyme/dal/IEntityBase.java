package protein.enzyme.dal;

import java.lang.reflect.Field; 

 /**ʵ����������ӿ�
 * @author fjy
 *
 */
public interface IEntityBase {
	 
//	/**��ȡ�������ֶ�
//	 * @param FieldName
//	 * @return
//	 */
//	Field getField(String FieldName);
    
//    /**��ȡ�����е������ֶ�
//     * @return
//     */
//    List<Field> getFields();
//     
//    /**��ȡ�����������ֶε������ַ���
//     * @return
//     */
//    List<String> getStrFields();
//     
    /**��ȡʵ������ ������������÷�����ȡ �������Ӧ�û���һ���ӿ� �����������ҲӦ����һ���ӿ� �������ʹ��
     * @return
     */
    Field primaryKey();

    
}
