package protein.enzyme.dal;

/**操作符
 * @author fjy
 *
 */
public enum DalOperator {
	 
	 Deng,
	 Da,
	 Xiao,
	 BuDeng,
	 Da_Deng,
	 Xiao_Deng,
	 Fun_All,
	 Fun_Max,
	 In,
	 Count,
	 LikeStart,
	 LikeEnd,
	 LikeAll;
	 
	 /**获取当前枚举的说明
	 * @author   fjy
	 * @version 2014年8月5日 下午3:37:45 
	 * @return
	 */
	public String getDescription()
     {
           switch(this.ordinal())
               {
                     case 0:
                         return "=";
                     case 1:
                         return ">";
                     case 2:
                         return "<";
                     case 3:
                         return "<>";
                     case 4:
                         return ">=";
                     case 5:
                         return "<=";
                     case 6:
                         return "*";
                     case 7:
                         return "MAX";
                     case 8:
                         return "IN";
                     case 9:
                         return "COUNT";
                     case 10:
                         return "LIKE";
                     case 11:
                         return "LIKE";
                     case 12:
                         return "LIKE"; 
                       default:
                         return    null;
               }
     } 
   
}
