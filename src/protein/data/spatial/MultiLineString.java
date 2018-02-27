package protein.data.spatial;

import java.util.ArrayList;
 
/**复杂的线
 * @author fjy 
 * @version 2016年3月4日 上午3:34:22 
 */
public class MultiLineString implements IGeometry {
	public String type = "MultiLineString";
	public ArrayList<ArrayList<double[]>> coordinates  = new ArrayList<ArrayList<double[]>>();
	
	public MultiLineString(){}
	
	public MultiLineString(ArrayList<ArrayList<double[]>> multiLineString){
		this.coordinates = multiLineString; 
		
	}
	
	public void add(ArrayList<ArrayList<double[]>> multiLineString){
		for(int i = 0; i<multiLineString.size(); i++){
			coordinates.add(multiLineString.get(i));
		}
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
