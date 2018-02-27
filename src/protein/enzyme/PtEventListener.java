package protein.enzyme;

import java.util.EventListener;
import java.util.EventObject;

/**框架事件监听功能类
 * @author fjy
 *事件监听
 */
public  abstract class PtEventListener implements EventListener {
	
	/**  发送事件数据
	 * @param e
	 */
	public abstract void fireEvent(EventObject e);
}
