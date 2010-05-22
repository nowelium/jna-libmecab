package org.chasen.mecab.wrapper;

import org.chasen.mecab.mecab.mecab_node_t;
import org.chasen.mecab.mecab.mecab_path_t;

/**
 * @author nowel
 */
public class Path implements MecabPath<Node, Path> {
    
    protected final mecab_path_t path;
    
    protected Path(mecab_path_t path){
        this.path = path;
    }
    
    protected mecab_node_t.ByReference rnode = null;
    public Node getRNode() {
        if(null == rnode){
            rnode = path.rnode();
        }
        
        if(null == rnode){
            return null;
        }
        return new Node(rnode);
    }

    protected mecab_path_t.ByReference rnext = null;
    public Path getRNext() {
        if(null == rnext){
            rnext = path.rnext();
        }
        
        if(null == rnext){
            return null;
        }
        return new Path(rnext);
    }

    protected mecab_node_t.ByReference lnode = null;
    public Node getLNode() {
        if(null == lnode){
            lnode = path.lnode();
        }
        
        if(null == lnode){
            return null;
        }
        return new Node(lnode);
    }

    protected mecab_path_t.ByReference lnext = null;
    public Path getLNext() {
        if(null == lnext){
            lnext = path.lnext();
        }
        
        if(null == lnext){
            return null;
        }
        return new Path(lnext);
    }

    protected int cost = -1;
    public int getCost() {
        if(-1 != cost){
            return cost;
        }
        return cost = path.cost();
    }

    protected float prob = -1;
    public float getProb() {
        if(-1 != prob){
            return prob;
        }
        return prob = path.prob();
    }
    
}
