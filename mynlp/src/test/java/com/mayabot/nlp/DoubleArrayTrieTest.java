package com.mayabot.nlp;

import com.mayabot.nlp.algorithm.collection.dat.*;
import com.mayabot.nlp.common.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class DoubleArrayTrieTest {

    DoubleArrayTrieMap<String> trie() {
        TreeMap<String, String> map = new TreeMap<>();

        String[] list = (
                "一举\n" +
                        "一举一动\n" +
                        "一举成名\n" +
                        "一举成名天下知\n" +
                        "五谷\n" +
                        "五谷丰登\n" +
                        "万万").split("\n");

        Set<Character> sets = new HashSet<>();
        for (int i = 0; i < list.length; i++) {
            map.put(list[i], list[i]);
            char[] chars = list[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                sets.add(chars[j]);
            }
        }

        DoubleArrayTrieMap<String> trie = new DoubleArrayTrieMap<String>(map);

        return trie;
    }

    @Test
    public void testDict(){
        TreeMap<String, String> map = new TreeMap<>();
        map.put("快乐大本营","节目--0000c463bbf9");
        map.put("快乐","节目--0000c463bbf9sw");
        map.put("奔跑吧","节目--2");
        map.put("雪山惊魂3","节目--3");

        map.put("张学友","歌手-id123");
        map.put("何炅","人物-23");

        DoubleArrayTrieMap<String> trie = new DoubleArrayTrieMap(map);

        String text = "我要看何炅主持的快乐大本营综艺节目";

        DATMapMatcher<String> result = trie.match(text, 0);

        while(result.next()){
            int offset = result.getBegin();
            int len = result.getLength();
            System.out.println(text.substring(offset,offset+len)+"----"+result.getValue());
        }

        //TODO 快乐大本营 在位置上是 "快乐" ，你要自己解决这个覆盖的问题
        // 通过map的value，你可以存放一个VO，不用String
    }


    @Test
    public void test() {
        DoubleArrayTrieMap<String> trie = trie();

        Assert.assertTrue(trie.containsKey("一举成名"));
        Assert.assertTrue(!trie.containsKey("一举2"));
    }

    @Test
    public void test2() {
        TreeSet<String> set = new TreeSet<>();

        set.addAll(Lists.newArrayList("0/","10"));
        List<String> list = set.stream().collect(Collectors.toList());
        System.out.println(list);
        DoubleArrayTrie dat = new DoubleArrayTrie(
               list
        );

        int x = dat.indexOf("0/");

        System.out.println(x);
        for (int i = 0; i < 128; i++) {
            System.out.print(dat.base[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < 128; i++) {
            System.out.print(dat.check[i]+" ");
        }
        System.out.println();
//        long t1 = System.currentTimeMillis();
//        int c = 0;
//        for (int i = 0; i < 100000; i++) {
//            DATMatcher matcher = dat.matcher("你好good世界你好世界");
//
//            while (matcher.next()) {
//                c+=matcher.getLength();
//            }
//        }
//
//        long t2 = System.currentTimeMillis();
//        System.out.println(c+"耗时 "+(t2-t1));

    }
}
