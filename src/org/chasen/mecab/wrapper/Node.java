package org.chasen.mecab.wrapper;

import org.chasen.mecab.mecab.mecab_node_t;
import org.chasen.mecab.wrapper.type.NodeType;

public class Node {
    
    protected final mecab_node_t node;
    
    protected Node(mecab_node_t node){
        this.node = node;
    }
    
    public Node getPrev(){
        if(null == node.prev){
            return null;
        }
        return new Node(node.prev);
    }
    
    public Node getNext(){
        if(null == node.next){
            return null;
        }
        return new Node(node.next);
    }
    
    public Node getENext(){
        if(null == node.enext){
            return null;
        }
        return new Node(node.enext);
    }
    
    public Node getBNext(){
        if(null == node.bnext){
            return null;
        }
        return new Node(node.bnext);
    }
    
    public Path getRpath(){
        if(null == node.rpath){
            return null;
        }
        return new Path(node.rpath);
    }
    
    public Path getLPath(){
        if(null == node.lpath){
            return null;
        }
        return new Path(node.lpath);
    }
    
    public String getSurface(){
        return node.surface;
    }
    
    public String getFeature(){
        return node.feature;
    }
    
    public int getId(){
        return node.id;
    }
    
    public short getLength(){
        return node.length;
    }

    public short getRLength() {
        return node.rlength;
    }
    
    public short getRcAttr() {
        return node.rcAttr;
    }

    public short getLcAttr() {
        return node.lcAttr;
    }

    public short getPosid() {
        return node.posid;
    }

    public byte getCharType() {
        return node.char_type;
    }

    public NodeType getStat() {
        return NodeType.get(node.stat);
    }

    public short getIsBest() {
        return node.isbest;
    }

    public int getSentenceLength() {
        return node.sentence_length;
    }

    public float getAlpha() {
        return node.alpha;
    }

    public float getBeta() {
        return node.beta;
    }

    public float getProb() {
        return node.prob;
    }

    public short getWCost() {
        return node.wcost;
    }

    public long getCost() {
        return node.cost;
    }

}
