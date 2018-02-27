package protein.enzyme.log;
 

/**日志操作接口
 * @author fjy 
 * @version 2014年8月18日 下午3:04:16 
 */
public interface ILogger {
	/**
	 * @author   fjy
	 * @version 2014年8月18日 下午3:05:37 
	 * @param Message
	 */
	void Info(Object Message);
    /**
     * @author   fjy
     * @version 2014年8月18日 下午3:05:35 
     * @param Message
     */
    void Debug(Object Message);
    /**
     * @author   fjy
     * @version 2014年8月18日 下午3:05:33 
     * @param Message
     * @param Exp
     */
    void Debug(Object Message,Exception Exp);
    /**
     * @author   fjy
     * @version 2014年8月18日 下午3:05:31 
     * @param Exp
     */
    void Error(Exception Exp);
    /**
     * @author   fjy
     * @version 2014年8月18日 下午3:05:29 
     * @param Message
     * @param Exp
     */
    void Error(Object Message, Exception Exp);
 
}
