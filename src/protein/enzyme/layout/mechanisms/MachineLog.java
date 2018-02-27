package protein.enzyme.layout.mechanisms;
 
import protein.enzyme.layout.configuration.LogConfig; 
import protein.enzyme.log.ILogger;

/**
 * @author fjy 
 * @version 2014年8月19日 上午12:08:56 
 */
public class MachineLog {
	
	@SuppressWarnings("unused")
	private LogConfig logconfig=null;
	
	protected static ILogger logger = null;
	
	 
    /**
     * 
     */
    private MachineLog()
    { 
    
    }
    
 
//    /**创建日志记录器
//     * @author   fjy
//     * @version 2014年8月19日 上午12:10:37 
//     * @return
//     */
//    protected static  ILogger CreateLogger()
//    { 
//    	PtSetting result=new PtSetting(); 
//        ClassDrive cd = new  ClassDrive();
//        PtResource  
//        ILogger logger = cd.Instance<ILogger>(assemblyfile, pconfig.DAlEntityConfig.ProteinLog);// LoggerManager.CreateLogger(assemblyfile, pconfig.DAlEntityConfig.ProteinLog);
//        logger.EntityFactory= MachineEntityHandler.GetEntityFactory();
//        return logger;
//    }
}
