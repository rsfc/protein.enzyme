package protein.enzyme.dal;

/**子语句逻辑运算法
 * @author fjy
 *
 */
public enum LinkOperator { 
	 And,
	 Or,
	 Nul;
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
                     return "and";
                 case 1:
                     return "or";
                 case 2:
                     return "null"; 
                   default:
                     return    null;
           }
     } 
 
}
