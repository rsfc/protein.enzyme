package protein.enzyme.message;

/**������Ϣ
 * @author fjy 
 * @version 2014��8��18�� ����12:57:39 
 */
public interface IProcessor  {
	 
    /**������Ϣ
     * @author   fjy
     * @version 2014��8��18�� ����12:58:01 
     * @param Content
     */
    Boolean ProcessMessage(IMessageContent Content);
    
 
}
