package protein.enzyme.dal;

import java.util.List;
 

 

/**ʵ�幤���ӿ�
 * @author fjy 
 * @version 2014��8��8�� ����4:29:50  
 */
public interface IEntityFactory {
	  
	/**��ȡ���ݿ��Ƿ����
	 * @author   fjy
	 * @version 2014��10��1�� ����8:46:12 
	 * @return
	 */
	Boolean getDbHealth();
	
    /**����ʵ�����ʵ��
     * @author   fjy
     * @version 2014��8��8�� ����4:34:51 
     * @return
     */
    <T> T CreateEntityInstance(Class<T> Cin,Object ... Parameters);
    
    /**�����ֶ����ݴ���ʵ��
     * @author   fjy
     * @version 2016��2��23�� ����7:41:39 
     * @param fields
     * @return
     */
    Object CreateEntityInstance(List<EntityField> fields);
    
    /**��ȡ���ݿ���Ϣ��������
     * @author   fjy
     * @version 2015��1��31�� ����9:47:50 
     * @return
     */
    Class  getDBInfoClass();
    /**���ݿ���Ϣ
     * @author   fjy
     * @version 2014��8��8�� ����4:36:06 
     * @return
     */
    IDBInfo getDbInfo();
    /**�������ݿ���Ϣ����ʵ��
     * @author   fjy
     * @version 2015��1��31�� ����10:34:13 
     */
    void setDBInfo(IDBInfo dbinfo);
    /**������������������
     * @author   fjy
     * @version 2014��8��8�� ����4:36:36 
     * @param Entity
     * @return
     */
    IDvTable CreateDriveTable(IEntityBase Entity);
    IDvTable CreateDriveTable(IEntityBase Entity,String mapping);
    /**����ʵ�����ƴ���������������������ڸ����ƻ��ӳ�����Ƶ��������ݽ�����null
     * @author   fjy
     * @version 2016��2��23�� ����9:21:22 
     * @param entityName
     * @return
     */
    IDvTable  CreateDriveTable(String entityName) ;
     
    /** �����������������������
     * @author   fjy
     * @version 2014��8��8�� ����4:53:08 
     * @return
     */
    IDvTableBatch CreateDriveTableBatch();
    
    /**����ʵ�����ƴ������������������������������ڸ����ƻ��ӳ�����Ƶ��������ݽ�����null
     * @author   fjy
     * @version 2016��6��6�� ����9:34:04 
     * @param entityName
     * @return
     */
    IDvTableBatch CreateDriveTableBatch(String entityName);
    /**����ӿ�
     * @author   fjy
     * @version 2014��8��8�� ����4:54:19 
     * @return
     */
    IDALManager CreateDALmanager();
 
    /**�����ռ�����ӿ�
     * @author   fjy
     * @version 2015��2��1�� ����1:06:38 
     * @return
     */
    ISpatialAnalysis createSpatialAnalysis();
    /** ����µ�ʵ�����ʹ���������
     * @author   fjy
     * @version 2014��8��11�� ����4:25:26 
     * @param NewAdapter
     */
    void AddAdapter(EntityTypeAdapter NewAdapter);
     
    /**�رչ���
     * @author   fjy
     * @version 2014��9��2�� ����11:02:42 
     */
    void CloseFactory();
    
    /**
     * @author   fjy
     * @version 2014��9��2�� ����11:02:35 
     * @param Entity
     * @param FieldName
     * @return
     */
    Integer GetMaxField(IEntityBase Entity, String FieldName);
    
    /**����Ԫ����
     * @author   fjy
     * @version 2016��2��24�� ����7:47:39 
     * @param entityName
     * @return
     */
    IMetaData CreateMetaData(String entityName);
    
    /**����Ԫ�����ֶΣ����޸�����Դ���ֶ�ֵ,Ŀǰֻ�������ƣ�������ʱֻ��mongodb���Բ������ֶ�����
     * @author   fjy
     * @version 2016��5��21�� ����11:17:24 
     * @param entityName
     * @param fieldNames
     * @return
     */
    Boolean addMetaDataFields(String entityName,List<String> fieldNames);
    
}
