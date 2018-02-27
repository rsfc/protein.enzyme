package protein.enzyme.dal;

import java.lang.reflect.Field;

 
/**��ѯ���������������Ĳ�ѯ��������
 * @author fjy 
 * @version 2014��8��5�� ����1:31:12 
 */
public interface IDvWhere {
	 
	/**��ȡ�������
	 * @author   fjy
	 * @version 2014��8��5�� ����1:42:13 
	 * @return
	 */
	int getClauseItemIndex();
	
	 
	/**��ȡʵ����
	 * @author   fjy
	 * @version 2014��8��5�� ����1:29:13 
	 * @return
	 */
	IEntityBase getEntity();
    /**����ʵ����
     * @author   fjy
     * @version 2014��8��5�� ����1:29:15 
     * @param EntityObj
     */
    void setEntity(IEntityBase EntityObj);
   
    /**
     * @author   fjy
     * @version 2014��8��5�� ����1:36:41 
     * @param Clause
     */
    void setClause(String Clause);
    
    /**
     * @author   fjy
     * @version 2014��8��5�� ����1:36:39 
     * @return
     */
    String getClause();
   
    /**
     * @author   fjy
     * @version 2014��8��5�� ����1:36:37 
     * @param OperatorItem
     */
    void setOperatorItem(DalOperator OperatorItem);
    
    /**
     * @author   fjy
     * @version 2014��8��5�� ����1:36:35 
     * @return
     */
    DalOperator getOperatorItem();
    /**��������ʵ��������  ��������Ĳ��������� ��Ҫʹ��Operator
     * @param Entity �����ֶ�
     * @param FieldObj �����ֶ�
     * @param Operator ������
     * @param LinkNextOperator ��������Ӳ�����
     */
    void ClauseItem(IEntityBase Entity,Field FieldObj, String Operator, String LinkNextOperator);
    
    
    /**
     * @author   fjy
     * @version 2014��8��5�� ����1:35:06 
     * @param LinknextOperator
     */
    void setLinknextOperator(String LinknextOperator);
    
    /**
     * @author   fjy
     * @version 2014��8��5�� ����1:35:01 
     * @return
     */
    String getLinknextOperator();
   
    /**
     * @author   fjy
     * @version 2014��8��5�� ����1:36:28 
     * @param Usefield
     */
    void setUsefield(Field Usefield);
    
    /**
     * @author   fjy
     * @version 2014��8��5�� ����1:36:31 
     * @return
     */
    Field getUsefield();
    
}
