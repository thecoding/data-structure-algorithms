package com.trie;

/**
 * 基于26个小字母字符串
 * Created by Mirko on 2020/9/4.
 */
public class TrieTree_01 {


    public static void main(String[] args) {
        Trie01 trie01 = new Trie01(new Node01());
        trie01.add("abc");
        trie01.add("abcd");
        trie01.add("abcde");
        System.out.println("----");
        int i = trie01.select("abc");
        System.out.println("----");
        trie01.delete("abcd");
        System.out.println("----");
    }


    public static class Node01 {

        int pass = 0;
        int end = 0;
        Node01[] nexts;
        char c;

        public Node01() {
            nexts = new Node01[26];
        }

        public Node01(char c) {
            this.c = c;
            nexts = new Node01[26];
        }
    }

    public static class Trie01 {

        Node01 root;

        public Trie01(Node01 root) {
            this.root = root;
        }


        /**
         * 往前置树中增加一个字符串
         * @param str   需要增加的字符串
         */
        public void add(String str) {
            if (str == null) {
                return;
            }
            char[] chars = str.toCharArray();
            this.root.pass++;
            //当前节点
            Node01 curNode = root;
            int path = 0;
            for (int i = 0; i < chars.length; i++) {
                path = chars[i] - 'a';
                if (curNode.nexts[path] == null) {
                    curNode.nexts[path] = new Node01(chars[i]);
                }
                curNode = curNode.nexts[path];
                curNode.pass++;
            }
            curNode.end++;
        }

        /**
         * 查询是否存在以str开头的字符串
         * @param str 需要查询的字符串
         * @return
         */
        public int select(String str){
            if (str == null) {
                return 0;
            }
            char[] chars = str.toCharArray();
            Node01 curNode = root;
            int path = 0;
            for (int i = 0; i < chars.length; i++) {
                path = chars[i] - 'a';
                if (curNode.nexts[path] == null) {
                    return 0;
                }
                curNode = curNode.nexts[path];
            }
            return curNode.pass;
        }

        /**
         * 删除一个字符串
         * @param str 需要删除的字符串
         */
        public void delete(String str) {
            if (select(str) == 0) {
                return;
            }
            char[] chars = str.toCharArray();
            Node01 curNode = root;
            curNode.pass--;
            int path = 0;
            for (int i = 0; i < chars.length; i++) {
                path = chars[i] - 'a';
                if (--curNode.nexts[path].pass == 0) {
                    curNode.nexts[path] = null;
                    return;
                }
                curNode = curNode.nexts[path];
            }
            curNode.end--;
        }
    }
}
