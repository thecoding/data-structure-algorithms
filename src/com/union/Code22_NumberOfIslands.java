package com.union;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

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


    public static int numberIsland2(char[][] grid) {
        List<Dot> dotList = new ArrayList<>();
        Dot[][] dots = new Dot[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1'){
                    // 这里生成的对象应该在合并的时候用同一个，内存地址是一样
                    dots[i][j] = new Dot();
                    dotList.add(dots[i][j]);
                }
            }
        }

        // 设想
        // 横向移动合并 左右的 '1' 的数据
        // 纵向移动合并 上下的 '1' 的数据 (怎么循环取呢？特别是矩阵不规整的情况下)
        // 移动的标准：从左往右移动，如果右边的不是 '1'，就往右边跳两格
        //            从上往下移动，如果下边的不是 '1'，往下边跳两格
        UnionFind2<Dot> dogUnionFind2 = new UnionFind2<>(dotList);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1'){
                    // 往右合并
                    if(j + 1 < grid[i].length){
                        if(grid[i][j+1] == '1'){
                            dogUnionFind2.union(dots[i][j], dots[i][j + 1]);
                        }
                    }
                    // 往下合并
                    if (i + 1 < grid.length) {
                        if(grid[i+1][j] == '1'){
                            dogUnionFind2.union(dots[i+1][j], dots[i][j]);
                        }
                    }
                }
            }
        }
        return dogUnionFind2.size();
    }

    public static class Dot {
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

        // 返回集合的大小
        public int size(){
            return sizeMaps.size();
        }

        // 入参需要一个List的集合
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

        // 持续找的过程，设置下面所有节点的父节点都是同一个节点
        // 找到上级是谁，这个要根据union来，看union是怎么合并的
        public Node<V> findFather(Node<V> node) {
            // 记录该节点下面的所有节点
            Stack<Node<V>> childNode = new Stack<>();
            while (node != parents.get(node)) {
                childNode.push(node);
                node = parents.get(node);
            }
            while(!childNode.isEmpty()){
                // 弹出一个子节点，并且设置父节点
                parents.put(childNode.pop(), node);
            }
            return node;
        }

        // parents 放了所有节点的信息，通过get必然能找到上级
        // 如果上级是自己，说明这个节点是没有合并的
        // 如果不是自己，可以继续往上找
        public void union(V a1, V b1) {
            Node<V> a = findFather(nodes.get(a1));
            Node<V> b = findFather(nodes.get(b1));
            // 如果父类不是同一个，比较size，size大的挂在小的节点上面
            if (parents.get(a) != parents.get(b)) {
                int aSize = sizeMaps.get(a);
                int bSize = sizeMaps.get(b);
                Node<V> big = aSize >= bSize ? a : b;
                Node<V> small = big == a ? b : a;
                parents.put(small, big);
                sizeMaps.put(big, aSize + bSize);
                sizeMaps.remove(small);
            }
        }

    }

    private static int numberIsland3(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        UnionFind3 unionFind3 = new UnionFind3(grid);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j] == '1'){
                    // 往右合并
                    if(j + 1 < col){
                        if(grid[i][j+1] == '1'){
                            unionFind3.union(i,j,i,j+1);
                        }
                    }
                    // 往下合并
                    if (i + 1 < row) {
                        if(grid[i+1][j] == '1'){
                            unionFind3.union(i,j,i+1,j);
                        }
                    }
                }
            }
        }
        return unionFind3.getSize();
    }

    // 不用HashMap来做辅助，只用基础数据类型来做
    public static class UnionFind3 {
        private final int[] parents; // 用于记录所有 '1' 的下标值
        private final int[] sizes; // 用于记录所有能组合到一起 '1' 集合的个数
        private int size; // 记录sizes中大于0的个数
        private final int[] help;
        private final int col;

        // 初始化，标记为 '1' 在parent中的下标
        // 并且初始化 '1' 位置的大小为 1
        public UnionFind3(char[][] grid) {
            int row = grid.length;
            col = grid[0].length;
            int num = row * col;
            parents = new int[num];
            sizes = new int[num];
            help = new int[num];
            size = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if(grid[i][j] == '1'){
                        int index = getIndexFromParent(i, j);
                        parents[index] = index;
                        sizes[index] = 1;
                        size++;
                    }
                }
            }
        }
        // 合并两个点
        public void union(int r1, int c1, int r2, int c2) {
            // 获取点在parents的下标
            int r1Index = getIndexFromParent(r1, c1);
            int r2Index = getIndexFromParent(r2, c2);
            // 根据下标从parent中获取父节点的下标
            int r1ParentIndex = findFather(r1Index);
            int r2ParentIndex = findFather(r2Index);
            if (r1ParentIndex != r2ParentIndex) {
                if (sizes[r1ParentIndex] > sizes[r2ParentIndex]) {
                    parents[r1ParentIndex] = r2ParentIndex;
                    sizes[r2ParentIndex] = sizes[r1ParentIndex] + sizes[r2ParentIndex];
                    sizes[r1ParentIndex] = 0;
                }else{
                    parents[r2ParentIndex] = r1ParentIndex;
                    sizes[r1ParentIndex] = sizes[r1ParentIndex] + sizes[r2ParentIndex];
                    sizes[r2ParentIndex] = 0;
                }
                size--;
            }
        }

        public int getSize(){
            return size;
        }

        // 指定下标的父节点，index为目标节点的下标

        private int findFather(int index) {
            int hi = 0;
            while (index != parents[index]) {
                help[hi++] = index;
                index = parents[index];
            }
            // 这里需要注意，上一个循环最后一次加了一次，但是没有加数据
            hi--;
            while (hi >= 0) {
//            for (hi--; hi >= 0; hi--) {
                parents[help[hi--]] = index;
            }
            return index;
        }

        private int getIndexFromParent(int i, int j) {
            return i * col + j;
        }
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

    public static char[][] copy(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        char[][] ans = new char[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans[i][j] = board[i][j];
            }
        }
        return ans;
    }


    public static void print(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    System.out.print("1");
                }else{
                    System.out.print("0");
                }
                if (j + 1 < grid[0].length) {
                    System.out.print(", ");
                }
            }
            System.out.println("");
        }
    }


    public static void main(String[] args) {
        char[][] grid1 = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        char[][] grid2 = {{'1','1','0','1','0'},{'1','1','0','0','1'},{'0','0','1','0','0'},{'0','0','0','1','1'}};

        grid1 = generateRandomMatrix(1000,1000);
        grid2 = generateRandomMatrix(10,10);

//        char[][] grid = copy(grid1);
//        print(grid);

        char[][] grid1_cp1 = copy(grid1);
        char[][] grid1_cp2 = copy(grid1);


        char[][] grid2_cp1 = copy(grid2);
        char[][] grid2_cp2 = copy(grid2);

        long start;
        long end;

        start = System.currentTimeMillis();
        int i0 = numberIsland(grid1);
        System.out.println("i0 = " + i0);
        end = System.currentTimeMillis();
        System.out.println("第一种方法执行：" + (end - start) + "ms");

        System.out.println("---------------------------------");

        start = System.currentTimeMillis();
        int i2 = numberIsland2(grid1_cp1);
        System.out.println("i2 = " + i2);
        end = System.currentTimeMillis();
        System.out.println("第二种方法执行：" + (end - start) + "ms");


        System.out.println("---------------------------------");

        start = System.currentTimeMillis();
        int i3 = numberIsland3(grid1_cp2);
        System.out.println("i3 = " + i3);
        end = System.currentTimeMillis();
        System.out.println("第三种方法执行：" + (end - start) + "ms");

        System.out.println("=================================");


//        grid = copy(grid2);
//        print(grid);

        start = System.currentTimeMillis();
        int i00 = numberIsland(grid2);
        System.out.println("i00 = " + i00);
        end = System.currentTimeMillis();
        System.out.println("第一种方法执行：" + (end - start) + "ms");

        System.out.println("---------------------------------");

        start = System.currentTimeMillis();
        int i22 = numberIsland2(grid2_cp1);
        System.out.println("i22 = " + i22);
        end = System.currentTimeMillis();
        System.out.println("第二种方法执行：" + (end - start) + "ms");


        System.out.println("---------------------------------");

        start = System.currentTimeMillis();
        int i33 = numberIsland3(grid2_cp2);
        System.out.println("i33 = " + i33);
        end = System.currentTimeMillis();
        System.out.println("第三种方法执行：" + (end - start) + "ms");

    }




}
