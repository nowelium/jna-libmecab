package org.chasen.mecab.wrapper;

import org.chasen.mecab.mecab.mecab_dictionary_info_t;
import org.chasen.mecab.wrapper.type.DictionaryType;

public class DictionaryInfo {
    
    protected final mecab_dictionary_info_t dictionary;
    
    protected DictionaryInfo(mecab_dictionary_info_t dictionary){
        this.dictionary = dictionary;
    }
    
    protected String filename = null;
    public String getFileName(){
        if(null != filename){
            return filename;
        }
        return filename = dictionary.filename();
    }
    
    protected String charset = null;
    public String getCharset(){
        if(null != charset){
            return charset;
        }
        return charset = dictionary.charset();
    }
    
    protected int size = -1;
    public int getSize(){
        if(-1 != size){
            return size;
        }
        return size = dictionary.size();
    }
    
    protected DictionaryType type = null;
    public DictionaryType getType(){
        if(null != type){
            return type;
        }
        return type = DictionaryType.get(dictionary.type());
    }
    
    protected int lsize = -1;
    public int getLSize(){
        if(-1 != lsize){
            return lsize;
        }
        return lsize = dictionary.lsize();
    }
    
    protected int rsize = -1;
    public int getRSize(){
        if(-1 != rsize){
            return rsize;
        }
        return rsize = dictionary.rsize();
    }
    
    protected short version = -1;
    public short getVersion(){
        if(-1 != version){
            return version;
        }
        return version = dictionary.version();
    }
    
    protected mecab_dictionary_info_t.ByReference next = null;
    public DictionaryInfo getNext(){
        if(null == next){
            next = dictionary.next();
        }
        
        if(null == next){
            return null;
        }
        return new DictionaryInfo(next);
    }
    
}
