package org.chasen.mecab.wrapper.type;

import org.chasen.mecab.mecab;

public enum NodeType implements Type<NodeType> {

    NOR_NODE(mecab.MECAB_NOR_NODE),
    UNK_NODE(mecab.MECAB_UNK_NODE),
    BOS_NODE(mecab.MECAB_BOS_NODE),
    EOS_NODE(mecab.MECAB_EOS_NODE),
    ;
    
    private static final Map<NodeType> map = new Map<NodeType>(NodeType.class);
    private final int value;
    private NodeType(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
    
    public static NodeType get(int value){
        return map.get(value);
    }

}
