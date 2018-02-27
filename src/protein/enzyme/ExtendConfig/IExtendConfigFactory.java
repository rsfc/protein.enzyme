package protein.enzyme.ExtendConfig;

/**扩展配置工厂接口 创建扩展配置对象
 * @author fjy 
 * @version 2014年9月5日 上午12:03:55 
 */
public interface IExtendConfigFactory {

 
    /**从xml文件创建扩展配置
     * @author   fjy
     * @version 2014年9月5日 上午12:03:39 
     */
    <T> T CreateConfigFormXML();
}
