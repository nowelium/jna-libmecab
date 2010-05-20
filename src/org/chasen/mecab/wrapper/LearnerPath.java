package org.chasen.mecab.wrapper;

import org.chasen.mecab.mecab.mecab_learner_path_t;

public class LearnerPath {
    
    protected final mecab_learner_path_t path;
    
    protected LearnerPath(mecab_learner_path_t path){
        this.path = path;
    }
    
    public LearnerNode getRNode() {
        if(null == path.rnode){
            return null;
        }
        return new LearnerNode(path.rnode);
    }

    public LearnerPath getRNext() {
        if(null == path.rnext){
            return null;
        }
        return new LearnerPath(path.rnext);
    }

    public LearnerNode getLNode() {
        if(null == path.lnode){
            return null;
        }
        return new LearnerNode(path.lnode);
    }

    public LearnerPath getLNext() {
        if(null == path.lnext){
            return null;
        }
        return new LearnerPath(path.lnext);
    }

    public double getCost() {
        return path.cost;
    }
    
    public int getFVector() {
        return path.fvector.getValue();
    }

}
