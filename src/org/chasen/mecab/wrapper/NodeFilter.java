package org.chasen.mecab.wrapper;

/**
 * @author nowel
 */
public interface NodeFilter<N, P> {
    
    public boolean accept(MecabNode<N, P> node);

}
