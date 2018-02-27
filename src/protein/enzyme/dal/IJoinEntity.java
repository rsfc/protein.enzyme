package protein.enzyme.dal;

import java.util.List;

/**联立的实体类包装接口
 * @author fjy
 *
 */
public interface IJoinEntity {
	 
//    /**
//     * 联立的实体类
//     */
//    List<IEntityBase> Entitys=null;
 
	/**获取实体类列表
	 * @author   fjy
	 * @version 2014年8月5日 下午3:55:06 
	 * @return
	 */
	List<IEntityBase> getEntitys();
	
    /**传入要联合的实体 在调用的实体内记录可联合的字段组合,所有外键关系都用方法表示  
     * @param SourceEntity 联立的实体类对象
     * @param JionEntity 联立的实体类对象
     * @return
     */
    String JoinField(IEntityBase SourceEntity, IEntityBase JionEntity);
}
