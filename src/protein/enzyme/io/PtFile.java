package protein.enzyme.io;

import java.io.File;

/**֧�������ļ�����ͨ�ú���
 * @author fjy 
 * @version 2014��9��14�� ����9:13:40 
 */
public class PtFile {
	
	/**
	 * ��ȡ�ļ���չ��
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
