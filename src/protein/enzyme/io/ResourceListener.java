package protein.enzyme.io;
 
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**��Դ���
 * @author fjy 
 * @version 2015��2��3�� ����3:22:23 
 */
public class ResourceListener {
	private static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
	private WatchService ws;
	private String listenerPath;
	private IWatchActions actions;
	private ResourceListener(String path,IWatchActions actions) {
		try {
			ws = FileSystems.getDefault().newWatchService();
			this.listenerPath = path;
			this.actions=actions;
			start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void start() {
		fixedThreadPool.execute(new Listner(ws,this.listenerPath,this.actions));
	}

	/**����һ������
	 * @author   fjy
	 * @version 2015��2��3�� ����3:13:55 
	 * @param path
	 * @throws IOException
	 */
	public static void createListener(String path,IWatchActions actions) throws IOException {
		ResourceListener resourceListener = new ResourceListener(path,actions);
		Path p = Paths.get(path);
		p.register(resourceListener.ws,StandardWatchEventKinds.ENTRY_MODIFY,
			StandardWatchEventKinds.ENTRY_DELETE,
			StandardWatchEventKinds.ENTRY_CREATE);
	}
	

//	public static void main(String[] args) throws IOException {
//		ResourceListener.addListener("E:/aaa");
//	}
}

/**����
 * @author fjy 
 * @version 2015��2��3�� ����3:31:29 
 */
class Listner implements Runnable {
	private WatchService service;
	private String rootPath;
	private IWatchActions actions;
	public Listner(WatchService service,String rootPath,IWatchActions actions) {
		this.service = service;
		this.rootPath = rootPath;
		this.actions=actions;
	}

	public void run() {
		try {
			while(true){
				WatchKey watchKey = service.take();
				List<WatchEvent<?>> watchEvents = watchKey.pollEvents();
				for(WatchEvent<?> event : watchEvents){
					if(this.actions!=null)
					{
						this.actions.runEvent(event);
					} 
//					//TODO �����¼����Ͳ�ȡ��ͬ�Ĳ�����������������
//					System.out.println("["+rootPath+"/"+event.context()+"]�ļ�������["+event.kind()+"]�¼�");  
				}
				watchKey.reset();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			//System.out.println("fdsfsdf");
			try {
				service.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
	}
}
 
 
