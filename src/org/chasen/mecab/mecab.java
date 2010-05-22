package org.chasen.mecab;

import com.sun.jna.IntegerType;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.Structure;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;

public interface mecab {
    
    public static final int MECAB_NOR_NODE = 0;
    
    public static final int MECAB_UNK_NODE = 1;
    
    public static final int MECAB_BOS_NODE = 2;
    
    public static final int MECAB_EOS_NODE = 3;
    
    public static final int MECAB_USR_DIC = 1;
    
    public static final int MECAB_SYS_DIC = 0;
    
    public static final int MECAB_UNK_DIC = 2;
    
    /**
     * C func: int mecab_do (int argc, char **argv);
     */
    public int mecab_do(int argc, String[] argv);
    
    /**
     * C func: mecab_t* mecab_new(int argc, char **argv);
     */
    public mecab_t mecab_new(int argc, String[] argv);
    
    /**
     * C func: mecab_t* mecab_new2(const char *arg);
     */
    public mecab_t mecab_new2(String arg);
    
    /**
     * C func: const char* mecab_version()
     */
    public String mecab_version();
    
    /**
     * C func: const char* mecab_strerror(mecab_t *mecab)
     */
    public String mecab_strerror(mecab_t mecab);
    
    /**
     * C func: void mecab_destroy(mecab_t *mecab)
     */
    public void mecab_destroy(mecab_t mecab);
    
    /**
     * C func: const char* mecab_sparse_tostr(mecab_t *mecab, const char *str)
     */
    public String mecab_sparse_tostr(mecab_t mecab, String str);
    
    /**
     * C func: const char* mecab_sparse_tostr2(mecab_t *mecab, const char *str, size_t len)
     */
    public String mecab_sparse_tostr2(mecab_t mecab, String str, size_t len);
    
    /**
     * C func: char* mecab_sparse_tostr3(
     *  mecab_t *mecab,
     *  const char *str,
     *  size_t len,
     *  char *ostr,
     *  size_t olen
     * );
     */
    public String mecab_sparse_tostr3(mecab_t mecab, String str, size_t len, String ostr, size_t olen);
    
    /**
     * C func: const mecab_node_t* mecab_sparse_tonode(mecab_t *mecab, const char*)
     */
    public mecab_node_t mecab_sparse_tonode(mecab_t mecab, String str);
    
    /**
     * C func: const mecab_node_t* mecab_sparse_tonode2(mecab_t *mecab, const char*, size_t)
     */
    public mecab_node_t mecab_sparse_tonode2(mecab_t mecab, String str, size_t length);
    
    /**
     * C func: const char* mecab_nbest_sparse_tostr(mecab_t *mecab, size_t N, const char *str)
     */
    public String mecab_nbest_sparse_tostr(mecab_t mecab, size_t N, String str);
    
    /**
     * C func: const char* mecab_nbest_sparse_tostr2(
     *  mecab_t *mecab,
     *  size_t N,
     *  const char *str,
     *  size_t len
     * )
     */
    public String mecab_nbest_sparse_tostr2(mecab_t mecab, size_t N, String str, size_t len);
    
    /**
     * C func: char* mecab_nbest_sparse_tostr3(
     *  mecab_t *mecab,
     *  size_t N,
     *  const char *str,
     *  size_t len,
     *  char *ostr,
     *  size_t olen
     * )
     */
    public String mecab_nbest_sparse_tostr3(mecab_t mecab, size_t N, String str, size_t len, String ostr, size_t olen);
    
    /**
     * C func: int mecab_nbest_init(mecab_t *mecab, const char *str)
     */
    public int mecab_nbest_init(mecab_t mecab, String str);
    
    /**
     * C func: int mecab_nbest_init2(mecab_t *mecab, const char *str, size_t len)
     */
    public int mecab_nbest_init2(mecab_t mecab, String str, size_t len);
    
    /**
     * C func: const char* mecab_nbest_next_tostr(mecab_t *mecab)
     */
    public String mecab_nbest_next_tostr(mecab_t mecab);
    
    /**
     * C func: char* mecab_nbest_next_tostr2(mecab_t *mecab, char *ostr, size_t olen)
     */
    public String mecab_nbest_next_tostr2(mecab_t mecab, String ostr, size_t olen);
    
