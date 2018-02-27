package protein.enzyme.message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import protein.enzyme.design.ClassDrive;
import protein.enzyme.log.ILogger;
import protein.enzyme.log.LoggerManager;
import protein.enzyme.message.content.BasisText;
import protein.enzyme.message.content.ContentDebugLog;
import protein.enzyme.message.content.ContentErrorLog;
import protein.enzyme.message.content.ContentNoteLog;
import protein.enzyme.message.content.DeadlyErrorLog;
import protein.enzyme.message.processors.ProcessBasisTextLog;
import protein.enzyme.message.processors.ProcessDeadlyLog;
import protein.enzyme.message.processors.ProcessDebugLog;
import protein.enzyme.message.processors.ProcessErrorLog;
import protein.enzyme.message.processors.ProcessNoteLog;

/**处理器池
 * @author fjy 
 * @version 2014年8月19日 下午11:07:04 
 */
public class ProcessorPool {
	
	private static ProcessorPool inspoolPool=null; 
	private Map<Class, ArrayList<PoolHde>> hdelist=new HashMap<Class, ArrayList<PoolHde>>();
	
	private ProcessorPool()
	{ 
		this.setProcessDebug();
		this.setProcessError();
		this.setProcessNote();
		this.setProcessDeadly();
		//this.setProcessBasisText();
	}
	
	/**设置支撑类库中消息总线的异常处理器
	 * @author   fjy
	 * @version 2014年8月23日 上午10:52:37 
	 */
	private void setProcessError(){ 
		LoggerManager lm=new LoggerManager(); 
		ILogger Logger=lm.getProteinLogger(); 
		List<Object> args=new ArrayList<Object>();
		args.add(Logger);
		ProcessBasisTextLog pError=new ProcessBasisTextLog();
		ContentErrorLog cError=new ContentErrorLog();
		PoolHde poolHde=new PoolHde(pError,args);
		this.addHdeKey(cError.getContentType(), poolHde); 
	}
	private void setProcessBasisText()
	{
		ProcessBasisTextLog basisl=new ProcessBasisTextLog();
		BasisText basis=new BasisText(); 
		PoolHde poolHde=new PoolHde(basisl,null);
		this.addHdeKey(basis.getContentType(), poolHde);   
	}
	/**设置处理过程
	 * @author   fjy
	 * @version 2014年8月23日 下午9:28:29 
	 */
	private void setProcessNote()
	{
		LoggerManager lm=new LoggerManager(); 
		ILogger Logger=lm.getProteinLogger(); 
		List<Object> args=new ArrayList<Object>();
		args.add(Logger);
		ProcessNoteLog pNote=new ProcessNoteLog(Logger);
		ContentNoteLog cNote=new ContentNoteLog();
		PoolHde poolHde=new PoolHde(pNote,args);
		this.addHdeKey(cNote.getContentType(), poolHde); 
	}
	
	/**设置处理过程
	 * @author   fjy
	 * @version 2014年8月23日 下午9:28:29 
	 */
	private void setProcessDebug()
	{
		LoggerManager lm=new LoggerManager(); 
		ILogger Logger=lm.getProteinLogger(); 
		List<Object> args=new ArrayList<Object>();
		args.add(Logger);
		ProcessDebugLog pNote=new ProcessDebugLog(Logger);
		ContentDebugLog cNote=new ContentDebugLog();
		PoolHde poolHde=new PoolHde(pNote,args);
		this.addHdeKey(cNote.getContentType(), poolHde); 
	}
	
	/**设置处理过程
	 * @author   fjy
	 * @version 2014年8月23日 下午9:28:29 
	 */
	private void setProcessDeadly()
	{
		ProcessDeadlyLog processDeadly=new ProcessDeadlyLog();
		DeadlyErrorLog deadlyError=new DeadlyErrorLog(); 
		PoolHde poolHde=new PoolHde(processDeadly,null);
		this.addHdeKey(deadlyError.getContentType(), poolHde); 
	}
	
	/**获取实例
	 * @author   fjy
	 * @version 2014年8月20日 上午12:39:35 
	 * @return
	 */
	public static ProcessorPool getIns()
	{
		if(inspoolPool==null)
		{
			inspoolPool=new ProcessorPool();
		}
		return inspoolPool;
	}
	
	/**
	 * @author   fjy
	 * @version 2014年8月20日 上午12:09:44 
	 * @param newHde
	 */
	public void addHdeKey(Class contentType,  PoolHde newHde){ 
		if(!this.hdelist.containsKey(contentType))
		{
			ArrayList<PoolHde> newList=new ArrayList<PoolHde> ();
			newList.add(newHde);
			this.hdelist.put(contentType, newList);
		}
		else {
			if(!this.hdelist.get(contentType).contains(newHde))
			{
				this.hdelist.get(contentType).add(newHde); 
			}
		}
		
	}
	
	 
	/**根据消息内容的类型创建相应的处理器
	 * @author   fjy
	 * @version 2014年8月20日 上午12:24:45 
	 * @param contentType
	 * @return
	 */
//	public List<IProcessor> getProcessors(Class contentType){
//		
//		List<IProcessor> result=new ArrayList<IProcessor>();
//		if(this.hdelist.containsKey(contentType))
//		{
//			for(PoolHde ph : this.hdelist.get(contentType))
//			{
//				Class[] cs=new Class[this.hdelist.get(contentType).size()];
//				Object[] values=new Object[this.hdelist.get(contentType).size()];
//				int index=0;
//				for(Object ov :ph.getAgrs())
//				{
//					cs[index]=ov.getClass();
//					values[index]=ov;
//					index++;
//				}
//				IProcessor newprc=(IProcessor)cDrive.ProxyInstance(ph.getNewProcessorType(), cs, values);
//				result.add(newprc);
//			}
//		}
//		return result;
//		
//	}
	
	/**
	 * @author   fjy
	 * @version 2014年8月23日 上午10:37:52 
	 * @param contentType
	 * @return
	 */
	public List<PoolHde> getProcessors(Class contentType){
	
		List<PoolHde> result=new ArrayList<PoolHde>();
		if(this.hdelist.containsKey(contentType))
		{
			for(PoolHde ph : this.hdelist.get(contentType))
			{
				result.add(ph);
			}
		}
		return result;
	}
}
