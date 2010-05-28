package org.chasen.mecab.wrapper.function;

import java.net.URL;

import org.chasen.mecab.mecab.mecab_dictionary_info_t;
import org.chasen.mecab.mecab.mecab_t;
import org.junit.Assert;
import org.junit.Test;

public class MecabTest {

    @Test
    public void testMecab_newStringArray() {
        {
            mecab_t mecab = Mecab.mecab_new("r", "/path/to/unknown");
            Assert.assertNotNull(mecab);
            mecab_dictionary_info_t dic = Mecab.mecab_dictionary_info(mecab);
            System.out.println(dic.charset());
            Assert.assertFalse("utf-8".equalsIgnoreCase(dic.charset()));
            Mecab.mecab_destroy(mecab);
        }
        {
            URL mecabrc = Thread.currentThread().getContextClassLoader().getResource("resources/test1_mecabrc");
            mecab_t mecab = Mecab.mecab_new("r", mecabrc.getPath());
            Assert.assertNotNull(mecab);
            mecab_dictionary_info_t dic = Mecab.mecab_dictionary_info(mecab);
            System.out.println(dic.charset());
            Assert.assertFalse("utf-8".equalsIgnoreCase(dic.charset()));
            Mecab.mecab_destroy(mecab);
        }
        {
            URL mecabrc = Thread.currentThread().getContextClassLoader().getResource("resources/test1_mecabrc");
            mecab_t mecab = Mecab.mecab_new("-r", mecabrc.getPath());
            Assert.assertNotNull(mecab);
            mecab_dictionary_info_t dic = Mecab.mecab_dictionary_info(mecab);
            System.out.println(dic.charset());
            Assert.assertTrue("utf-8".equalsIgnoreCase(dic.charset()));
            Mecab.mecab_destroy(mecab);
        }
        {
            URL mecabrc = Thread.currentThread().getContextClassLoader().getResource("resources/test1_mecabrc");
            mecab_t mecab = Mecab.mecab_new("-r " + mecabrc.getPath());
            Assert.assertNotNull(mecab);
            mecab_dictionary_info_t dic = Mecab.mecab_dictionary_info(mecab);
            System.out.println(dic.charset());
            Assert.assertTrue("utf-8".equalsIgnoreCase(dic.charset()));
            Mecab.mecab_destroy(mecab);
        }
        {
            URL mecabrc = Thread.currentThread().getContextClassLoader().getResource("resources/test2_mecabrc");
            mecab_t mecab = Mecab.mecab_new("-r", mecabrc.getPath());
            Assert.assertNull(mecab);
            Mecab.mecab_destroy(mecab);
        }
        {
            URL mecabrc = Thread.currentThread().getContextClassLoader().getResource("resources/test2_mecabrc");
            mecab_t mecab = Mecab.mecab_new("-r " + mecabrc.getPath());
            Assert.assertNull(mecab);
            Mecab.mecab_destroy(mecab);
        }
    }
}