    /**
     * C func: const mecab_node_t* mecab_nbest_next_tonode(mecab_t *mecab)
     */
    public mecab_node_t mecab_nbest_next_tonode(mecab_t mecab);
    
    /**
     * C func: const char* mecab_format_node(mecab_t *mecab, const mecab_node_t *node)
     */
    public String mecab_format_node(mecab_t mecab, mecab_node_t node);
    
    /**
     * C func: const mecab_dictionary_info_t* mecab_dictionary_info(mecab_t *mecab)
     */
    public mecab_dictionary_info_t mecab_dictionary_info(mecab_t mecab);
    
    /**
     * C func: int mecab_dict_index(int argc, char **argv)
     */
    public int mecab_dict_index(int argc, String[] argv);
    
    /**
     * C func: int mecab_dict_gen(int argc, char **argv)
     */
    public int mecab_dict_gen(int argc, String[] argv);
    
    /**
     * C func: int mecab_cost_train(int argc, char **argv)
     */
    public int mecab_cost_train(int argc, String[] argv);
    
    /**
     * C func: int mecab_system_eval(int argc, char **argv)
     */
    public int mecab_system_eval(int argc, String[] argv);
    
    /**
     * C func: int mecab_test_gen(int argc, char **argv)
     */
    public int mecab_test_gen(int argc, String[] argv);
    
    public static class mecab_t extends PointerType {
        public mecab_t() {
            super();
        }
        public mecab_t(Pointer address) {
            super(address);
        }
    }

    public static class mecab_dictionary_info_t extends Structure {
        // C type: const char*
        public String filename;
        // C type: const char*
        public String charset;
        // C type: unsigned int
        public int size;
        // C type: int
        public int type;
        // C type: unsigned int
        public int lsize;
        // C type: unsigned int
        public int rsize;
        // C type: unsigned short
        public short version;
        // C type: struct mecab_dictionary_info_t
        public mecab_dictionary_info_t.ByReference next;
        
        public mecab_dictionary_info_t(){
            super();
            setAutoSynch(false);
        }
        public String filename(){
            readField("filename");
            return filename;
        }
        public String charset(){
            readField("charset");
            return charset;
        }
        public int size(){
            readField("size");
            return size;
        }
        public int type(){
            readField("type");
            return type;
        }
        public int lsize(){
            readField("lsize");
            return lsize;
        }
        public int rsize(){
            readField("rsize");
            return rsize;
        }
        public short version(){
            readField("version");
            return version;
        }
        public mecab_dictionary_info_t.ByReference next(){
            readField("next");
            return next;
        }
        
        public static class ByReference extends mecab_dictionary_info_t implements Structure.ByReference {
            
        }
        public static class ByValue extends mecab_dictionary_info_t implements Structure.ByValue {
            
        }
    }
    
    public static class mecab_path_t extends Structure {
        // C type: struct mecab_node_t*
        public mecab_node_t.ByReference rnode;
        // C type: struct mecab_path_t*
        public mecab_path_t.ByReference rnext;
        // C type: struct mecab_node_t*
        public mecab_node_t.ByReference lnode;
        // C type: struct mecab_path_t*
        public mecab_path_t.ByReference lnext;
        // C type: int
        public int cost;
        // C type: const float
        public float prob;
        
        public mecab_path_t(){
            super();
            setAutoSynch(false);
        }
        public mecab_node_t.ByReference rnode(){
            readField("rnode");
            return rnode;
        }
        public mecab_path_t.ByReference rnext(){
            readField("rnext");
            return rnext;
        }
        public mecab_node_t.ByReference lnode(){
            readField("lnode");
            return lnode;
        }
        public mecab_path_t.ByReference lnext(){
            readField("lnext");
            return lnext;
        }
        public int cost(){
            readField("cost");
            return cost;
        }
        public float prob(){
            readField("prob");
            return prob;
        }
        
        public static class ByReference extends mecab_path_t implements Structure.ByReference {
            
        }
        public static class ByValue extends mecab_path_t implements Structure.ByValue {
            
        }
    }
    
    public class mecab_learner_path_t extends Structure {
        // C type: struct mecab_learner_node_t*
        public mecab_learner_node_t.ByReference rnode;
        // C type: struct mecab_learner_path_t*
        public mecab_learner_path_t.ByReference rnext;
        // C type: struct mecab_learner_node_t*
        public mecab_learner_node_t.ByReference lnode;
        // C type: struct mecab_learner_path_t*
        public mecab_learner_path_t.ByReference lnext;
        // C type: double
        public double cost;
        // C type: const int*
        public IntByReference fvector;
        
