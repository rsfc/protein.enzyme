package protein.enzyme.io;

import java.nio.file.WatchEvent;

/**监听动作
 * @author fjy 
 * @version 2015年2月3日 下午4:02:51 
 */
public interface IWatchActions {
	public  void runEvent(WatchEvent<?> event);
}
