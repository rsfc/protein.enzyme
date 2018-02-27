package protein.data.spatial;

/**
 * ��������
 * 
 * @author fjy
 * @version 2016��3��4�� ����3:42:03
 */
public enum GeometryType {
	/**
	 * �򵥵ĵ�
	 * 
	 * @author fjy
	 * @version 2016��3��4�� ����3:45:23
	 */
	Point, /**
	 * ���ӵĵ�
	 * 
	 * @author fjy
	 * @version 2016��3��4�� ����3:45:33
	 */
	MultiPoint, /**
	 * �򵥵���
	 * 
	 * @author fjy
	 * @version 2016��3��4�� ����3:45:50
	 */
	LineString, /**
	 * ���ӵ���
	 * 
	 * @author fjy
	 * @version 2016��3��4�� ����3:45:57
	 */
	MultiLineString, /**
	 * �򵥵���
	 * 
	 * @author fjy
	 * @version 2016��3��4�� ����3:46:05
	 */
	Polygon, /**
	 * ���ӵ���
	 * 
	 * @author fjy
	 * @version 2016��3��4�� ����3:46:14
	 */
	MultiPolygon,
	/**δ֪
	 * @author   fjy
	 * @version 2016��3��4�� ����3:47:13 
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
	 * ��ȡ��ǰö�ٵ�˵��
	 * 
	 * @author fjy
	 * @version 2016��2��10�� ����5:06:42
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
