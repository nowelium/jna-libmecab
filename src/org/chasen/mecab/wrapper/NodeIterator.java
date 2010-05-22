package org.chasen.mecab.wrapper;

import java.util.Iterator;

import org.chasen.mecab.wrapper.type.NodeType;

/**
 * @author nowel
 */
public class NodeIterator<N, P> implements Iterator<MecabNode<N, P>>, Iterable<MecabNode<N, P>> {

    protected static class defaultFilter<N, P> implements NodeFilter<N, P> {
        public boolean accept(MecabNode<N, P> node) {
            if(null == node){
                return false;
            }
            NodeType stat = node.getStat();
            if(NodeType.BOS_NODE.equals(stat)){
                return false;
            }
            if(NodeType.EOS_NODE.equals(stat)){
                return false;
            }
            return true;
        }
    }
    
    private final NodeFilter<N, P> filter;
    
    private MecabNode<N, P> node;
    
    protected NodeIterator(MecabNode<N, P> node){
        this(node, new defaultFilter<N, P>());
    }
    
    protected NodeIterator(MecabNode<N, P> node, NodeFilter<N, P> filter){
        this.node = node;
        this.filter = filter;
    }
    
    public boolean hasNext() {
        return filter.accept(node.getNext());
    }

    public MecabNode<N, P> next() {
        return node = node.getNext();
    }

    public void remove() {
        // nop
    }
    
    public Iterator<MecabNode<N, P>> iterator() {
        return this;
    }
}
