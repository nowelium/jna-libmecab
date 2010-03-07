package org.chasen.mecab;

import com.sun.jna.Library;
import com.sun.jna.PointerType;
import com.sun.jna.Structure;

public interface LibMecab extends Library {
    
    final int MECAB_NOR_NODE = 0;
    final int MECAB_UNK_NODE = 1;
    final int MECAB_BOS_NODE = 2;
    final int MECAB_EOS_NODE = 3;
    final int MECAB_EON_NODE = 4;
    
    final int MECAB_USR_DIC = 1;
    final int MECAB_SYS_DIC = 0;
    final int MECAB_UNK_DIC = 2;

    int mecab_do(int argc, String...argv);

    mecab_t mecab_new(int argc, String...argv);
    
    mecab_t mecab_new2(final String arg);
    String mecab_version();
    
    String mecab_strerror(mecab_t mecab);
    void mecab_destroy(mecab_t mecab);

    int mecab_get_partial(mecab_t mecab);
    void mecab_set_partial(mecab_t mecab, int partial);
    float mecab_get_theta(mecab_t mecab);
    void mecab_set_theta(mecab_t mecab, float theta);
    int mecab_get_lattice_level(mecab_t mecab);
    void mecab_set_lattice_level(mecab_t mecab, int level);
    int mecab_get_all_morphs(mecab_t mecab);
    void mecab_set_all_morphs(mecab_t mecab, int all_morphs);

    String mecab_sparse_tostr(mecab_t mecab, final String str);
    String mecab_sparse_tostr2(mecab_t mecab, final String str, int len);
    String mecab_sparse_tostr3(mecab_t mecab, final String str, int len, String ostr, int olen);
    mecab_node_t mecab_sparse_tonode(mecab_t mecab, final String chr);
    mecab_node_t mecab_sparse_tonode2(mecab_t mecab, final String chr, int size);
    String mecab_nbest_sparse_tostr(mecab_t mecab, int N, final String str);
    String mecab_nbest_sparse_tostr2(mecab_t mecab, int N, final String str, int len);
    String mecab_nbest_sparse_tostr3(mecab_t mecab, int N, final String str, int len, String ostr, int olen);
    int mecab_nbest_init(mecab_t mecab, final String str);
    int mecab_nbest_init2(mecab_t mecab, final String str, int len);
    String mecab_nbest_next_tostr(mecab_t mecab);
    String mecab_nbest_next_tostr2(mecab_t mecab, String ostr, int olen);
    mecab_node_t mecab_nbest_next_tonode(mecab_t mecab);
    String mecab_format_node(mecab_t mecab, final mecab_node_t node);
    
    mecab_dictionary_info_t mecab_dictionary_info(mecab_t mecab);
    int mecab_dict_index(int argc, String...argv);
    int mecab_dict_gen(int argc, String...argv);
    int mecab_cost_train(int argc, String...argv);
    int mecab_system_eval(int argc, String...argv);
    int mecab_test_gen(int argc, String...argv);
    
    class mecab_t extends PointerType {
        public static class Type extends Structure {
            public int allocated;
        }
        public Type get(){
            Type type = (Type) Structure.newInstance(Type.class);
            type.writeField("allocated", getPointer().getInt(0));
            return type;
        }
    }
    class mecab_node_t extends PointerType {
    }
    class mecab_dictionary_info_t extends PointerType {
    }
    
    abstract class Tagger extends PointerType {
        abstract String parse(final String str);
        abstract Node parseToNode(final String str);
        abstract String parseNBest(int N, final String str);
        abstract boolean parseNBestInit(final String str);
        abstract Node nextNode();
        abstract String next();
        abstract String formatNode(final Node node);

        // configuration
        abstract boolean partial();
        abstract void set_partial(boolean partial);
        abstract float theta();
        abstract void set_theta(float theta);
        abstract int lattice_level();
        abstract void set_lattice_level(int level);
        abstract boolean all_morphs();
        abstract void set_all_morphs(boolean all_morphs);
        
        abstract DictionaryInfo dictionary_info();
        abstract String what();

        static Tagger create(int argc, String...argv){
            return null;
        }
        static Tagger create(String...argv){
            return null;
        }
    }
    
    class Node extends PointerType {
        
    }
    
    class DictionaryInfo extends PointerType {
        
    }
}
