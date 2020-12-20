package com.my.common.db;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Camel Case 표기법 변환 처리를 포함하는 Map 확장 클래스
 * <p>
 * <b>NOTE</b>: commons Collections 의 ListOrderedMap 을 extends 하고 있으며
 * Map 의 key를 입력 시 Camel Case 표기법으로 변경하여 처리하는 Map 의 구현체이다. 
 * (iBatis 의 경우 egovMap 으로 결과 조회시 별도의 alias 없이 DB 칼럼명 그대로 조회하는 것 만으로도 
 * 일반적인 VO 의 attribute (camel case) 에 대한 resultMap 과 같은 효과를 낼 수 있도록 추가하였음)
 * </p>
 *
 * @author 실행환경 개발팀 우병훈
 * @since 2009.02.06
 * @version 1.0
 * @see
 *
 * <pre>
 * == 개정이력(Modification Information) ==
 *
 * 수정일      수정자           수정내용
 * -------    --------    ---------------------------
 * 2009.02.06  우병훈          최초 생성
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
     * key ?? ?????? Camel Case 蹂??????? super.put (ListOrderedMap) ?? ?몄?????.
     *
     * @param key - '_' 媛? ?ы?⑤?? 蹂???紐?
     * @param value - 紐????? key ?? ???? 媛? (蹂?寃? ????)
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
