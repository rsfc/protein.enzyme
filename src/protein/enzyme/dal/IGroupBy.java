package protein.enzyme.dal;

import java.util.List;

/**����ۺϽӿ�
 * @author fjy
 *
 */
public interface IGroupBy {
	 
    
    /**��ȡ�ۺϵ��ֶ�
     * @author   fjy
     * @version 2014��8��5�� ����4:11:25 
     * @return
     */
    List<String> getUseField();
    

    /**��ȡҪ������ֶ�
     * @author   fjy
     * @version 2014��8��5�� ����4:10:50 
     * @return
     */
    String getOutPutFieldChar();
    /**���ù��� �������� �����ֶ�
     * @param FieldName
     */
    void SetField(String FieldName);
}
