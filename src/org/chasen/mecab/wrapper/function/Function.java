package org.chasen.mecab.wrapper.function;

import org.chasen.mecab.LibMecab;
import org.chasen.mecab.mecab;

/**
 * @author nowel
 */
abstract class Function {
    
    public static mecab getMecab(){
        return LibMecab.getMecab();
    }

}
