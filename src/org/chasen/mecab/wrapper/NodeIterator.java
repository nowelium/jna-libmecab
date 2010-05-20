package org.chasen.mecab.wrapper;

import java.util.Iterator;

import org.chasen.mecab.wrapper.type.NodeType;

public class NodeIterator implements Iterator<Node>, Iterable<Node> {

    private final NodeFilter filter;
    
    private Node node;
    
    protected static final NodeFilter defaultFilter = new NodeFilter(){
        public boolean accept(Node node) {
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
    };
    
    protected NodeIterator(Node node){
        this(node, defaultFilter);
    }
    
    protected NodeIterator(Node node, NodeFilter filter){
        this.node = node;
        this.filter = filter;
    }
    
    public boolean hasNext() {
        return filter.accept(node.getNext());
    }

    public Node next() {
        return node = node.getNext();
    }

    public void remove() {
        // nop
    }
    
    public Iterator<Node> iterator() {
        return this;
    }
}
