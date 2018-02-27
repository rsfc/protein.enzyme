package protein.data.spatial;
/** ·¶Î§ºÐ×Ó
 * @author hxb
 *
 */
public class BoundingBox {
	
	public Double minx = null;
	public Double miny = null;
	public Double maxx = null;
	public Double maxy = null;
	/**
	 * 
	 */
	public BoundingBox(){};
	/**
	 * 
	 * @param minx
	 * @param miny
	 * @param maxx
	 * @param maxy
	 */
	public BoundingBox(Double minx, Double miny, Double maxx, Double maxy){
		this.minx = minx;
		this.miny = miny;
		this.maxx = maxx;
		this.maxy = maxy;
	};
}
