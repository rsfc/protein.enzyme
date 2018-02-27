package protein.enzyme.dal;

import java.sql.SQLException;
import java.util.List;

/**���ݿ�����ӿ�
 * @author fjy 
 * @version 2014��8��5�� ����1:28:15 
 */
public interface IDalSql {
	  
	/**��ȡ��ǰdal��������״̬�Ƿ񽡿�
	 * @author   fjy
	 * @version 2014��8��8�� ����3:16:33 
	 * @return
	 */
	boolean getHasHealth();
    /**
     * 
     */
    IDBInfo DbHelper=null;
    
     
    /**�������������ݿ�
     * @param Table
     * @return
     * @throws SQLException 
     */
    int Insert(IDvTable Table) throws SQLException;
     
    /**���ݱ�������ݲ�ѯ����
     * @param Table
     * @return
     * @throws SQLException 
     */
    IDataHelper SelectSingle(IDvTable Table) throws SQLException ;
    
    /**ɾ�����еĸö���
     * @param Table
     * @return
     */
    int Delete(IDvTable Table);
 
    /**�޸ı��еĶ�������
     * @param Table
     * @return
     */
    int Update(IDvTable Table); 
   
    /**�����������ݿ��¼
     * @param Tables
     * @param IsRollBack �Ƿ������ڲ����쳣ʱ�ع���trueΪ�����쳣�ǻع����в�����false�����쳣��¼
     * @return
     */
    int InsertTran(List<IDvTable> Tables,Boolean IsRollBack);
    
    /**�����������ݿ��¼
     * @param Tables
     * @param IsRollBack �Ƿ������ڲ����쳣ʱ�ع���trueΪ�����쳣�ǻع����в�����false�����쳣��¼
     * @return Ӱ��ļ�¼����
     */
    int UpdateTran(List<IDvTable> Tables, Boolean IsRollBack);

    
    /**����ɾ�����ݿ��¼
     * @param Tables
     * @param IsRollBack �Ƿ������ڲ����쳣ʱ�ع���trueΪ�����쳣�ǻع����в�����false�����쳣��¼
     * @return Ӱ��ļ�¼����
     */
    int DeleteTran(List<IDvTable> Tables, Boolean IsRollBack);
    
    
    IDataHelper SelectSingleTest(IDvTable Table) throws SQLException ;
}
