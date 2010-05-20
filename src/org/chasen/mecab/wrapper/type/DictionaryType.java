package org.chasen.mecab.wrapper.type;

import org.chasen.mecab.mecab;

public enum DictionaryType implements Type<DictionaryType> {

    USR_DIC(mecab.MECAB_USR_DIC),
    SYS_DIC(mecab.MECAB_SYS_DIC),
    UNK_DIC(mecab.MECAB_UNK_DIC),
    ;
    
    private static final Map<DictionaryType> map = new Map<DictionaryType>(DictionaryType.class);
    private final int value;
    private DictionaryType(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
    
    public static DictionaryType get(int value){
        return map.get(value);
    }
}
