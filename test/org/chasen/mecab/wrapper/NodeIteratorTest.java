package org.chasen.mecab.wrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

public class NodeIteratorTest {
    
    @Test
    public void threads() throws InterruptedException {
        List<Thread> threads = new ArrayList<Thread>();
        threads.add(new Thread(){
            public void run(){
                Tagger t = Tagger.create("-r /opt/local/etc/mecabrc");
                for(MecabNode<Node, Path> node: t.iterator("本日は晴天なり")){
                    System.out.println(node.getSurface());
                }
            }
        });
        threads.add(new Thread(){
            public void run(){
                Tagger t = Tagger.create("-r /opt/local/etc/mecabrc");
                for(MecabNode<Node, Path> node: t.iterator("本日は雨です")){
                    System.out.println(node.getSurface());
                }
            }
        });
        threads.add(new Thread(){
            public void run(){
                Tagger t = Tagger.create("-r /opt/local/etc/mecabrc");
                for(MecabNode<Node, Path> node: t.iterator("昨日は曇りでした")){
                    System.out.println(node.getSurface());
                }
            }
        });
        for(Thread th: threads){
            th.start();
        }
        for(Thread th: threads){
            th.join();
        }
    }
    
    @Test
    public void executors() throws InterruptedException, ExecutionException {
        class Hoge {
            public void parse(String str){
                Tagger t = Tagger.create("-r /opt/local/etc/mecabrc");
                for(MecabNode<Node, Path> node: t.iterator(str)){
                    System.out.println(node.getSurface());
                }
            }
        }
        final Hoge hoge = new Hoge();
        ExecutorService executors = Executors.newCachedThreadPool();
        
        List<Future<?>> futures = new ArrayList<Future<?>>();
        futures.add(executors.submit(new Callable<Void>(){
            public Void call() throws Exception {
                hoge.parse("本日は晴天なり");
                return null;
            }
        }));
        futures.add(executors.submit(new Callable<Void>(){
            public Void call() throws Exception {
                hoge.parse("本日は雨です");
                return null;
            }
        }));
        futures.add(executors.submit(new Callable<Void>(){
            public Void call() throws Exception {
                hoge.parse("昨日は曇りでした");
                return null;
            }
        }));
        for(Future<?> f: futures){
            f.get();
        }
    }
    
    @Test
    public void executors_runnable() throws InterruptedException, ExecutionException {
        class Hoge implements Runnable {
            String str;
            Hoge(String str){
                this.str = str;
            }
            public void run(){
                Tagger t = Tagger.create("-r /opt/local/etc/mecabrc");
                for(MecabNode<Node, Path> node: t.iterator(str)){
                    System.out.println(node.getSurface());
                }
            }
        }
        ExecutorService executors = Executors.newCachedThreadPool();
        
        List<Future<?>> futures = new ArrayList<Future<?>>();
        futures.add(executors.submit(new Hoge("本日は晴天なり")));
        futures.add(executors.submit(new Hoge("本日は雨です")));
        futures.add(executors.submit(new Hoge("昨日は曇りでした")));
        for(Future<?> f: futures){
            f.get();
        }
    }

}
