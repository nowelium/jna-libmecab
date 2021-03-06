package org.chasen.mecab.wrapper;

/**
 * @author nowel
 */
public interface MecabPath<N, P> {
    
    public N getRNode();
    
    public P getRNext();
    
    public N getLNode();
    
    public P getLNext();

}
