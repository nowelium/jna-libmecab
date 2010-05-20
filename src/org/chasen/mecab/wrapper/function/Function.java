package org.chasen.mecab.wrapper.function;

import org.chasen.mecab.LibMecab;
import org.chasen.mecab.mecab;

abstract class Function {
    
    public static mecab getMecab(){
        return LibMecab.mecab;
    }

}
