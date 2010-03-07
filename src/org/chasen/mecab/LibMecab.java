package org.chasen.mecab;

import com.sun.jna.Library;
import com.sun.jna.ptr.PointerByReference;

public interface LibMecab extends Library {

    int mecab_do(int argc, char[] argv);
    
    MecabT mecab_new2(final char[] argv);
    
    class MecabT extends PointerByReference {
    }
}
