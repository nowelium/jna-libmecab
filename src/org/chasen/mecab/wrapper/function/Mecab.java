package org.chasen.mecab.wrapper.function;

import org.chasen.mecab.mecab.mecab_dictionary_info_t;
import org.chasen.mecab.mecab.mecab_node_t;
import org.chasen.mecab.mecab.mecab_t;
import org.chasen.mecab.mecab.size_t;

public class Mecab extends Function {

    public static int mecab_do(String...args){
        return getMecab().mecab_do(args.length, args);
    }
    
    public static mecab_t mecab_new(String...args){
        return getMecab().mecab_new(args.length, args);
    }
    
    public static mecab_t mecab_new2(String arg){
        return getMecab().mecab_new2(arg);
    }
    
    public static String mecab_version(){
        return getMecab().mecab_version();
    }
    
    public static String mecab_strerror(mecab_t mecab){
        return getMecab().mecab_strerror(mecab);
    }
    
    public static void mecab_destroy(mecab_t mecab){
        getMecab().mecab_destroy(mecab);
    }
    
    public static String mecab_sparse_tostr(mecab_t mecab, String str){
        return getMecab().mecab_sparse_tostr(mecab, str);
    }
    
    public static String mecab_sparse_tostr2(mecab_t mecab, String str, long len){
        return getMecab().mecab_sparse_tostr2(mecab, str, new size_t(len));
    }
    
    public static String mecab_sparse_tostr3(mecab_t mecab, String str, long len, String ostr, long olen){
        return getMecab().mecab_sparse_tostr3(mecab, str, new size_t(len), ostr, new size_t(olen));
    }
    
    public static mecab_node_t mecab_sparse_tonode(mecab_t mecab, String str){
        return getMecab().mecab_sparse_tonode(mecab, str);
    }
    
    public static mecab_node_t mecab_sparse_tonode2(mecab_t mecab, String str, long length){
        return getMecab().mecab_sparse_tonode2(mecab, str, new size_t(length));
    }
    
    public static String mecab_nbest_sparse_tostr(mecab_t mecab, long N, String str){
        return getMecab().mecab_nbest_sparse_tostr(mecab, new size_t(N), str);
    }
    
    public static String mecab_nbest_sparse_tostr2(mecab_t mecab, long N, String str, long len){
        return getMecab().mecab_nbest_sparse_tostr2(mecab, new size_t(N), str, new size_t(len));
    }
    
    public static String mecab_nbest_sparse_tostr3(mecab_t mecab, long N, String str, long len, String ostr, long olen){
        return getMecab().mecab_nbest_sparse_tostr3(mecab, new size_t(N), str, new size_t(len), ostr, new size_t(olen));
    }
    
    public static int mecab_nbest_init(mecab_t mecab, String str){
        return getMecab().mecab_nbest_init(mecab, str);
    }
    
    public static int mecab_nbest_init2(mecab_t mecab, String str, long len){
        return getMecab().mecab_nbest_init2(mecab, str, new size_t(len));
    }
    
    public static String mecab_nbest_next_tostr(mecab_t mecab){
        return getMecab().mecab_nbest_next_tostr(mecab);
    }
    
    public static String mecab_nbest_next_tostr2(mecab_t mecab, String ostr, long olen){
        return getMecab().mecab_nbest_next_tostr2(mecab, ostr, new size_t(olen));
    }
    
    public static mecab_node_t mecab_nbest_next_tonode(mecab_t mecab){
        return getMecab().mecab_nbest_next_tonode(mecab);
    }
    
    public static String mecab_format_node(mecab_t mecab, mecab_node_t node){
        return getMecab().mecab_format_node(mecab, node);
    }
    
    public static mecab_dictionary_info_t mecab_dictionary_info(mecab_t mecab){
        return getMecab().mecab_dictionary_info(mecab);
    }
    
    public static int mecab_dict_index(String...args){
        return getMecab().mecab_dict_index(args.length, args);
    }
    
    public static int mecab_dict_gen(String...args){
        return getMecab().mecab_dict_gen(args.length, args);
    }
    
    public static int mecab_cost_train(String...args){
        return getMecab().mecab_cost_train(args.length, args);
    }
    
    public static int mecab_system_eval(String...args){
        return getMecab().mecab_system_eval(args.length, args);
    }
    
    public static int mecab_test_gen(String...args){
        return getMecab().mecab_test_gen(args.length, args);
    }
}
