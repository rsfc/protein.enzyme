package protein.enzyme.dal;

/**������߼����㷨
 * @author fjy
 *
 */
public enum LinkOperator { 
	 And,
	 Or,
	 Nul;
	 /**��ȡ��ǰö�ٵ�˵��
	 * @author   fjy
	 * @version 2014��8��5�� ����3:37:45 
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
