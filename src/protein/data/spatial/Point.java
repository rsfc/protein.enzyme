package protein.data.spatial;

 
/**简单的点
 * @author fjy 
 * @version 2016年3月4日 上午3:35:20 
 */
public class Point implements IGeometry {
	
//	{ type: "Point", coordinates: [ 40, 5 ] }
	public String type = "Point";
	public double[] coordinates = null;
	public Point(){
		
	}
	
	public Point(double x,double y){
		this.coordinates=new double[] {x,y};
	}
	public double[] getCoordinates(){
		return this.coordinates;
	}
	public Point(double[] coordinates)
	{
		this.coordinates = coordinates;
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
