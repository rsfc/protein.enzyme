package protein.enzyme.dal;
 

import java.util.List;
 
 
/**���ݹ���ӿ� 
 * @author fjy
 *
 */
public interface IDataHelper {
	
	/**
	 * @author   fjy
	 * @version 2014��9��2�� ����3:50:05 
	 * @return
	 */
	Integer getCount();
	
	public Integer getInt(Integer Index);
	
	public Integer getInt(String FieldName);
	/**����������ȡ����
	 * @author   fjy
	 * @version 2014��9��2�� ����4:03:19 
	 * @param cin
	 * @param index
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	<T> T getObject(Class<T> cin, Integer index) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException;
   
	  /**��ȡָ�����͵Ķ����б�
	 * @author   fjy
	 * @version 2014��8��6�� ����2:09:39 
	 * @param NewObjType
	 * @param Rs
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	<T> List<T> getObjects(Class<T> Cin) throws NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException;
	
	 /**��ȡ�������ݵ��ַ���
	 * @author   fjy
	 * @version 2016��2��23�� ����5:08:48 
	 * @return
	 */
	List<String> getObjects();
	 
	 /**�����е�����ת��Ϊӳ�������ʵ��
	 * @author   fjy
	 * @version 2016��2��23�� ����5:08:26 
	 * @param mapName ӳ������
	 * @return
	 */
	List<Object> getObjects(String mapName,IEntityFactory entityFactory);
	
	/**���������ź��ֶ�����ȡ�ֶε�ֵ
	 * @author   fjy
	 * @version 2016��3��10�� ����7:48:30 
	 * @param index
	 * @param fieldName
	 * @return
	 */
	Object getObjectValue(Integer index,String fieldName);
}
