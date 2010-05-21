package org.chasen.mecab.wrapper;

import org.chasen.mecab.mecab.mecab_dictionary_info_t;
import org.chasen.mecab.wrapper.type.DictionaryType;

public class DictionaryInfo {
    
    protected final mecab_dictionary_info_t dictionary;
    
    protected DictionaryInfo(mecab_dictionary_info_t dictionary){
        this.dictionary = dictionary;
    }
    
    public String getFileName(){
        return dictionary.filename();
    }
    
    public String getCharset(){
        return dictionary.charset();
    }
    
    public int getSize(){
        return dictionary.size();
    }
    
    public DictionaryType getType(){
        return DictionaryType.get(dictionary.type());
    }
    
    public int getLSize(){
        return dictionary.lsize();
    }
    
    public int getRSize(){
        return dictionary.rsize();
    }
    
    public short getVersion(){
        return dictionary.version();
    }
    
    public DictionaryInfo getNext(){
        mecab_dictionary_info_t.ByReference next = dictionary.next();
        if(null == next){
            return null;
        }
        return new DictionaryInfo(next);
    }
    
}
