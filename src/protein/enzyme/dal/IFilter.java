package protein.enzyme.dal;

import java.lang.reflect.Field;

/** ��ѯ������� �����ۺϺ���
 * @author fjy
 *
 */
public interface IFilter {
	 
    
    /**��ȡɸѡ�ֶ�
     * @author   fjy
     * @version 2014��8��5�� ����4:01:10 
     * @return
     */
    Field getUseField();
    
    /**����ֶ�
     * @author   fjy
     * @version 2014��8��5�� ����4:02:16 
     * @return
     */
    String getOutPutFieldChar();
   
    /**��ȡ������
     * @author   fjy
     * @version 2014��8��5�� ����4:02:41 
     * @return
     */
    DalOperator getOperatorSign();
    
    /**���ù��� �������� �����ֶ�
     * @param FieldObj
     * @param Oprt
     */
    void SetFilter(Field FieldObj, DalOperator Oprt);
}
