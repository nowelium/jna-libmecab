package org.chasen.mecab.wrapper;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

import org.chasen.mecab.mecab.mecab_node_t;
import org.chasen.mecab.mecab.mecab_path_t;
import org.chasen.mecab.wrapper.type.NodeType;

/**
 * @author nowel
 */
public class Node implements MecabNode<Node, Path> {
    
    protected final mecab_node_t node;
    
    protected Node(mecab_node_t node){
        this.node = node;
    }
    
    protected mecab_node_t.ByReference prev = null;
    public Node getPrev(){
        if(null == prev){
            prev = node.prev();
        }
        
        if(null == prev){
            return null;
        }
        return new Node(prev);
    }
    
    protected mecab_node_t.ByReference next = null;
    public Node getNext(){
        if(null == next){
            next = node.next();
        }
        
        if(null == next){
            return null;
        }
        return new Node(next);
    }
    
    protected mecab_node_t.ByReference enext = null;
    public Node getENext(){
        if(null == enext){
            enext = node.enext();
        }
        
        if(null == enext){
            return null;
        }
        return new Node(enext);
    }
    
    protected mecab_node_t.ByReference bnext = null;
    public Node getBNext(){
        if(null == bnext){
            bnext = node.bnext();
        }
        
        if(null == bnext){
            return null;
        }
        return new Node(bnext);
    }
    
    protected mecab_path_t.ByReference rpath = null;
    public Path getRPath(){
        if(null == rpath){
            rpath = node.rpath();
        }
        
        if(null == rpath){
            return null;
        }
        return new Path(rpath);
    }
    
    protected mecab_path_t.ByReference lpath = null;
    public Path getLPath(){
        if(null == lpath){
            lpath = node.lpath();
        }
        
        if(null == lpath){
            return null;
        }
        return new Path(lpath);
    }
    
    protected String surface = null;
    public String getSurface(){
        if(null == surface){
            surface = node.surface();
        }

        final int length = getLength();
        final byte[] bytes = surface.getBytes();
        
        // TODO: this should not be hardcoded to 1024 bytes
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        if(bytes.length < length){
            buffer.position(0);
            buffer.limit(length);
            buffer.put(bytes);
        } else {
            buffer.put(bytes, 0, length);
        }
        
        return Charset.forName("UTF-8").decode(buffer).toString();
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

    protected int sentence_length = -1;
    public int getSentenceLength() {
        if(-1 != sentence_length){
            return sentence_length;
        }
        return sentence_length = node.sentence_length();
    }

    protected float alpha = -1;
    public float getAlpha() {
        if(-1 != alpha){
            return alpha;
        }
        return alpha = node.alpha();
    }

    protected float beta = -1;
    public float getBeta() {
        if(-1 != beta){
            return beta;
        }
        return beta = node.beta();
    }

    protected float prob = -1;
    public float getProb() {
        if(-1 != prob){
            return prob;
        }
        return prob = node.prob();
    }

    protected short wcost = -1;
    public short getWCost() {
        if(-1 != wcost){
            return wcost;
        }
        return wcost = node.wcost();
    }

    protected long cost = -1;
    public long getCost() {
        if(-1 != cost){
            return cost;
        }
        return cost = node.cost();
    }

}
