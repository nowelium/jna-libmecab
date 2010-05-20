package org.chasen.mecab.wrapper;

import org.chasen.mecab.mecab.mecab_path_t;

public class Path {
    
    protected final mecab_path_t path;
    
    protected Path(mecab_path_t path){
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

    public int getCost() {
        return path.cost;
    }

    public float getProb() {
        return path.prob;
    }
    
}
