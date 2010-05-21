package org.chasen.mecab.wrapper;

import org.chasen.mecab.mecab.mecab_learner_node_t;
import org.chasen.mecab.mecab.mecab_learner_path_t;
import org.chasen.mecab.wrapper.type.NodeType;

public class LearnerNode {
    
    protected final mecab_learner_node_t node;
    
    protected LearnerNode(mecab_learner_node_t node){
        this.node = node;
    }
    
    public LearnerNode getPrev(){
        mecab_learner_node_t.ByReference prev = node.prev();
        if(null == prev){
            return null;
        }
        return new LearnerNode(prev);
    }
    
    public LearnerNode getNext(){
        mecab_learner_node_t.ByReference next = node.next();
        if(null == next){
            return null;
        }
        return new LearnerNode(next);
    }
    
    public LearnerNode getENext(){
        mecab_learner_node_t.ByReference enext = node.enext();
        if(null == enext){
            return null;
        }
        return new LearnerNode(enext);
    }
    
    public LearnerNode getBNext(){
        mecab_learner_node_t.ByReference bnext = node.bnext();
        if(null == bnext){
            return null;
        }
        return new LearnerNode(bnext);
    }
    
    public LearnerPath getRpath(){
        mecab_learner_path_t.ByReference rpath = node.rpath();
        if(null == rpath){
            return null;
        }
        return new LearnerPath(rpath);
    }
    
    public LearnerPath getLPath(){
        mecab_learner_path_t.ByReference lpath = node.lpath();
        if(null == lpath){
            return null;
        }
        return new LearnerPath(lpath);
    }
    
    public String getSurface(){
        return node.surface();
    }
    
    public String getFeature(){
        return node.feature();
    }
    
    public int getId(){
        return node.id();
    }
    
    public short getLength(){
        return node.length();
    }

    public short getRLength() {
        return node.rlength();
    }
    
    public short getRcAttr() {
        return node.rcAttr();
    }

    public short getLcAttr() {
        return node.lcAttr();
    }

    public short getPosid() {
        return node.posid();
    }

    public byte getCharType() {
        return node.char_type();
    }

    public NodeType getStat() {
        return NodeType.get(node.stat());
    }

    public short getIsBest() {
        return node.isbest();
    }

    public double getAlpha() {
        return node.alpha();
    }

    public double getBeta() {
        return node.beta();
    }
    
    public double getWCost() {
        return node.wcost();
    }

    public short getWCost2() {
        return node.wcost2();
    }

    public double getCost() {
        return node.cost();
    }
    
    public int getFVector() {
        return node.fvector().getValue();
    }

}
