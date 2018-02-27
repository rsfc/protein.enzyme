package protein.enzyme.layout.configuration;
 
import java.util.HashMap;
import java.util.Iterator; 
import java.util.Map;
import java.util.Set;


/**���ݿ�����
 * @author fjy 
 * @version 2014��8��12�� ����12:40:38 
 */
public class DataBaseConfig {
	 
	/**
	 * @author   fjy
	 * @version 2014��8��12�� ����12:06:26 
	 */
	public Map<String,DbDal> DalList=new HashMap<String,DbDal>();
	
	/**���ݹؼ��ֻ�ȡ������������
	 * @author   fjy
	 * @version 2014��8��13�� ����10:49:59 
	 * @param Key
	 * @return
	 */
	public DbDal getDal(String Key)
	{
		return this.DalList.get(Key); 
	}
	
	 
	/**����˳��Ż�ȡ������������
	 * @author   fjy
	 * @version 2014��8��13�� ����10:50:12 
	 * @param Index
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public DbDal getDal(int Index)
	{
		DbDal result=null;
		int cutindex=0;
		Set set = this.DalList.entrySet();    
		Iterator i = set.iterator();   
		while (i.hasNext()) { 
			if(cutindex==Index)
			{
				Map.Entry me = (Map.Entry)i.next(); 
				result=(DbDal) me.getValue();
			}
			else {
				i.next();
			}
			cutindex++;
		} 
		return result; 
	}
}