        public mecab_learner_path_t(){
            super();
            setAutoSynch(false);
        }
        public mecab_learner_node_t.ByReference rnode(){
            readField("rnode");
            return rnode;
        }
        public mecab_learner_path_t.ByReference rnext(){
            readField("rnext");
            return rnext;
        }
        public mecab_learner_node_t.ByReference lnode(){
            readField("lnode");
            return lnode;
        }
        public mecab_learner_path_t.ByReference lnext(){
            readField("lnext");
            return lnext;
        }
        public double cost(){
            readField("cost");
            return cost;
        }
        public IntByReference fvector(){
            readField("fvector");
            return fvector;
        }
        
        public static class ByReference extends mecab_learner_path_t implements Structure.ByReference {
            
        }
        public static class ByValue extends mecab_learner_path_t implements Structure.ByValue {
            
        }
    }
    
    public static class mecab_node_t extends Structure {
        // C type: struct mecab_node_t*
        public mecab_node_t.ByReference prev;
        // C type: struct mecab_node_t*
        public mecab_node_t.ByReference next;
        // C type: struct mecab_node_t*
        public mecab_node_t.ByReference enext;
        // C type: struct mecab_node_t*
        public mecab_node_t.ByReference bnext;
        // C type: struct mecab_path_t*
        public mecab_path_t.ByReference rpath;
        // C type: struct mecab_path_t*
        public mecab_path_t.ByReference lpath;
        // C type: struct mecab_node_t**
        public PointerByReference begin_node_list;
        // C type: struct mecab_node_t**
        public PointerByReference end_node_list;
        // C type: const char*
        public String surface;
        // C type: const char*
        public String feature;
        // C type: unsigned int
        public int id;
        // C type: unsigned short
        public short length;
        // C type: unsigned short
        public short rlength;
        // C type: unsigned short
        public short rcAttr;
        // C type: unsigned short
        public short lcAttr;
        // C type: unsigned short
        public short posid;
        // C type: unsigned char
        public byte char_type;
        // C type: unsigned char
        public byte stat;
        // C type: unsigned char
        public byte isbest;
        // C type: unsigned int
        public int sentence_length;
        // C type: float
        public float alpha;
        // C type: float
        public float beta;
        // C type: float
        public float prob;
        // C type: short
        public short wcost;
        // C type: long
        public long cost;
        
        public mecab_node_t(){
            super();
            setAutoSynch(false);
        }
        public mecab_node_t.ByReference prev(){
            readField("prev");
            return prev;
        }
        public mecab_node_t.ByReference next(){
            readField("next");
            return next;
        }
        public mecab_node_t.ByReference enext(){
            readField("enext");
            return enext;
        }
        public mecab_node_t.ByReference bnext(){
            readField("bnext");
            return bnext;
        }
        public mecab_path_t.ByReference rpath(){
            readField("rpath");
            return rpath;
        }
        public mecab_path_t.ByReference lpath(){
            readField("lpath");
            return lpath;
        }
        public PointerByReference begin_node_list(){
            readField("begin_node_list");
            return begin_node_list;
        }
        public PointerByReference end_node_list(){
            readField("end_node_list");
            return end_node_list;
        }
        public String surface(){
            readField("surface");
            return surface;
        }
        public String feature(){
            readField("feature");
            return feature;
        }
        public int id(){
            readField("id");
            return id;
        }
        public short length(){
            readField("length");
            return length;
        }
        public short rlength(){
            readField("rlength");
            return rlength;
        }
        public short rcAttr(){
            readField("rcAttr");
            return rcAttr;
        }
        public short lcAttr(){
            readField("lcAttr");
            return lcAttr;
        }
        public short posid(){
            readField("posid");
            return posid;
        }
        public byte char_type(){
            readField("char_type");
            return char_type;
        }
        public byte stat(){
            readField("stat");
            return stat;
        }
        public byte isbest(){
            readField("isbest");
            return isbest;
        }
        public int sentence_length(){
            readField("sentence_length");
            return sentence_length;
        }
        public float alpha(){
            readField("alpha");
            return alpha;
        }
        public float beta(){
            readField("beta");
            return beta;
        }
        public float prob(){
            readField("prob");
            return prob;
        }
        public short wcost(){
            readField("wcost");
            return wcost;
        }
        public long cost(){
            readField("cost");
            return cost;
        }
        
