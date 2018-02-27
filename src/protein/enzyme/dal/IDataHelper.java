package protein.enzyme.dal;
 

import java.util.List;
 
 
/**数据管理接口 
 * @author fjy
 *
 */
public interface IDataHelper {
	
	/**
	 * @author   fjy
	 * @version 2014年9月2日 下午3:50:05 
	 * @return
	 */
	Integer getCount();
	
	public Integer getInt(Integer Index);
	
	public Integer getInt(String FieldName);
	/**根据索引获取对象
	 * @author   fjy
	 * @version 2014年9月2日 下午4:03:19 
	 * @param cin
	 * @param index
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	<T> T getObject(Class<T> cin, Integer index) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException;
   
	  /**获取指定类型的对象列表
	 * @author   fjy
	 * @version 2014年8月6日 下午2:09:39 
	 * @param NewObjType
	 * @param Rs
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	<T> List<T> getObjects(Class<T> Cin) throws NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException;
	
	 /**获取持有数据的字符串
	 * @author   fjy
	 * @version 2016年2月23日 下午5:08:48 
	 * @return
	 */
	List<String> getObjects();
	 
	 /**将持有的数据转化为映射的物理实体
	 * @author   fjy
	 * @version 2016年2月23日 下午5:08:26 
	 * @param mapName 映射名称
	 * @return
	 */
	List<Object> getObjects(String mapName,IEntityFactory entityFactory);
	
	/**根据索引号和字段名获取字段的值
	 * @author   fjy
	 * @version 2016年3月10日 下午7:48:30 
	 * @param index
	 * @param fieldName
	 * @return
	 */
	Object getObjectValue(Integer index,String fieldName);
}
