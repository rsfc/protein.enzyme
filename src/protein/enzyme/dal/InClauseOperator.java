package protein.enzyme.dal;

import java.lang.reflect.Field;
import java.util.ArrayList; 
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**处理in子语句
 * @author fjy
 *
 */
public abstract class InClauseOperator {
	 
    /**
     * 子语句值
     */
    public Map<Field, List<Object>> ClauseValues=null;
     
    public InClauseOperator()
    {
    	  
        this.ClauseValues = new HashMap<Field, List<Object>>();
    }
    
    /**添加值
     * @param PInfo
     * @param Value
     */
    public   void AddObjectValue(Field PInfo, Object Value)
    {
        if (this.ClauseValues.get(PInfo)==null) 
        {
        	List<Object> newitemList=new ArrayList<Object>();
            this.ClauseValues.put(PInfo, newitemList);
        }
        SetAndObjectValue(this.ClauseValues.get(PInfo), Value);
    }
   
    /**
     * @param SList
     * @param Value
     */
    protected   void SetAndObjectValue(List<Object> SList,Object Value)
    {
        if (SList == null)
        {
            SList = new ArrayList<Object>();
        }
        else
        {
            SList.add(Value);
        }
    }
  
    /**子句
     * @param PInfo
     * @return
     */
    public abstract String GetClause(Field PInfo);
}
