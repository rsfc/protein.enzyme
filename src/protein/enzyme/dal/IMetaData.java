package protein.enzyme.dal;

import java.util.HashMap;

/**元数据接口
 * @author fjy 
 * @version 2016年2月24日 下午7:35:38 
 */
public interface IMetaData {
	/**获取元数据的json表达格式
	 * @author   fjy
	 * @version 2016年2月24日 下午7:36:06 
	 * @return
	 */
	public String getMetaDataJson();
	
	/**获取元数据实例
	 * @author   fjy
	 * @version 2016年2月24日 下午7:37:08 
	 * @return
	 */
	public Object getMetaDataInstance();
	
	public HashMap getFieldTypes();
	
	
	 
}
