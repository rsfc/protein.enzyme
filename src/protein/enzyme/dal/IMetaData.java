package protein.enzyme.dal;

import java.util.HashMap;

/**Ԫ���ݽӿ�
 * @author fjy 
 * @version 2016��2��24�� ����7:35:38 
 */
public interface IMetaData {
	/**��ȡԪ���ݵ�json����ʽ
	 * @author   fjy
	 * @version 2016��2��24�� ����7:36:06 
	 * @return
	 */
	public String getMetaDataJson();
	
	/**��ȡԪ����ʵ��
	 * @author   fjy
	 * @version 2016��2��24�� ����7:37:08 
	 * @return
	 */
	public Object getMetaDataInstance();
	
	public HashMap getFieldTypes();
	
	
	 
}
