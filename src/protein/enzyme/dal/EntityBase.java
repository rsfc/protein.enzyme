package protein.enzyme.dal;

import java.lang.reflect.Field; 

/**
 * @author fjy 
 * @version 2014年8月18日 下午11:16:37 
 */
public abstract class EntityBase implements IEntityBase {

//	@Override
//	public Field getField(String FieldName) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public List<Field> getFields() {
//		 List<Field> result = new ArrayList<Field>();
//         Class t = this.getClass();
//         for (Field f : t.getFields())
//         { 
//              result.add(f); 
//         }
//         return result;
//	}

//	@Override
//	public List<String> getStrFields() {
//		 List<String> list = new ArrayList<String>();
//         for(Field f : getFields())
//         {
//             list.add(f.getName());
//         }
//         return list; 
//	}
 
	public abstract Field primaryKey() ;

}
