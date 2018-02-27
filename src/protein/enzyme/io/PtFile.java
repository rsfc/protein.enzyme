package protein.enzyme.io;

import java.io.File;

/**支撑类库的文件处理通用函数
 * @author fjy 
 * @version 2014年9月14日 上午9:13:40 
 */
public class PtFile {
	
	/**
	 * 获取文件扩展名
	 * @param file
	 * @return
	 */
	public  static String getFileExtension(File file) {
		String fileName = file.getName();
		if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
			return fileName.substring(fileName.lastIndexOf(".") + 1);
		} else {
			return "";
		}
	}
}
