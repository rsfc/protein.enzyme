package protein.data.spatial;

import java.util.ArrayList;
import java.util.List;
/**
 * 简单的多边形
 * @author hxb
 */
public class Polygon implements IGeometry {
	public String type = "Polygon";
	public ArrayList<ArrayList<double[]>> coordinates = null;
	public Polygon(){}
	public Polygon(ArrayList<ArrayList<double[]>> coordinates){
		this.coordinates = coordinates;
	}
	
	/**创建面
	 * @param points 一个环的点集合
	 */
	public Polygon(List<Point> points){
		ArrayList<double[]> polygonArr = new ArrayList<double[]>();
		for (Point point : points) {
			double[] tmpoint = point.coordinates;
			polygonArr.add(tmpoint);
		}
		polygonArr.add(points.get(0).coordinates); 
		this.coordinates  = new ArrayList<ArrayList<double[]>>();
		this.coordinates.add(polygonArr);
	}
	/**
	 *  添加点集合
	 * @param pointArray
	 * @param index
	 */
	public void add(ArrayList<double[]> pointArray, int index){
		for(int i = 0; i < pointArray.size(); i++)  
        {  
			this.coordinates.get(index).add(pointArray.get(i));
        }  
	}
	/**
	 * 添加点
	 * @param point
	 * @param index
	 */
	public void add(double[] point, int index){
		this.coordinates.get(index).add(point);
	}
	/**
	 * 添加多边形数组，闭合的数组
	 * @param pointArray
	 */
	public void add(ArrayList<double[]> pointArray){
		this.coordinates.add(pointArray);
	}
	private void isClosed(ArrayList<ArrayList<double[]>> lineStrings){
		
	}
	
	public ArrayList<ArrayList<double[]>> getCoordinates(){
		return this.coordinates;
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
