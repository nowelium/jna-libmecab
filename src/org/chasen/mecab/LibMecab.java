package org.chasen.mecab;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

/**
 * @author nowel
 */
public class LibMecab {
    
    public static interface IF extends mecab, Library {
        //
    }
    
    public static final String JNA_LIBRARY_NAME = "mecab";
    
    public static final NativeLibrary JNA_NATIVE_LIB = NativeLibrary.getInstance(JNA_LIBRARY_NAME);
    
    public static final mecab mecab;
    
    static {
        IF _mecab = (IF) Native.loadLibrary(JNA_LIBRARY_NAME, IF.class);
        mecab = (org.chasen.mecab.mecab) Native.synchronizedLibrary(_mecab);
    }
    
    /*
    private static final ThreadLocal<org.chasen.mecab.mecab> mecabLocal = new ThreadLocal<org.chasen.mecab.mecab>(){
        @Override
        protected org.chasen.mecab.mecab initialValue() {
            //return (org.chasen.mecab.mecab) Native.loadLibrary(JNA_LIBRARY_NAME, IF.class);
            
            final IF pool = (IF) Native.loadLibrary(JNA_LIBRARY_NAME, IF.class);
            return (org.chasen.mecab.mecab) Native.synchronizedLibrary(pool);
        }
    };
    */
    
    protected LibMecab() {
        // nop
    }
    
    public static mecab getMecab(){
        return mecab;
    }
    
}
