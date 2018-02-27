package protein.enzyme.log;
/**
 * @author fjy 
 * @version 2014��8��18�� ����3:05:54 
 */
public enum LogType {
	All,
	info,
	debug,
	error,
	nothing;
	
	 /**��ȡ��ǰö�ٵ�˵��
	 * @author   fjy
	 * @version 2014��8��18�� ����1:01:15 
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
