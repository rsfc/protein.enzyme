package protein.enzyme.dal;

/**ʵ���ֶ�
 * @author fjy 
 * @version 2016��2��23�� ����7:22:30 
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
	/**�ֶ�����
	 * @author   fjy
	 * @version 2016��2��23�� ����7:23:53 
	 */
	private String fieldName="";
	/**��ȡ�ֶ�����
	 * @author   fjy
	 * @version 2016��2��23�� ����7:25:01 
	 * @return
	 */
	public String getFieldName() {
		return fieldName;
	}
	/**�����ֶ�����,�ֶ����Զ�ת��ΪСд
	 * @author   fjy
	 * @version 2016��2��23�� ����7:25:08 
	 * @param fieldName
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName.trim().toLowerCase();
	}
	/**��ȡ�ֶ����ͣ��ֶ����Զ�ת��ΪСд
	 * @author   fjy
	 * @version 2016��2��23�� ����7:25:16 
	 * @return
	 */
	public Class getFieldType() {
		return fieldType;
	}
	/**�����ֶ�����
	 * @author   fjy
	 * @version 2016��2��23�� ����7:25:24 
	 * @param fieldType
	 */
	public void setFieldType(Class fieldType) {
		this.fieldType = fieldType;
	}
	/**�ֶ�����
	 * @author   fjy
	 * @version 2016��2��23�� ����7:23:44 
	 */
	private Class fieldType =null;
	
	private Object fieldValue=null;
	/**��ȡ�ֶ�ֵ
	 * @author   fjy
	 * @version 2016��2��23�� ����7:40:51 
	 * @return
	 */
	public Object getFieldValue() {
		return fieldValue;
	}
	/**�����ֶ�ֵ
	 * @author   fjy
	 * @version 2016��2��23�� ����7:40:57 
	 * @param fieldValue
	 */
	public void setFieldValue(Object fieldValue) {
		this.fieldValue = fieldValue;
	}
}
