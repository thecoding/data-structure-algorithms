package com.union;


import java.util.ArrayList;
import java.util.List;

// 本题为leetcode原题
// 测试链接：https://leetcode.com/problems/number-of-islands-ii/
// 所有方法都可以直接通过
// A 2d grid map of m rows and n columns is initially filled with water.
// We may perform an addLand operation which turns the water at position (row, col) into a land.
// Given a list of positions to operate, count the number of islands after each addLand operation.
// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
// You may assume all four edges of the grid are all surrounded by water.
// 给定一个m行，n列的数组范围，每增加一个char[][] position，就合并一个，
// 结果返回总共有点是相连接的
public class Code23_NumberOfIslandsII {


    public static void main(String[] args) {
        int[][] position = {{0,0}, {0,1}, {1,2}, {2,1}};
        List<Integer> integers = addLand(3, 3, position);
        System.out.println(integers);
    }

    public static List<Integer> addLand(int m, int n, int[][] position) {
        List<Integer> rtn = new ArrayList<>();
        UnionFind1 unionFind1 = new UnionFind1(m, n);
        if (m <= 0 || n <= 0) {
            return rtn;
        }
        for (int[] chars : position) {
            rtn.add(unionFind1.connect(chars[0], chars[1]));
        }
        return rtn;
    }

    public static class UnionFind1 {
        private int row;
        private int col;
        private int[] parents;
        private int[] sizes;
        private int[] help;
        private int size;

        public UnionFind1(int row, int col) {
            this.row = row;
            this.col = col;
            int num = row * col;
            parents = new int[num];
            sizes = new int[num];
            help = new int[num];
            size = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    int index = getIndexFromTable(i, j);
                    parents[index] = index;
                    sizes[index] = 0;
                }
            }
        }

        public int connect(int r, int c) {
            int index = getIndexFromTable(r, c);
            // 默认加进来的需要设置为1
            if (sizes[index] == 0) {
                parents[index] = index;
                sizes[index] = 1;
                size++;
                union(r, c, r - 1, c);
                union(r, c, r + 1, c);
                union(r, c, r, c - 1);
                union(r, c, r, c + 1);
            }
            return size;
        }

        // 根据坐标和col获取当前数字的索引位置
        private int getIndexFromTable(int i, int j) {
            return i * col + j;
        }

        // 把指定位置的点，合并，(默认)两个点都是要合并的
        public void union(int r1, int c1, int r2, int c2) {
            if (r1 < 0 || r2 < 0 || r1 >= row || r2 >= row || c1 < 0 || c2 < 0 || c1 >= col || c2 >= col) {
                return;
            }
            int index1 = getIndexFromTable(r1, c1);
            int index2 = getIndexFromTable(r2, c2);
            int index1Father = getFatherIndex(index1);
            int index2Father = getFatherIndex(index2);
            if (sizes[index1Father] == 0 || sizes[index2Father] == 0) {
                return;
            }
            // 两个父类索引不相等，说明需要合并
            if (index1Father != index2Father) {
                if (sizes[index1Father] > sizes[index2Father]) {
                    parents[index2Father] = index1Father;
                    sizes[index1Father] += sizes[index2Father];
                    sizes[index2Father] = 0;
                }else{
                    parents[index1Father] = index2Father;
                    sizes[index2Father] += sizes[index1Father];
                    sizes[index1Father] = 0;
                }
                size--;
            }
        }

        // 根据索引，获取父类的索引，并且将不是不是正确指向直接父类的改成直接父类
        // eg: 1 -> 2  2->3  ==> 1->3 2-> 3
        private int getFatherIndex(int index) {
            int child = 0;
            while (index != parents[index]) {
                // 暂存不是正确指向的子类
                help[child++] = index;
                index = parents[index];
            }
            // 最后一次空转+1了
            child--;
            while (child >= 0) {
                parents[help[child--]] = index;
            }
            return index;
        }

    }


}
