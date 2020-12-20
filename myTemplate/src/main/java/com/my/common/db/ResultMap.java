package com.my.common.db;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Camel Case ǥ��� ��ȯ ó���� �����ϴ� Map Ȯ�� Ŭ����
 * <p>
 * <b>NOTE</b>: commons Collections �� ListOrderedMap �� extends �ϰ� ������
 * Map �� key�� �Է� �� Camel Case ǥ������� �����Ͽ� ó���ϴ� Map �� ����ü�̴�. 
 * (iBatis �� ��� egovMap ���� ��� ��ȸ�� ������ alias ���� DB Į���� �״�� ��ȸ�ϴ� �� �����ε� 
 * �Ϲ����� VO �� attribute (camel case) �� ���� resultMap �� ���� ȿ���� �� �� �ֵ��� �߰��Ͽ���)
 * </p>
 *
 * @author ����ȯ�� ������ �캴��
 * @since 2009.02.06
 * @version 1.0
 * @see
 *
 * <pre>
 * == �����̷�(Modification Information) ==
 *
 * ������      ������           ��������
 * -------    --------    ---------------------------
 * 2009.02.06  �캴��          ���� ����
 * </pre>
 */
@SuppressWarnings("rawtypes")
public class ResultMap extends LinkedHashMap {

    private static final long serialVersionUID = 6723434363565852261L;

    public Object get(Object key) {
        if (super.get(key) == null) {
            return "";
        } else {
            return super.get(key);
        }
    }

    /**
     * key ?? ?????? Camel Case �??????? super.put (ListOrderedMap) ?? ?��?????.
     *
     * @param key - '_' �? ?��?��?? �???�?
     * @param value - �????? key ?? ???? �? (�?�? ????)
     * @return previous value associated with specified key, or null if there was no  mapping for key
     */
    @SuppressWarnings("unchecked")
    public Object put(Object key, Object value) {
        return super.put(CamelUtil.convert2CamelCase((String) key), value);
    }

    public static boolean isEmpty(Object o) throws IllegalArgumentException {
        if(o == null) return true;

        if(o instanceof String) {
            if(((String)o).length() == 0){
                return true;
        }

        } else if(o instanceof Collection) {
            if(((Collection)o).isEmpty()){
                return true;
            }
        } else if(o.getClass().isArray()) {
            if(Array.getLength(o) == 0){
                return true;
            }
        } else if(o instanceof Map) {
            if(((Map)o).isEmpty()){
                return true;
            }
        }else {
            return false;
        }

        return false;
    }

    /**
    * test for Map,Collection,String,Array isNotEmpty
    * @param c
    * @return
    */ 
    public static boolean isNotEmpty(Object o) {
        return !isEmpty(o);
    }
}
