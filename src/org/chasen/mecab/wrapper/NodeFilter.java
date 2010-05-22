package org.chasen.mecab.wrapper;

public interface NodeFilter<N, P> {
    
    public boolean accept(MecabNode<N, P> node);

}
