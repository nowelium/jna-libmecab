package org.chasen.mecab;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

public class LibMecab {
    
    public static interface IF extends mecab, Library {
        //
    }
    
    public static final String JNA_LIBRARY_NAME = "mecab";
    
    public static final NativeLibrary JNA_NATIVE_LIB = NativeLibrary.getInstance(JNA_LIBRARY_NAME);
    
    public static final mecab mecab = (mecab) Native.loadLibrary(JNA_LIBRARY_NAME, IF.class);
    
    public LibMecab() {
        // nop
    }
    
}
