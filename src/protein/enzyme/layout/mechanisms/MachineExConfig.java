package protein.enzyme.layout.mechanisms;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException; 

import protein.enzyme.ExtendConfig.ECC;
import protein.enzyme.layout.CustomSectionSetting;
import protein.enzyme.layout.configuration.ExConfig;
import protein.enzyme.layout.configuration.PtSetting;
 

 
/**
 * @author fjy 
 * @version 2014��9��6�� ����8:14:14 
 */
public class MachineExConfig {
	 private static MachineExConfig mec = null;
     private static ECC excc = null;

 
     /**��չ����
     * @author   fjy
     * @version 2014��9��6�� ����8:14:10 
     * @return
     */
     protected ECC getExtendConfig()
	 { 
	    return excc;   
	 }

 
     /**��ʼ����չ��������
     * 
     */
    private MachineExConfig()
     {
         try {
			InisExConfig();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			 
		} 
     }
 
 
     /** ��ȡʵ�幤����ʵ��
     * @author   fjy
     * @version 2014��9��6�� ����8:14:29 
     * @return
     */
    public static ECC getExConfigInit()
     {
         if (mec == null)
         {
             mec = new MachineExConfig();
         }
         return mec.getExtendConfig();

     }

 
     /**��ʼ����չ����
     * @author   fjy
     * @version 2014��9��6�� ����8:13:45 
     * @throws UnsupportedEncodingException 
     * @throws FileNotFoundException 
     */
    @SuppressWarnings("static-access")
	protected  void InisExConfig() throws FileNotFoundException, UnsupportedEncodingException
    {
         this.excc =new ECC();
         CustomSectionSetting css=new CustomSectionSetting();
         PtSetting pSetting=css.getSetting(); 
         if(pSetting!=null)
         {
	         for (ExConfig config : pSetting.ExConfigs)
	         { 
	             excc.addExtendConfig(config);  
	         } 
         }
    }
     
}
