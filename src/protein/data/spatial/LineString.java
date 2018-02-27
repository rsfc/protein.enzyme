package protein.data.spatial;

import java.util.ArrayList;
 
/**简单的线
 * @author fjy 
 * @version 2016年3月4日 上午3:34:01 
 */
public class LineString implements IGeometry {
//	{ type: "LineString", coordinates: [ [ 40, 5 ], [ 41, 6 ] ] }
	public String type = "LineString";
	public ArrayList<double[]>  coordinates = null;
	public LineString(){}
	public LineString(ArrayList<double[]> coordinates){
		this.coordinates = coordinates;
	}
	public ArrayList<double[]>  getCoordinates(){
		return this.coordinates;
	}
	 
	/**添加点集合
	 * @author   fjy
	 * @version 2016年3月5日 下午12:54:00 
	 * @param points
	 */
	public void add(ArrayList<double[]>  points){
		for(int i = 0; i < points.size(); i++)  
        {  
			this.coordinates.add(points.get(i));
        }  
	}
	
	/**添加点
	 * @author   fjy
	 * @version 2016年3月5日 下午12:54:15 
	 * @param points
	 */
	public void add(double[]  points){
		this.coordinates.add(points);
	}
	@Override
	public String getType() { 
		return this.type;
	}
	@Override
	public void setType(String type) { 
		 this.type=type;
	}
}
