package org.chasen.mecab;

import org.chasen.mecab.mecab.mecab_dictionary_info_t;
import org.chasen.mecab.mecab.mecab_node_t;
import org.chasen.mecab.mecab.mecab_t;

public class Main {
    
    static {
        System.setProperty("jna.encoding", "UTF-8");
    }
    
    public static void main(String...args){
        mecab mecab = LibMecab.mecab;
        System.out.println(mecab.mecab_version()); // ==> 0.97
        
        mecab_t mecab_t = mecab.mecab_new2("-r /opt/local/etc/mecabrc");
        try {
            mecab_dictionary_info_t dict = mecab.mecab_dictionary_info(mecab_t);
            System.out.println("dict => " + dict.filename + ":" + dict.charset);
            
            {
                String str = "にわにわにわにわとりがいた";
                String sparse = mecab.mecab_sparse_tostr(mecab_t, str);
                System.out.println(sparse);
                //
                // に    助詞,格助詞,一般,*,*,*,に,ニ,ニ
                // わに  名詞,一般,*,*,*,*,わに,ワニ,ワニ
                // わに  名詞,一般,*,*,*,*,わに,ワニ,ワニ
                // わ   助詞,終助詞,*,*,*,*,わ,ワ,ワ,naist-jdic.utf8.csv-2143476340
                // にわとり    名詞,一般,*,*,*,*,にわとり,ニワトリ,ニワトリ
                // が   助詞,格助詞,一般,*,*,*,が,ガ,ガ
                // い   動詞,自立,*,*,一段,連用形,いる,イ,イ
                // た   助動詞,*,*,*,特殊・タ,基本形,た,タ,タ
                // EOS
                //
            }
            
            {
                String str = "本日は晴天なり";
                mecab_node_t node_t = mecab.mecab_sparse_tonode(mecab_t, str);
                System.out.println(node_t.feature);                             // BOS/EOS,*,*,*,*,*,*,*,*
                System.out.println(node_t.next.feature);                        // 名詞,副詞可能,*,*,*,*,本日,ホンジツ,ホンジツ
                System.out.println(node_t.next.next.feature);                   // 助詞,係助詞,*,*,*,*,は,ハ,ワ
                System.out.println(node_t.next.next.next.feature);              // 名詞,一般,*,*,*,*,晴天,セイテン,セイテン
                System.out.println(node_t.next.next.next.next.feature);         // 助動詞,*,*,*,文語・ナリ,基本形,なり,ナリ,ナリ
                System.out.println(node_t.next.next.next.next.next.feature);    // BOS/EOS,*,*,*,*,*,*,*,*
            }
        } finally {
            mecab.mecab_destroy(mecab_t);
        }
    }
}