        public static class ByReference extends mecab_node_t implements Structure.ByReference {
        }
        public static class ByValue extends mecab_node_t implements Structure.ByValue {
        }
    }
    
    public class mecab_learner_node_t extends Structure {
        // C type: struct mecab_learner_node_t*
        public mecab_learner_node_t.ByReference prev;
        // C type: struct mecab_learner_node_t*
        public mecab_learner_node_t.ByReference next;
        // C type: struct mecab_learner_node_t*
        public mecab_learner_node_t.ByReference enext;
        // C type: struct mecab_learner_node_t*
        public mecab_learner_node_t.ByReference bnext;
        // C type: struct mecab_learner_path_t*
        public mecab_learner_path_t.ByReference rpath;
        // C type: struct mecab_learner_path_t*
        public mecab_learner_path_t.ByReference lpath;
        // C type: struct mecab_learner_node_t*
        public mecab_learner_node_t.ByReference anext;
        // C type: const char*
        public String surface;
        // C type: const char*
        public String feature;
        // C type: unsigned int
        public int id;
        // C type: unsigned short
        public short length;
        // C type: unsigned short
        public short rlength;
        // C type: unsigned short
        public short rcAttr;
        // C type: unsigned short
        public short lcAttr;
        // C type: unsigned short
        public short posid;
        // C type: unsigned char
        public byte char_type;
        // C type: unsigned char
        public byte stat;
        // C type: unsigned char
        public byte isbest;
        // C type: double
        public double alpha;
        // C type: double
        public double beta;
        // C type: short
        public short wcost2;
        // C type: double
        public double wcost;
        // C type: double
        public double cost;
        // C type: const int*
        public IntByReference fvector;
        
        public mecab_learner_node_t(){
            super();
            setAutoSynch(false);
        }
        public mecab_learner_node_t.ByReference prev(){
            readField("prev");
            return prev;
        }
        public mecab_learner_node_t.ByReference next(){
            readField("next");
            return next;
        }
        public mecab_learner_node_t.ByReference enext(){
            readField("enext");
            return enext;
        }
        public mecab_learner_node_t.ByReference bnext(){
            readField("bnext");
            return bnext;
        }
        public mecab_learner_path_t.ByReference rpath(){
            readField("rpath");
            return rpath;
        }
        public mecab_learner_path_t.ByReference lpath(){
            readField("lpath");
            return lpath;
        }
        public mecab_learner_node_t.ByReference anext(){
            readField("anext");
            return anext;
        }
        public String surface(){
            readField("surface");
            return surface;
        }
        public String feature(){
            readField("feature");
            return feature;
        }
        public int id(){
            readField("id");
            return id;
        }
        public short length(){
            readField("length");
            return length;
        }
        public short rlength(){
            readField("rlength");
            return rlength;
        }
        public short rcAttr(){
            readField("rcAttr");
            return rcAttr;
        }
        public short lcAttr(){
            readField("lcAttr");
            return lcAttr;
        }
        public short posid(){
            readField("posid");
            return posid;
        }
        public byte char_type(){
            readField("char_type");
            return char_type;
        }
        public byte stat(){
            readField("stat");
            return stat;
        }
        public byte isbest(){
            readField("isbest");
            return isbest;
        }
        public double alpha(){
            readField("alpha");
            return alpha;
        }
        public double beta(){
            readField("beta");
            return beta;
        }
        public short wcost2(){
            readField("wcost2");
            return wcost2;
        }
        public double wcost(){
            readField("wcost");
            return wcost;
        }
        public double cost(){
            readField("cost");
            return cost;
        }
        public IntByReference fvector(){
            readField("fvector");
            return fvector;
        }
        
        public static class ByReference extends mecab_learner_node_t implements Structure.ByReference {
            
        }
        public static class ByValue extends mecab_learner_node_t implements Structure.ByValue {
            
        }
    }
    
    // alias
    public static class size_t extends IntegerType {
        private static final long serialVersionUID = 1L;
        public size_t(){
            this(0);
        }
        public size_t(long value){
            super(Native.POINTER_SIZE, value);
        }
    }
    
}
