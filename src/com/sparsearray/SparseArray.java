package com.sparsearray;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhouc on 2019/11/2.
 * 稀疏数组
 */
public class SparseArray {


    public static void main(String[] args) {
        int[][] chessArr = getData();
        int[][] sparseArr = getSparseArr(chessArr);
        sparseToArr(sparseArr);
        saveToFile(sparseArr);
        readFromFile();
    }

    private static void readFromFile() {
        File file = new File("/Users/zhouchao/gitee/DataStructures/out/test","sparse.text");
        if (!file.exists()) {
            return;
        }
        List<String> list = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String data = null;
            while ((data = bufferedReader.readLine()) != null) {
                if (data.length() > 0) {
                    list.add(data);
                }
            }
            int[][] sparseArr = new int[list.size()][3];
            for (int i = 0; i < list.size(); i++) {
                String[] strings = list.get(i).split(",");
                for (int j = 0; j < strings.length; j++) {
                    sparseArr[i][j] = Integer.parseInt(strings[j]);
                }
            }
            sout(sparseArr,"文件读出的数据");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void saveToFile(int[][] sparseArr) {
        File file = new File("/Users/zhouchao/gitee/DataStructures/out/test","sparse.text");
        if (file.exists()) {
            file.delete();
        }

        file.getParentFile().mkdirs();

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            String str = "";
            for (int[] ints : sparseArr) {
                for (int i = 0; i < ints.length; i++) {
                    str += ints[i] + ",";
                    if (i == ints.length - 1) {
                        str = str.substring(0, str.length()-1);
                    }
                }
                str += "\n";
            }
            try {
                fileOutputStream.write(str.getBytes());
                fileOutputStream.flush();
                fileOutputStream.close();
                System.out.println("保存成功，文件路径为：/Users/zhouchao/gitee/DataStructures/out/test/sparse.text");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建一个原始的二维数据
     */
    private static int[][] getData(){
        int chessArr[][] = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        sout(chessArr,"原始数据");
        return chessArr;
    }

    /**
     * 得到稀疏数组（行、列、值）
     *
     * @return
     */
    private static int[][] getSparseArr(int[][] orgArr){
        int valCount = 0;
        for (int[] ints : orgArr) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    valCount ++ ;
                }
            }
        }
        int[][] sparseArr = new int[valCount + 1][3]; //初始化稀疏数组
        //稀疏数组第一行是概述，这一行的第一个数据表示 总共多少行，第二个数据表示总共多少列，第三个数据表示一共有多少个数据有值
        //从第二行开始 第一个数据表示 数据在第几行 ，第二个数据表示 数据在第几列，第三个数据 数据的值是多少

        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = valCount;

        int count = 0;
        for (int i = 0; i < orgArr.length; i++) {
            int[] lineArray = orgArr[i];
            for (int j = 0; j < lineArray.length; j++) {
                if (lineArray[j] != 0) {
                    count ++ ;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = lineArray[j];
                }
            }
        }
        sout(sparseArr,"稀疏数组");
        return sparseArr;
    }

    /**
     * 稀疏数组转为二维数组
     * @param sparseArr
     */
    private static void sparseToArr(int[][] sparseArr){
        int[][] chessArr = new int[sparseArr[0][0]][sparseArr[0][1]];

        for (int i = 1; i < sparseArr.length; i++) {
            int[] array = sparseArr[i];
            chessArr[array[0]][array[1]] = array[2];
        }

        sout(chessArr,"恢复后的数据");
    }


    private static void sout(int[][] outArr,String outTitle){
        System.out.println(outTitle);
        for (int[] ints : outArr) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.printf("\n");
        }
        System.out.println();
    }
}



