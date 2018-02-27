package protein.enzyme.dal;

import java.util.List;
import java.util.Set;


/**���ݲ����ӿ� �ýӿ����ڹ������ݲ��������༭����
 * @author fjy 
 * @version 2014��8��8�� ����4:54:06 
 */
public interface IDALManager {
 
	/**��ȡ���ݿ���Ϣ
	 * @author   fjy
	 * @version 2014��9��7�� ����2:41:37 
	 * @return
	 */
	IDBInfo getDbInfo();
	
	
    /**ʵ���Ƿ����
     * @author   fjy
     * @version 2014��8��8�� ����4:53:54 
     * @param Entity
     * @return
     */
    <T> Boolean IsEntityExist(Class<T> cin);
    
    /**ʵ���Ƿ����
     * @author   fjy
     * @version 2016��2��23�� ����12:08:34 
     * @param mapName
     * @return
     */
    Boolean IsEntityExist(String mapName);
    
    /**ɾ��ʵ��
     * @author cyf
     * @version 2017��4��17�� ����5:00:00
     * @param mapName
     * @return
     */
    Boolean DropEntity(String mapName);
    
    /**����ʵ��
     * @author   fjy
     * @version 2014��8��8�� ����4:53:56 
     * @param Entity
     * @return
     */
    Boolean CreateEntity(IEntityBase Entity);
    
    /**ɾ��ʵ��
     * @author cyf
     * @version 2017��4��27�� ����5:53:00
     * @param Entity
     * @return
     */
    Boolean DropEntity(IEntityBase Entity);
    
    /**�������ݿ�
     * @author  hxb
     * @version 2014��9��25�� ����11:42:59
     * @return Boolean
     */
    Boolean CreateDB();
    
    /**�ж����ݿ��Ƿ����
     * @author  hxb
     * @version 2014��9��25�� ����11:43:57
     * @param cin
     * @return Boolean
     */
    Boolean IsDBExist();
    /**
     * �ж����ݿ�����Ƿ���
     * @author   fjy
     * @version 2015��1��31�� ����8:57:31 
     * @return
     */
    Boolean isDBServiceOpen();
    
    /**��ȡ����ʵ������
     * @author cyf
     * @version 2017��4��28�� ����4:32:20
     * @return
     */
    Set<String> getAllEntityName();
    
    /**�������ݿ����
     * @author   fjy
     * @version 2015��1��31�� ����8:59:38 
     * @return
     */
    Boolean startUpDBService();
    
    /**�ر����ݷ���
     * @author   fjy
     * @version 2015��1��31�� ����11:25:34 
     * @return
     */
    Boolean shutdownDBService();
    
    Boolean addFieldsToEntity(String entityName,List<String> newFieldNames);
}
