package com.union;

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

    public static void main(String[] args) {
        char[][] grid1 = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        char[][] grid2 = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        int i = numberIsland(grid1);
        System.out.println("i = " + i);
        int j = numberIsland(grid2);
        System.out.println("j = " + j);
    }


}
