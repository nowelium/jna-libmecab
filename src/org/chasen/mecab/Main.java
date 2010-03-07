package org.chasen.mecab;

import org.chasen.mecab.LibMecab.mecab_t;

import com.sun.jna.Native;

public class Main {
    public static void main(String...args){
        LibMecab mecab = (LibMecab) Native.loadLibrary("mecab", LibMecab.class);
        System.out.println(mecab.mecab_version());
        
        mecab_t _ = mecab.mecab_new2("");
        System.out.println(mecab.mecab_strerror(_));
        
        // 文字化けだし、動かない...
        String result = mecab.mecab_sparse_tostr(_, "こんにちは！");
        System.out.println(result);
        mecab.mecab_destroy(_);
    }
}
