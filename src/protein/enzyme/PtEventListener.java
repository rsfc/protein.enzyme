package protein.enzyme;

import java.util.EventListener;
import java.util.EventObject;

/**����¼�����������
 * @author fjy
 *�¼�����
 */
public  abstract class PtEventListener implements EventListener {
	
	/**  �����¼�����
	 * @param e
	 */
	public abstract void fireEvent(EventObject e);
}
