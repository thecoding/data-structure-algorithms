package com.union;

import java.util.HashMap;
import java.util.List;

// class_15
// 本题为leetcode原题
// 测试链接：https://leetcode.com/problems/number-of-islands/
// 所有方法都可以直接通过
// todo
// 1、只要字符是1，就感染当前位置的上下左右节点
// 给定一个二维数组 matrix,里面的值不是1就是0,
//上、下、左、右相邻的1认为是一片岛
//返回 matrix中岛的数量
// Input: grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//Output: 1
// Input: grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//Output: 3
public class Code22_NumberOfIslands {

    //  常规思路
    public static int numberIsland(char[][] grid) {
        int island = 0;
        for (int i = 0; i < grid.length; i++) {
            char[] hang = grid[0];
            for (int j = 0; j < hang.length; j++) {
                if (grid[i][j] == '1') {
                    island++;
                    infect(grid, i, j);
                }
            }
        }
        return island;
    }

    // 感染其他位置
    private static void infect(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = 0;
        infect(grid, i - 1, j);
        infect(grid, i + 1, j);
        infect(grid, i, j - 1);
        infect(grid, i, j + 1);
    }

    // 为了测试
    public static char[][] generateRandomMatrix(int row, int col) {
        char[][] board = new char[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = Math.random() < 0.5 ? '1' : '0';
            }
        }
        return board;
    }

    public static class Dog{
        int row;
        int col;

        public Dog(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static class Node<V>{
        V v;
        public Node(V v) {
            this.v = v;
        }
    }

    public static class UnionFind2<V> {
        HashMap<V,Node<V>> nodes;
        HashMap<Node<V>, Node<V>> parents;
        HashMap<Node<V>, Integer> sizeMaps;

        public UnionFind2(List<V> list) {
            nodes = new HashMap<>();
            parents = new HashMap<>();
            sizeMaps = new HashMap<>();
            for (V v : list) {
                Node<V> node = new Node<>(v);
                nodes.put(v, node);
                parents.put(node, node);
                sizeMaps.put(node, 1);
            }
        }

        public Node<V> findFather(Node<V> node) {
            //
            while (node != parents.get(node)) {

                node = parents.get(node);
            }

            return null;
        }

        public void union(V a1, V b1) {
            Node<V> a = new Node<>(a1);
            Node<V> b = new Node<>(b1);
            // 如果父类不是同一个，比较size，size大的挂在小的节点上面
            if (parents.get(a) != parents.get(b)) {
                int aSize = sizeMaps.get(a);
                int bSize = sizeMaps.get(b);
                Node<V> big = aSize >= bSize ? a : b;
                Node<V> small = big == a ? b : a;
                parents.put(small, big);
                sizeMaps.remove(small);
            }
        }

    }


    public static void main(String[] args) {
        char[][] grid1 = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        char[][] grid2 = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        int i = numberIsland(grid1);
        System.out.println("i = " + i);
        int j = numberIsland(grid2);
        System.out.println("j = " + j);
    }


}
