package protein.enzyme.dal;

/**
 * @author fjy 
 * @version 2014��8��11�� ����2:40:55 
 */
public class EntityTypeAdapterGenerics<T,TC> extends EntityTypeAdapter {
 
	@SuppressWarnings("rawtypes")
	protected Class tclass=null;
	@SuppressWarnings("rawtypes")
	protected Class tcclass=null;
	
	@SuppressWarnings("rawtypes")
	@Override
	protected boolean IsType(Class ClassType) { 
		  //��ȡ�ӿ�
        if (ClassType.getName().equals(tclass.getName()))
        { 
            super.targettype = tcclass;
            return true;
        }
        return false;
	}
	
	/**�������ͼ�ֵ��
	 * @author   fjy
	 * @version 2014��8��11�� ����4:21:18 
	 * @param CinT
	 * @param CinTC
	 */
	public void SetEntityKeyv(Class<T> CinT,Class<TC> CinTC)
	{
		this.tclass=CinT;
		this.tcclass=CinTC;
	}
	 
}
