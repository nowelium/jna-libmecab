package org.chasen.mecab.wrapper;

import java.nio.BufferOverflowException;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;


public class NodeTest {
    
    @Test
    public void getSurface_large_string(){
        StringBuilder buf = new StringBuilder();
        for(int i = 0; i < 10240; ++i){
            buf.append("a");
        }
        
        Tagger t = Tagger.create("-r /opt/local/etc/mecabrc");
        try {
            for(MecabNode<Node, Path> node: t.iterator(buf.toString())){
                node.getSurface();
            }
        } catch(BufferOverflowException e){
            e.printStackTrace(System.out);
            Assert.fail(e.getMessage());
        }
    }
    
    @Test
    @Ignore
    public void getSurface_small_string(){
        StringBuilder buf = new StringBuilder();
        for(int i = 0; i < 10240; ++i){
            buf.append("");
        }
        
        Tagger t = Tagger.create("-r /opt/local/etc/mecabrc");
        try {
            for(MecabNode<Node, Path> node: t.iterator(buf.toString())){
                node.getSurface();
            }
        } catch(BufferOverflowException e){
            e.printStackTrace(System.out);
            Assert.fail(e.getMessage());
        }
    }
    
    @Test
    public void getSurface_index_outofbounds(){
        Tagger t = Tagger.create("-r /opt/local/etc/mecabrc");
        try {
            for(MecabNode<Node, Path> node: t.iterator("本日は晴天なり")){
                node.getSurface();
            }
        } catch(IndexOutOfBoundsException e){
            e.printStackTrace(System.out);
            Assert.fail(e.getMessage());
        }
        try {
            for(MecabNode<Node, Path> node: t.iterator("本日は雨です")){
                node.getSurface();
            }
        } catch(IndexOutOfBoundsException e){
            e.printStackTrace(System.out);
            Assert.fail(e.getMessage());
        }
        try {
            for(MecabNode<Node, Path> node: t.iterator("昨日は曇りでした")){
                node.getSurface();
            }
        } catch(IndexOutOfBoundsException e){
            e.printStackTrace(System.out);
            Assert.fail(e.getMessage());
        }
    }

}
