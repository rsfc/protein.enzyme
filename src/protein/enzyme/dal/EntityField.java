package protein.enzyme.dal;

/**实体字段
 * @author fjy 
 * @version 2016年2月23日 下午7:22:30 
 */
public class EntityField {
	
	
	/**
	 * 
	 */
	public EntityField(String name,Class fType)
	{
		this.setFieldName(name);
		this.setFieldType(fType);
	}
	/**字段名称
	 * @author   fjy
	 * @version 2016年2月23日 下午7:23:53 
	 */
	private String fieldName="";
	/**获取字段名称
	 * @author   fjy
	 * @version 2016年2月23日 下午7:25:01 
	 * @return
	 */
	public String getFieldName() {
		return fieldName;
	}
	/**设置字段名称,字段名自动转换为小写
	 * @author   fjy
	 * @version 2016年2月23日 下午7:25:08 
	 * @param fieldName
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName.trim().toLowerCase();
	}
	/**获取字段类型，字段名自动转换为小写
	 * @author   fjy
	 * @version 2016年2月23日 下午7:25:16 
	 * @return
	 */
	public Class getFieldType() {
		return fieldType;
	}
	/**设置字段类型
	 * @author   fjy
	 * @version 2016年2月23日 下午7:25:24 
	 * @param fieldType
	 */
	public void setFieldType(Class fieldType) {
		this.fieldType = fieldType;
	}
	/**字段类型
	 * @author   fjy
	 * @version 2016年2月23日 下午7:23:44 
	 */
	private Class fieldType =null;
	
	private Object fieldValue=null;
	/**获取字段值
	 * @author   fjy
	 * @version 2016年2月23日 下午7:40:51 
	 * @return
	 */
	public Object getFieldValue() {
		return fieldValue;
	}
	/**设置字段值
	 * @author   fjy
	 * @version 2016年2月23日 下午7:40:57 
	 * @param fieldValue
	 */
	public void setFieldValue(Object fieldValue) {
		this.fieldValue = fieldValue;
	}
}
