package org.chasen.mecab.wrapper;

import org.chasen.mecab.wrapper.type.NodeType;

public interface MecabNode<N, P> {
    
    public MecabNode<N, P> getPrev();
    
    public MecabNode<N, P> getNext();
    
    public MecabNode<N, P> getENext();
    
    public MecabNode<N, P> getBNext();
    
    public MecabPath<N, P> getRPath();
    
    public MecabPath<N, P> getLPath();
    
    public String getSurface();
    
    public String getFeature();
    
    public int getId();
    
    public short getLength();
    
    public short getRLength();
    
    public short getRcAttr();
    
    public short getLcAttr();
    
    public short getPosid();
    
    public byte getCharType();
    
    public NodeType getStat();
    
    public short getIsBest();

}
