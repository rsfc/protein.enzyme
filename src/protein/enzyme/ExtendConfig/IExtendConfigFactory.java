package protein.enzyme.ExtendConfig;

/**��չ���ù����ӿ� ������չ���ö���
 * @author fjy 
 * @version 2014��9��5�� ����12:03:55 
 */
public interface IExtendConfigFactory {

 
    /**��xml�ļ�������չ����
     * @author   fjy
     * @version 2014��9��5�� ����12:03:39 
     */
    <T> T CreateConfigFormXML();
}
