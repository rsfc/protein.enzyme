package protein.enzyme.message;

/**��Ϣ���ݽӿ�
 * @author fjy 
 * @version 2014��8��19�� ����1:01:16 
 */
public interface IMessageContent<T> {
	/**��ȡ��������
	 * @author   fjy
	 * @version 2014��8��19�� ����5:48:47 
	 * @return
	 */
	Class getContentType(); 
	
	/**��ȡ����
	 * @author   fjy
	 * @version 2014��8��19�� ����5:52:03 
	 * @return
	 */
	T getContent();
	
	/**��������
	 * @author   fjy
	 * @version 2014��8��19�� ����9:58:11 
	 * @param content
	 */
	void setContent(T content);
	
}
