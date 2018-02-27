package protein.data.spatial;

/**
 * 几何类型
 * 
 * @author fjy
 * @version 2016年3月4日 上午3:42:03
 */
public enum GeometryType {
	/**
	 * 简单的点
	 * 
	 * @author fjy
	 * @version 2016年3月4日 上午3:45:23
	 */
	Point, /**
	 * 复杂的点
	 * 
	 * @author fjy
	 * @version 2016年3月4日 上午3:45:33
	 */
	MultiPoint, /**
	 * 简单的线
	 * 
	 * @author fjy
	 * @version 2016年3月4日 上午3:45:50
	 */
	LineString, /**
	 * 复杂的线
	 * 
	 * @author fjy
	 * @version 2016年3月4日 上午3:45:57
	 */
	MultiLineString, /**
	 * 简单的面
	 * 
	 * @author fjy
	 * @version 2016年3月4日 上午3:46:05
	 */
	Polygon, /**
	 * 复杂的面
	 * 
	 * @author fjy
	 * @version 2016年3月4日 上午3:46:14
	 */
	MultiPolygon,
	/**未知
	 * @author   fjy
	 * @version 2016年3月4日 上午3:47:13 
	 */
	Unknown;
	public GeometryType convertFromInt(Integer integer) {
		switch (integer) {
		case 0:
			return GeometryType.Point;
		case 1:
			return GeometryType.MultiPoint;
		case 2:
			return GeometryType.LineString;
		case 3:
			return GeometryType.MultiLineString;
		case 4:
			return GeometryType.Polygon;
		case 5:
			return GeometryType.MultiPolygon;
		default:
			return GeometryType.Unknown;
		}
	};

	/**
	 * 获取当前枚举的说明
	 * 
	 * @author fjy
	 * @version 2016年2月10日 下午5:06:42
	 * @return
	 */
	public String getDescription() {
		switch (this.ordinal()) {
		case 0:
			return "Point";
		case 1:
			return "MultiPoint";
		case 2:
			return "LineString";
		case 3:
			return "MultiLineString";
		case 4:
			return "Polygon";
		case 5:
			return "MultiPolygon";
		default:
			return "Unknown";
		}
	}
}
