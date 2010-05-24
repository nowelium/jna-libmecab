package org.chasen.mecab;

import org.chasen.mecab.wrapper.MecabNode;
import org.chasen.mecab.wrapper.Node;
import org.chasen.mecab.wrapper.NodeIterator;
import org.chasen.mecab.wrapper.Path;
import org.chasen.mecab.wrapper.Tagger;

public class Iteration {
    
    static {
        System.setProperty("jna.encoding", "UTF-8");
    }
    
    public static void main(String...args){
        Tagger tagger = Tagger.create("-r /opt/local/etc/mecabrc");
        
        // default NodeIterator
        NodeIterator<Node, Path> it = tagger.iterator("庭には二羽ニワトリがいる。");
        while(it.hasNext()){
            MecabNode<Node, Path> node = it.next();
            System.out.println(node.getSurface() + ":" + node.getFeature());
        }
        
        System.out.println("---------------");
        
        // iteratable NodeIterator
        for(MecabNode<Node, Path> node: tagger.iterator("すもももももももものうち")){
            System.out.println(node.getSurface() + ":" + node.getFeature());
        }
    }

}
