package org.chasen.mecab.wrapper;

import static org.chasen.mecab.wrapper.function.Mecab.mecab_new;
import static org.chasen.mecab.wrapper.function.Mecab.mecab_destroy;
import static org.chasen.mecab.wrapper.function.Mecab.mecab_sparse_tonode;
import static org.chasen.mecab.wrapper.function.Mecab.mecab_sparse_tostr;
import static org.chasen.mecab.wrapper.function.Mecab.mecab_nbest_sparse_tostr;
import static org.chasen.mecab.wrapper.function.Mecab.mecab_nbest_init;
import static org.chasen.mecab.wrapper.function.Mecab.mecab_version;
import static org.chasen.mecab.wrapper.function.Mecab.mecab_format_node;
import static org.chasen.mecab.wrapper.function.Mecab.mecab_dictionary_info;

import org.chasen.mecab.mecab.mecab_dictionary_info_t;
import org.chasen.mecab.mecab.mecab_node_t;
import org.chasen.mecab.mecab.mecab_t;

public class Tagger {
    
    protected final mecab_t mecab;
    
    protected Tagger(mecab_t mecab){
        this.mecab = mecab;
    }
    
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        mecab_destroy(mecab);
    }
    
    public String parse(String str){
        return mecab_sparse_tostr(mecab, str);
    }
    
    public String parse(String str, long size){
        return mecab_sparse_tostr(mecab, str, size);
    }
    
    public String parseNbest(long N, String str){
        return mecab_nbest_sparse_tostr(mecab, N, str);
    }
    
    public String parseNbest(long N, String str, long size){
        return mecab_nbest_sparse_tostr(mecab, N, str, size);
    }
    
    public int parseNBestInit(String str){
        return mecab_nbest_init(mecab, str);
    }
    
    public int parseNBestInit(String str, long size){
        return mecab_nbest_init(mecab, str, size);
    }

    public String format(Node node){
        return mecab_format_node(mecab, node.node);
    }
    
    public Node parseToNode(String str){
        mecab_node_t node_t = mecab_sparse_tonode(mecab, str);
        return create(node_t);
    }
    
    public Node parseToNode(String str, long size){
        mecab_node_t node_t = mecab_sparse_tonode(mecab, str, size);
        return create(node_t);
    }
    
    public NodeIterator<Node, Path> iterator(String str){
        return create(parseToNode(str));
    }
    
    public NodeIterator<Node, Path> iterator(String str, long size){
        return create(parseToNode(str, size));
    }
    
    public NodeIterator<Node, Path> iterator(String str, NodeFilter<Node, Path> filter){
        return create(parseToNode(str), filter);
    }
    
    public NodeIterator<Node, Path> iterator(String str, long size, NodeFilter<Node, Path> filter){
        return create(parseToNode(str, size), filter);
    }
    
    protected Node create(mecab_node_t node_t){
        return new Node(node_t);
    }
    
    protected NodeIterator<Node, Path> create(Node node){
        return new NodeIterator<Node, Path>(node);
    }

    protected NodeIterator<Node, Path> create(Node node, NodeFilter<Node, Path> filter){
        return new NodeIterator<Node, Path>(node, filter);
    }
    
    public DictionaryInfo getDictionaryInfo(){
        mecab_dictionary_info_t dict = mecab_dictionary_info(mecab);
        return new DictionaryInfo(dict);
    }
    
    public static Tagger create(){
        return new Tagger(mecab_new());
    }
    
    public static Tagger create(String arg){
        return new Tagger(mecab_new(arg));
    }
    
    public static Tagger create(String...args){
        return new Tagger(mecab_new(args));
    }
    
    public static String version(){
        return mecab_version();
    }

}
