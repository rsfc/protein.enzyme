package protein.enzyme.dal;

import java.util.List;

/**������ʵ�����װ�ӿ�
 * @author fjy
 *
 */
public interface IJoinEntity {
	 
//    /**
//     * ������ʵ����
//     */
//    List<IEntityBase> Entitys=null;
 
	/**��ȡʵ�����б�
	 * @author   fjy
	 * @version 2014��8��5�� ����3:55:06 
	 * @return
	 */
	List<IEntityBase> getEntitys();
	
    /**����Ҫ���ϵ�ʵ�� �ڵ��õ�ʵ���ڼ�¼�����ϵ��ֶ����,���������ϵ���÷�����ʾ  
     * @param SourceEntity ������ʵ�������
     * @param JionEntity ������ʵ�������
     * @return
     */
    String JoinField(IEntityBase SourceEntity, IEntityBase JionEntity);
}
