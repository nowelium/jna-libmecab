package org.chasen.mecab.wrapper;

public interface MecabPath<N, P> {
    
    public N getRNode();
    
    public P getRNext();
    
    public N getLNode();
    
    public P getLNext();

}
