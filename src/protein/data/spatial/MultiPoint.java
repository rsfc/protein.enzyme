package protein.data.spatial;

import java.util.ArrayList;
 
/**���ӵĵ�
 * @author fjy 
 * @version 2016��3��4�� ����3:34:38 
 */
public class MultiPoint implements IGeometry {
	public String type="MultiPoint";
	public ArrayList<double[]> coordinates = null;
	public MultiPoint(){}
	public MultiPoint(ArrayList<double[]> multipoint) {
		// TODO Auto-generated constructor stub
		this.coordinates = multipoint;
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
