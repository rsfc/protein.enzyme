package protein.data.spatial;

/**几何类型接口
 * @author fjy 
 * @version 2016年3月4日 上午3:33:21 
 */
public interface IGeometry {
	 /**获取类型
	 * @author   fjy
	 * @version 2016年3月5日 下午12:52:53 
	 * @return
	 */
	public String getType();
	 
	/**设置类型
	 * @author   fjy
	 * @version 2016年3月5日 下午12:53:01 
	 * @param type
	 * @return
	 */
	public void setType(String type);
}
