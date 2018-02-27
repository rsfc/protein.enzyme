package protein.enzyme.layout.configuration;
 
import java.util.HashMap;
import java.util.Iterator; 
import java.util.Map;
import java.util.Set;


/**数据库配置
 * @author fjy 
 * @version 2014年8月12日 上午12:40:38 
 */
public class DataBaseConfig {
	 
	/**
	 * @author   fjy
	 * @version 2014年8月12日 下午12:06:26 
	 */
	public Map<String,DbDal> DalList=new HashMap<String,DbDal>();
	
	/**根据关键字获取数据驱动配置
	 * @author   fjy
	 * @version 2014年8月13日 上午10:49:59 
	 * @param Key
	 * @return
	 */
	public DbDal getDal(String Key)
	{
		return this.DalList.get(Key); 
	}
	
	 
	/**根据顺序号获取数据驱动配置
	 * @author   fjy
	 * @version 2014年8月13日 上午10:50:12 
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
