package protein.data.spatial;

import java.util.ArrayList;
 
/**复杂的面
 * @author fjy 
 * @version 2016年3月4日 上午3:35:03 
 */
public class MultiPolygon implements IGeometry {
	public String type = "MultiPolygon";
	public ArrayList<ArrayList<ArrayList<double[]>>> coordinates = new ArrayList<ArrayList<ArrayList<double[]>>>();
	public MultiPolygon(){}
	public MultiPolygon(ArrayList<ArrayList<ArrayList<double[]>>> coordinates){
		this.coordinates = coordinates;
		
	}
	/**
	 * 娣诲姞澶氳竟褰�
	 * @param polygon
	 */
	public void add(ArrayList<ArrayList<double[]>> polygon){
		this.coordinates.add(polygon);
	}
	/**
	 * 鍚戞煇涓�杈瑰舰娣诲姞鐐�
	 * @param point
	 * @param index1 澶氳竟褰㈡墍鍦ㄧ殑澶嶆潅澶氳竟褰㈢殑绱㈠紩锛岄粯璁や负0
	 * @param index2 澶氳竟褰腑鏌愪竴闂悎鏁扮粍鐨勭储寮曪紝榛樿涓�
	 */
	public void add(double[] point, int index1, int index2){
		this.coordinates.get(index1).get(index2).add(point);
	}
	/**
	 * 鍚戞煇涓�杈瑰舰娣诲姞澶氫釜鐐�
	 * @param points
	 * @param index1 澶氳竟褰㈡墍鍦ㄧ殑澶嶆潅澶氳竟褰㈢殑绱㈠紩锛岄粯璁や负0
	 * @param index2 澶氳竟褰腑鏌愪竴闂悎鏁扮粍鐨勭储寮曪紝榛樿涓�
	 */
	public void add(ArrayList<double[]> points, int index1, int index2){
		for(int i = 0; i < points.size(); i++)  
        {  
			this.coordinates.get(index1).get(index2).add(points.get(i));
        }  
	}
	/**
	 * 鑾峰彇褰撳墠澶嶆潅澶氳竟褰�
	 * @return
	 */
	public ArrayList<ArrayList<ArrayList<double[]>>> getCoordinates(){
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
