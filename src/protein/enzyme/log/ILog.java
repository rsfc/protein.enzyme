package protein.enzyme.log;
import java.util.Date; 
import protein.enzyme.dal.IEntityBase;

/**��־ʵ��ӿ�
 * @author fjy 
 * @version 2014��8��18�� ����2:58:31 
 */
public interface ILog  extends   IEntityBase  {
 
    /**��ȡ��־����
     * @author   fjy
     * @version 2014��8��18�� ����2:58:18 
     * @return
     */
    public String getCONTENT();
    
    /**������־����
     * @author   fjy
     * @version 2014��8��18�� ����2:58:14 
     * @return
     */
    public void setCONTENT(String content);
 
    /**��ȡ��־����
     * @author   fjy
     * @version 2014��8��18�� ����2:59:16 
     * @return
     */
    public long getLOGCODE();
    
    /**������־����
     * @author   fjy
     * @version 2014��8��18�� ����2:59:04 
     */
    public void setLOGCODE(long logCode);
 
     /**��־ʱ��
     * @author   fjy
     * @version 2014��9��17�� ����3:36:58 
     * @return
     */
    public Date getLOGTIME();
     
     /**������־ʱ��
     * @author   fjy
     * @version 2014��9��17�� ����3:36:43 
     * @param date
     */
    public void setLOGTIME(Date date);
     
    /**��ȡ��־����
     * @author   fjy
     * @version 2014��8��18�� ����3:00:31 
     * @return
     */
    public String getLOGTYPE();
    
    /**
     * @author   fjy
     * @version 2014��8��18�� ����3:03:09 
     * @param logType
     */
    public void setLOGTYPE(String logType);
}
