package protein.enzyme.io;

import java.nio.file.WatchEvent;

/**��������
 * @author fjy 
 * @version 2015��2��3�� ����4:02:51 
 */
public interface IWatchActions {
	public  void runEvent(WatchEvent<?> event);
}
