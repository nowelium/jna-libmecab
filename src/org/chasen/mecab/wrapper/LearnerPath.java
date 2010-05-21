package org.chasen.mecab.wrapper;

import org.chasen.mecab.mecab.mecab_learner_node_t;
import org.chasen.mecab.mecab.mecab_learner_path_t;

public class LearnerPath {
    
    protected final mecab_learner_path_t path;
    
    protected LearnerPath(mecab_learner_path_t path){
        this.path = path;
    }
    
    public LearnerNode getRNode() {
        mecab_learner_node_t.ByReference rnode = path.rnode();
        if(null == rnode){
            return null;
        }
        return new LearnerNode(rnode);
    }

    public LearnerPath getRNext() {
        mecab_learner_path_t.ByReference rnext = path.rnext();
        if(null == rnext){
            return null;
        }
        return new LearnerPath(rnext);
    }

    public LearnerNode getLNode() {
        mecab_learner_node_t.ByReference lnode = path.lnode();
        if(null == lnode){
            return null;
        }
        return new LearnerNode(lnode);
    }

    public LearnerPath getLNext() {
        mecab_learner_path_t.ByReference lnext = path.lnext();
        if(null == lnext){
            return null;
        }
        return new LearnerPath(lnext);
    }

    public double getCost() {
        return path.cost();
    }
    
    public int getFVector() {
        return path.fvector().getValue();
    }

}
