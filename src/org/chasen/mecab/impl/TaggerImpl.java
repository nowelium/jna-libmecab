package org.chasen.mecab.impl;

import org.chasen.mecab.LibMecab;

import com.sun.jna.Native;

public class TaggerImpl {
    
    protected LibMecab mecab = (LibMecab) Native.loadLibrary("mecab", LibMecab.class);
    
    public static void main(String...args){
        TaggerImpl tagger = new TaggerImpl();
        System.out.println(tagger.mecab.mecab_new2("".toCharArray()));
    }

}
