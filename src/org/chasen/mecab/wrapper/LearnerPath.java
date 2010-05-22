package org.chasen.mecab.wrapper;

import org.chasen.mecab.mecab.mecab_learner_node_t;
import org.chasen.mecab.mecab.mecab_learner_path_t;

/**
 * @author nowel
 */
public class LearnerPath implements MecabPath<LearnerNode, LearnerPath>{
    
    protected final mecab_learner_path_t path;
    
    protected LearnerPath(mecab_learner_path_t path){
        this.path = path;
    }
    
    protected mecab_learner_node_t.ByReference rnode = null;
    public LearnerNode getRNode() {
        if(null == rnode){
            rnode = path.rnode();
        }
        
        if(null == rnode){
            return null;
        }
        return new LearnerNode(rnode);
    }

    protected mecab_learner_path_t.ByReference rnext = null;
    public LearnerPath getRNext() {
        if(null == rnext){
            rnext = path.rnext();
        }
        
        if(null == rnext){
            return null;
        }
        return new LearnerPath(rnext);
    }

    protected mecab_learner_node_t.ByReference lnode = null;
    public LearnerNode getLNode() {
        if(null == lnode){
            lnode = path.lnode();
        }
        
        if(null == lnode){
            return null;
        }
        return new LearnerNode(lnode);
    }

    protected mecab_learner_path_t.ByReference lnext = null;
    public LearnerPath getLNext() {
        if(null == lnext){
            lnext = path.lnext();
        }
        
        if(null == lnext){
            return null;
        }
        return new LearnerPath(lnext);
    }

    protected double cost = -1;
    public double getCost() {
        if(-1 != cost){
            return cost;
        }
        return cost = path.cost();
    }
    
    protected int fvector = -1;
    public int getFVector() {
        if(-1 != fvector){
            return fvector;
        }
        return fvector = path.fvector().getValue();
    }

}
