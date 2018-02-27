package protein.enzyme.ExtendConfig;

import protein.enzyme.layout.configuration.ExConfig;

public interface IECContainer {
 
    /**扩展配置对象
     * @author   fjy
     * @version 2014年9月5日 上午12:02:03 
     */
    <T> T getExtendConfig(Class<T> cin);
  
    /**添加扩展配置对象到容器
     * @author   fjy
     * @version 2014年9月5日 上午12:02:20 
     * @param NewObject
     */
    void addExtendConfig(Object NewObject);

    /**
     * @author   fjy
     * @version 2014年9月5日 上午12:02:26 
     * @param XmlFile
     * @param DllFile
     * @param ExConfig
     */
    void addExtendConfig(ExConfig ExConfig);
}
