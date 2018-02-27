package protein.enzyme.log;
import java.util.Date; 
import protein.enzyme.dal.IEntityBase;

/**日志实体接口
 * @author fjy 
 * @version 2014年8月18日 下午2:58:31 
 */
public interface ILog  extends   IEntityBase  {
 
    /**获取日志内容
     * @author   fjy
     * @version 2014年8月18日 下午2:58:18 
     * @return
     */
    public String getCONTENT();
    
    /**设置日志内容
     * @author   fjy
     * @version 2014年8月18日 下午2:58:14 
     * @return
     */
    public void setCONTENT(String content);
 
    /**获取日志编码
     * @author   fjy
     * @version 2014年8月18日 下午2:59:16 
     * @return
     */
    public long getLOGCODE();
    
    /**设置日志编码
     * @author   fjy
     * @version 2014年8月18日 下午2:59:04 
     */
    public void setLOGCODE(long logCode);
 
     /**日志时间
     * @author   fjy
     * @version 2014年9月17日 下午3:36:58 
     * @return
     */
    public Date getLOGTIME();
     
     /**设置日志时间
     * @author   fjy
     * @version 2014年9月17日 下午3:36:43 
     * @param date
     */
    public void setLOGTIME(Date date);
     
    /**获取日志类型
     * @author   fjy
     * @version 2014年8月18日 下午3:00:31 
     * @return
     */
    public String getLOGTYPE();
    
    /**
     * @author   fjy
     * @version 2014年8月18日 下午3:03:09 
     * @param logType
     */
    public void setLOGTYPE(String logType);
}
