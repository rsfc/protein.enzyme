package protein.enzyme.dal;

import java.util.List;

/**����������������ӿڣ�������ӡ����¡�ɾ����¼
 * @author fjy 
 * @version 2014��8��8�� ����4:38:49 
 */
public interface IDvTableBatch {
	 
    /**���ݿ����
     * @author   fjy
     * @version 2014��8��8�� ����4:39:45 
     * @return
     */
    IDalSql getDalSql();
    
    /**�������ݿ����
     * @author   fjy
     * @version 2014��8��8�� ����4:39:31 
     * @param DalSql
     */
    void setDalSql(IDalSql DalSql);
 
//    /**��������������ʵ����ί��ʵ��
//     * @author   fjy
//     * @version 2014��8��8�� ����4:52:56 
//     * @param be
//     */
//    void  createDriveTableIns(BatchEngine be);
 
    /**��������������IDalSql����Ͳ��������ʵ����󴴽���������������ʵ�� 
     * @author   fjy
     * @version 2014��8��8�� ����4:40:48 
     * @param Entity
     * @return
     */
    IDvTable CreateDriveTable(IEntityBase Entity);
    
 
    /**��Ӳ������,�Ա�����ִ��
     * @author   fjy
     * @version 2014��8��8�� ����4:40:59 
     * @param Entity
     */
    void AddInsert(IEntityBase Entity);
   
    /**��Ӹ��²���,�Ա�����ִ��
     * @author   fjy
     * @version 2014��8��8�� ����4:41:06 
     * @param Table
     */
    void AddUpdate(IDvTable Table);
 
    /**���ɾ������,�Ա�����ִ��
     * @author   fjy
     * @version 2014��8��8�� ����4:41:14 
     * @param Table
     */
    void AddDelete(IDvTable Table);
     
    /**ִ�в��� ����ִ�����еĲ��롢���¡�ɾ����������ʱ����ϸ���Ĳ������ ֻ����Ӱ�����������֧�ֻع�����
     * @author   fjy
     * @version 2014��8��8�� ����4:41:24 
     * @return
     */
    int  Execute();
    
    /**ִ�в��� ����ִ�� ���� ���� 
     * @author   fjy
     * @version 2014��8��8�� ����4:41:35 
     * @param TableList	����б�
     * @param IsRollBack	�Ƿ�ع�����������ع�������ֵΪ-1
     * @return
     */
    int ExecuteUpdate(List<IDvTable> TableList, Boolean IsRollBack);

  
    /**ִ�в��� ����ִ�� ���� ���� 
     * @author   fjy
     * @version 2014��8��8�� ����4:42:01 
     * @param Entity ʵ��
     * @param IsRollBack �Ƿ�ع�����������ع�������ֵΪ-1
     * @return
     */
    int ExecuteInsert(List<IEntityBase> EntityList, Boolean IsRollBack);

 
    /**ִ�в��� ����ִ�� ���� ���� 
     * @author   fjy
     * @version 2014��8��8�� ����4:42:23 
     * @param TableList ����б�
     * @param IsRollBack �Ƿ�ع�����������ع�������ֵΪ-1
     * @return
     */
    int ExecuteDelete(List<IDvTable> TableList, Boolean IsRollBack);
    
    /**����ӳ��
     * @author   fjy
     * @version 2016��2��18�� ����10:13:33 
     * @param name
     */
    void setMapName(String name);
}
