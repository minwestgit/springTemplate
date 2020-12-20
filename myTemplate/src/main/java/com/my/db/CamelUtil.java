/*
 * Copyright 2008-2009 MOPAS(Ministry of Public Administration and Security).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.my.db;

/*
 * Copyright 2008-2009 MOPAS(Ministry of Public Administration and Security).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

public class CamelUtil {

	/**
	 * �Է� ���ڿ��� ���Ͽ� Camel ǥ������� ��ȯ�� �����ϴ� Utility Class �̴�.
	 * @author ����ȯ�� ������ �캴��
	 * @since 2009.02.06
	 * @version 1.0
	 * @see <pre>
	 *  == �����̷�(Modification Information) ==
	 *   
	 *   ������      ������           ��������
	 *  -------    --------    ---------------------------
	 *   2009.02.06  �캴��          ���� ����
	 * 
	 * </pre>
	 */
    public static String convert2CamelCase(String underScore) {

        // '_' �? ??????�? ???�면 ?��?? camel case �? �?????.
        // ?? 첫째문�??�? ??문�???�면 camel case �??? (??체�?? ??문�??�?) �?리�?
        // ???????��? �?????. --> ???? �?�??? ??????�? �???
        if (underScore.indexOf('_') < 0
            && Character.isLowerCase(underScore.charAt(0))) {
            return underScore;
        }
        StringBuilder result = new StringBuilder();
        boolean nextUpper = false;
        int len = underScore.length();

        for (int i = 0; i < len; i++) {
            char currentChar = underScore.charAt(i);
            if (currentChar == '_') {
                nextUpper = true;
            } else {
                if (nextUpper) {
                    result.append(Character.toUpperCase(currentChar));
                    nextUpper = false;
                } else {
                    result.append(Character.toLowerCase(currentChar));
                }
            }
        }
        return result.toString();
    }
}