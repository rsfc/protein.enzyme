package protein.enzyme.log;
/**
 * @author fjy 
 * @version 2014年8月18日 下午3:05:54 
 */
public enum LogType {
	All,
	info,
	debug,
	error,
	nothing;
	
	 /**获取当前枚举的说明
	 * @author   fjy
	 * @version 2014年8月18日 下午1:01:15 
	 * @return
	 */
	public String getDescription()
     {
		switch(this.ordinal())
           {
                 case 0:
                     return "All";
                 case 1:
                     return "info";
                 case 2:
                     return "debug"; 
                 case 3:
                     return "error"; 
                 case 4:
                     return "nothing";  
                   default:
                     return null;
           }
     } 
}
