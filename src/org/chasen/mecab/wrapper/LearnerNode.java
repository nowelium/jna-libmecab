package org.chasen.mecab.wrapper;

import org.chasen.mecab.mecab.mecab_learner_node_t;
import org.chasen.mecab.wrapper.type.NodeType;

public class LearnerNode {
    
    protected final mecab_learner_node_t node;
    
    protected LearnerNode(mecab_learner_node_t node){
        this.node = node;
    }
    
    public LearnerNode getPrev(){
        if(null == node.prev){
            return null;
        }
        return new LearnerNode(node.prev);
    }
    
    public LearnerNode getNext(){
        if(null == node.next){
            return null;
        }
        return new LearnerNode(node.next);
    }
    
    public LearnerNode getENext(){
        if(null == node.enext){
            return null;
        }
        return new LearnerNode(node.enext);
    }
    
    public LearnerNode getBNext(){
        if(null == node.bnext){
            return null;
        }
        return new LearnerNode(node.bnext);
    }
    
    public LearnerPath getRpath(){
        if(null == node.rpath){
            return null;
        }
        return new LearnerPath(node.rpath);
    }
    
    public LearnerPath getLPath(){
        if(null == node.lpath){
            return null;
        }
        return new LearnerPath(node.lpath);
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

    public double getAlpha() {
        return node.alpha;
    }

    public double getBeta() {
        return node.beta;
    }
    
    public double getWCost() {
        return node.wcost;
    }

    public short getWCost2() {
        return node.wcost2;
    }

    public double getCost() {
        return node.cost;
    }
    
    public int getFVector() {
        return node.fvector.getValue();
    }

}
