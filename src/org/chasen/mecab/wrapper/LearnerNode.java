package org.chasen.mecab.wrapper;

import org.chasen.mecab.mecab.mecab_learner_node_t;
import org.chasen.mecab.mecab.mecab_learner_path_t;
import org.chasen.mecab.wrapper.type.NodeType;

/**
 * @author nowel
 */
public class LearnerNode implements MecabNode<LearnerNode, LearnerPath> {
    
    protected final mecab_learner_node_t node;
    
    protected LearnerNode(mecab_learner_node_t node){
        this.node = node;
    }
    
    protected mecab_learner_node_t.ByReference prev = null;
    public LearnerNode getPrev(){
        if(null == prev){
            prev = node.prev();
        }
        
        if(null == prev){
            return null;
        }
        return new LearnerNode(prev);
    }
    
    protected mecab_learner_node_t.ByReference next = null;
    public LearnerNode getNext(){
        if(null == next){
            next = node.next();
        }
        
        if(null == next){
            return null;
        }
        return new LearnerNode(next);
    }
    
    protected mecab_learner_node_t.ByReference enext = null;
    public LearnerNode getENext(){
        if(null == enext){
            enext = node.enext();
        }
        
        if(null == enext){
            return null;
        }
        return new LearnerNode(enext);
    }
    
    protected mecab_learner_node_t.ByReference bnext = null;
    public LearnerNode getBNext(){
        if(null == bnext){
            bnext = node.bnext();
        }
        
        if(null == bnext){
            return null;
        }
        return new LearnerNode(bnext);
    }
    
    protected mecab_learner_path_t.ByReference rpath = null;
    public LearnerPath getRPath(){
        if(null == rpath){
            rpath = node.rpath();
        }
        
        if(null == rpath){
            return null;
        }
        return new LearnerPath(rpath);
    }
    
    protected mecab_learner_path_t.ByReference lpath = null;
    public LearnerPath getLPath(){
        if(null == lpath){
            lpath = node.lpath();
        }
        
        if(null == lpath){
            return null;
        }
        return new LearnerPath(lpath);
    }
    
    protected String surface = null;
    public String getSurface(){
        if(null == surface){
            surface = node.surface();
        }
        
        short length = getLength();
        byte[] surfaceBytes = surface.getBytes();
        
        byte[] result = new byte[length];
        System.arraycopy(surfaceBytes, 0, result, 0, length);
        return new String(result);
    }
    
    protected String feature = null;
    public String getFeature(){
        if(null != feature){
            return feature;
        }
        return feature = node.feature();
    }
    
    protected int id = -1;
    public int getId(){
        if(-1 != id){
            return id;
        }
        return id = node.id();
    }
    
    protected short length = -1;
    public short getLength(){
        if(-1 != length){
            return length;
        }
        return length = node.length();
    }

    protected short rlength = -1;
    public short getRLength() {
        if(-1 != rlength){
            return rlength;
        }
        return rlength = node.rlength();
    }
    
    protected short rcAttr = -1;
    public short getRcAttr() {
        if(-1 != rcAttr){
            return rcAttr;
        }
        return rcAttr = node.rcAttr();
    }

    protected short lcAttr = -1;
    public short getLcAttr() {
        if(-1 != lcAttr){
            return lcAttr;
        }
        return lcAttr = node.lcAttr();
    }

    protected short posid = -1;
    public short getPosid() {
        if(-1 != posid){
            return posid;
        }
        return posid = node.posid();
    }

    protected byte char_type = -1;
    public byte getCharType() {
        if(-1 != char_type){
            return char_type;
        }
        return char_type = node.char_type();
    }

    protected NodeType stat = null;
    public NodeType getStat() {
        if(null != stat){
            return stat;
        }
        return stat = NodeType.get(node.stat());
    }

    protected short isbest = -1;
    public short getIsBest() {
        if(-1 != isbest){
            return isbest;
        }
        return isbest = node.isbest();
    }

    protected double alpha = -1;
    public double getAlpha() {
        if(-1 != alpha){
            return alpha;
        }
        return alpha = node.alpha();
    }

    protected double beta = -1;
    public double getBeta() {
        if(-1 != beta){
            return beta;
        }
        return beta = node.beta();
    }
    
    protected double wcost = -1;
    public double getWCost() {
        if(-1 != wcost){
            return wcost;
        }
        return wcost = node.wcost();
    }

    protected short wcost2 = -1;
    public short getWCost2() {
        if(-1 != wcost2){
            return wcost2;
        }
        return wcost2 = node.wcost2();
    }

    protected double cost = -1;
    public double getCost() {
        if(-1 != cost){
            return cost;
        }
        return cost = node.cost();
    }
    
    protected int fvector = -1;
    public int getFVector() {
        if(-1 != fvector){
            return fvector;
        }
        return fvector = node.fvector().getValue();
    }

}
