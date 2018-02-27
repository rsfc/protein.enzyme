package protein.enzyme.dal;

/**
 * @author fjy 
 * @version 2014年8月11日 下午2:40:55 
 */
public class EntityTypeAdapterGenerics<T,TC> extends EntityTypeAdapter {
 
	@SuppressWarnings("rawtypes")
	protected Class tclass=null;
	@SuppressWarnings("rawtypes")
	protected Class tcclass=null;
	
	@SuppressWarnings("rawtypes")
	@Override
	protected boolean IsType(Class ClassType) { 
		  //获取接口
        if (ClassType.getName().equals(tclass.getName()))
        { 
            super.targettype = tcclass;
            return true;
        }
        return false;
	}
	
	/**设置类型键值对
	 * @author   fjy
	 * @version 2014年8月11日 下午4:21:18 
	 * @param CinT
	 * @param CinTC
	 */
	public void SetEntityKeyv(Class<T> CinT,Class<TC> CinTC)
	{
		this.tclass=CinT;
		this.tcclass=CinTC;
	}
	 
}
