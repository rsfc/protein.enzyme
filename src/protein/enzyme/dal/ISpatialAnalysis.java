package protein.enzyme.dal;
 
import protein.data.spatial.LineString;
import protein.data.spatial.MultiPolygon;
import protein.data.spatial.Point;
import protein.data.spatial.Polygon;

/**空间分析接口，该对象由实体工厂构造，是针对实体工厂对应的数据库连接对象的操作
 * @author fjy 
 * @version 2015年2月1日 上午11:12:09 
 */
public interface ISpatialAnalysis {
	

	/**相交
	 * @author   fjy
	 * @version 2016年2月19日 下午5:47:02 
	 * @param entityCin
	 * @param polygon
	 * @return
	 */
	IDataHelper intersect(Class entityCin,Polygon polygon);
	/**于多边形相交
	 * @author   fjy
	 * @version 2016年2月28日 下午1:34:11 
	 * @param entityCin
	 * @param multiPolygon
	 * @return
	 */
	IDataHelper intersect(Class entityCin,MultiPolygon multiPolygon);
	/**相交
	 * @author   fjy
	 * @version 2016年2月19日 下午5:47:07 
	 * @param mapName
	 * @param polygon
	 * @return
	 */
	IDataHelper intersect(String mapName,Polygon polygon);
	IDataHelper intersect(String mapName,Point sPoint);
	/**与多边形相交
	 * @author   fjy
	 * @version 2016年2月28日 下午1:34:44 
	 * @param mapName
	 * @param multiPolygon
	 * @return
	 */
	IDataHelper intersect(String mapName,MultiPolygon multiPolygon);
	
	
	/**查询与线相交的
	 * @author   fjy
	 * @version 2016年2月29日 上午11:41:51 
	 * @param mapName
	 * @param lineString
	 * @return
	 */
	IDataHelper intersect(String mapName,LineString lineString);
	/**查询数据实体中被参数指定的多边形包围的空间对象
	 * @author   fjy
	 * @version 2015年2月1日 下午11:02:18 
	 * @param entityCin 要查询的实体对象类型
	 * @param polygon 查询范围
	 * @return
	 */
	IDataHelper within(Class entityCin,Polygon polygon);
	/**根据映射名称查询多边形包围的的空间对象
	 * @author   fjy
	 * @version 2016年2月19日 上午11:54:09 
	 * @param mapName
	 * @param polygon
	 * @return
	 */
	IDataHelper within(String mapName,Polygon polygon);
	
	/**
	 * @author   fjy
	 * @version 2016年2月28日 下午1:39:32 
	 * @param mapName
	 * @param polygon
	 * @return
	 */
	IDataHelper within(String mapName,MultiPolygon polygon);
	/**范围查询
	 * @author   fjy
	 * @version 2016年2月12日 下午4:30:03 
	 * @param polygon
	 * @return
	 */
	<T> IDataHelper within(Polygon polygon);
	
	/**临近点查询
	 * @author   fjy
	 * @version 2016年2月12日 下午4:30:06 
	 * @param point
	 * @param range
	 * @return
	 */
	IDataHelper comeNearPoint(Class entityCin,Point point,double range);
	
	/**根据映射名称进行点临近查询
	 * @author   fjy
	 * @version 2016年2月19日 上午11:54:25 
	 * @param mapName
	 * @param point
	 * @param range
	 * @return
	 */
	IDataHelper comeNearPoint(String mapName,Point point, double range);
 
	/**创建空间索引
	 * @author   fjy
	 * @version 2016年2月12日 下午4:30:25 
	 * @param entityCin
	 * @param keys
	 * @param name
	 * @return
	 */
//	Boolean createSpatialIndex(String entityName,String keys);
	
	/**创建空间索引
	 * @author   fjy
	 * @version 2016年5月21日 上午10:44:36 
	 * @param entityName
	 * @return
	 */
	Boolean createSpatialIndex(String entityName);
	
	/**是否存在空间索引
	 * @author   fjy
	 * @version 2016年5月21日 上午10:50:46 
	 * @param EntityName
	 * @return
	 */
	Boolean existSpatialIndex(String entityName);
	/**与复杂面相交的驱动表格对象
	 * @author   fjy
	 * @version 2016年2月29日 下午4:58:37 
	 * @param table
	 * @param multiPolygon
	 * @return
	 */
	IDataHelper intersect(IDvTable table,Polygon multiPolygon);
	
	/**
	 * 与点相交的表格驱动对象
	 * @author   fjy
	 * @version 2016年5月20日 上午10:13:32 
	 * @param table
	 * @param sPoint
	 * @return
	 */
	IDataHelper intersect(IDvTable table,Point sPoint);
}
