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
	 * ÀÔ·Â ¹®ÀÚ¿­¿¡ ´ëÇÏ¿© Camel Ç¥±â¹ýÀ¸·Î º¯È¯À» Áö¿øÇÏ´Â Utility Class ÀÌ´Ù.
	 * @author ½ÇÇàÈ¯°æ °³¹ßÆÀ ¿ìº´ÈÆ
	 * @since 2009.02.06
	 * @version 1.0
	 * @see <pre>
	 *  == °³Á¤ÀÌ·Â(Modification Information) ==
	 *   
	 *   ¼öÁ¤ÀÏ      ¼öÁ¤ÀÚ           ¼öÁ¤³»¿ë
	 *  -------    --------    ---------------------------
	 *   2009.02.06  ¿ìº´ÈÆ          ÃÖÃÊ »ý¼º
	 * 
	 * </pre>
	 */
    public static String convert2CamelCase(String underScore) {

        // '_' ê°? ??????ì§? ???¼ë©´ ?´ë?? camel case ë¡? ê°?????.
        // ?? ì²«ì§¸ë¬¸ì??ê°? ??ë¬¸ì???´ë©´ camel case ë³??? (??ì²´ë?? ??ë¬¸ì??ë¡?) ì²?ë¦¬ê?
        // ???????¤ê? ê°?????. --> ???? ë¡?ì§??? ??????ë©? ë°???
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