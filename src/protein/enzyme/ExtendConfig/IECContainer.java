package protein.enzyme.ExtendConfig;

import protein.enzyme.layout.configuration.ExConfig;

public interface IECContainer {
 
    /**��չ���ö���
     * @author   fjy
     * @version 2014��9��5�� ����12:02:03 
     */
    <T> T getExtendConfig(Class<T> cin);
  
    /**�����չ���ö�������
     * @author   fjy
     * @version 2014��9��5�� ����12:02:20 
     * @param NewObject
     */
    void addExtendConfig(Object NewObject);

    /**
     * @author   fjy
     * @version 2014��9��5�� ����12:02:26 
     * @param XmlFile
     * @param DllFile
     * @param ExConfig
     */
    void addExtendConfig(ExConfig ExConfig);
}
