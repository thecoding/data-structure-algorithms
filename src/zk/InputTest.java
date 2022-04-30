package zk;

import com.sun.corba.se.impl.orbutil.ObjectStreamClassUtil_1_3;

import java.util.*;

public class InputTest {

    private final int INPUT_LENGTH = 4;
    private final String OUT_STR = "第%d位学生成绩为：%d %d %d %d \n";
    List<Integer[]> stuList = new ArrayList<>();
    Map<Integer, Integer> stuSumMap = new HashMap<>();

    public static void main(String[] args) {
        InputTest inputTest = new InputTest();
        inputTest.console();
    }

    public void console(){
        // 控制台显示功能
        // 输入5个学员的成绩
        // 计算平均值和总值

        boolean isExample = true;
        boolean tip = true;
        // 控制是否继续循环
        Scanner scanner = new Scanner(System.in);
        boolean looper = true;
        while(looper){
            // 控制台输出相关命令
            if (tip) {
                System.out.println("按键 i 查看学生成绩 ");
                System.out.println("按键 c 清除已输入信息 ");
                System.out.println("按键 a 增加输入学生成绩 ");
                System.out.println("按键 s 统计汇总数据，平均值 ");
                System.out.println("按键 q 退出程序 ");
                tip = false;
            }
            String line = scanner.nextLine().trim().toLowerCase(Locale.ROOT);
            switch (line) {
                case "c":
                    stuList.clear();
                    stuSumMap.clear();
                    System.out.println("成绩已清空！！！");
                    break;
                case "a":
                    System.out.println("请输入四门成绩，以空格分开");
                    if (isExample) {
                        System.out.println("例如：90 92 93 94");
                        isExample = false;
                    }
                    line = scanner.nextLine();
                    InputMsg input = input(line);
                    if (!input.success) {
                        System.out.println(input.errorMsg);
                    }else{
                        System.out.println("增加成功!!!");
                    }
                    break;
                case "i":
                    // 查看当前学员成绩
                    printInfo();
                    break;
                case "s":
                    sum();
                    break;
                case "q":
                    System.out.println("退出程序...");
                    looper = false;
                    scanner.close();
                    break;
                default:
                    if (!line.equals("")) {
                        System.out.println("输入错误，请重新输入");
                    }
                    break;
            }
        }
    }

    // 汇总计算 平均成绩 超过平均成绩的人数
    private void sum(){
        int avl = 0;
        int sumScore = 0;
        int maxAvl = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : stuSumMap.entrySet()) {
            sumScore += integerIntegerEntry.getValue();
        }
        avl = (int) (sumScore / stuList.size());
        System.out.println("平均成绩为：" + avl);
        for (Map.Entry<Integer, Integer> integerIntegerEntry : stuSumMap.entrySet()) {
            if (integerIntegerEntry.getValue() >= avl) {
                maxAvl += 1;
            }
        }
        System.out.println("达到平均成绩的有" + maxAvl+ "位同学");
    }


    // 查看当前学员成绩
    private void printInfo(){
        if (stuList.size() == 0) {
            System.out.println("当前没有输入学员成绩");
        }else{
            for (int i = 0; i < stuList.size(); i++) {
                Integer[] integers = stuList.get(i);
                System.out.printf(OUT_STR, i + 1, integers[0], integers[1], integers[2], integers[3]);
            }
        }
    }

    // 接收成绩
    private InputMsg input(String inputString) {
        Integer[] stuScore = new Integer[INPUT_LENGTH];
        String[] s = inputString.split(" ");
        boolean success = true;
        String msg = "";
        // 学生总成绩
        int stuSumScore = 0;
        if (s.length != INPUT_LENGTH) {
            success = false;
            msg = "请输入正确的位数";
        }else{
            for (int i = 0; i < s.length; i++) {
                try {
                    stuScore[i] = Integer.parseInt(s[i]);
                    stuSumScore += Integer.parseInt(s[i]);
                } catch (Exception e) {
                    msg = "第" + i + "位成绩不正确";
                    break;
                }
            }
        }
        if (!msg.equals("")) {
            success = false;
        }else{
            stuList.add(stuScore);
            stuSumMap.put(stuList.size() - 1, stuSumScore);
        }
        return new InputMsg(success, msg);
    }




    static class InputMsg{
        private boolean success = true;
        private String errorMsg;

        public InputMsg(boolean success) {
            this.success = success;
        }

        public InputMsg(boolean success, String errorMsg) {
            this.success = success;
            this.errorMsg = errorMsg;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public String getErrorMsg() {
            return errorMsg;
        }

        public void setErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
        }
    }

}








class Test1{
    public void run(){
        List<Integer[]> scoreList = new ArrayList<>();
        // 当前学生
        int curStudent = 0;
        System.out.println("请输入第" + (curStudent + 1) + "个学生的四门成绩，用空格分开");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String next = scanner.nextLine();
            while (true) {
                String[] numStr = next.split(" ");
                if (numStr.length != 4) {
                    System.out.println("只能输入4门成绩");
                    break;
                }
                Integer[] scoreArr = new Integer[numStr.length];
                for (int i = 0; i < numStr.length; i++) {
                    try {
                        scoreArr[i] = Integer.parseInt(numStr[i]);
                    } catch (Exception e) {
                        System.out.println("第" + (i + 1) + "输入有误。。请重新输入");
                        return;
                    }
                }
                scoreList.add(scoreArr);
                if (scoreList.size() == 5) {
                    // 计算总成绩和平均成绩
                    int sumSore = 0;
                    // 每个学生的总成绩
                    int[] stuSumScore = new int[scoreList.size()];
                    for (int i = 0; i < scoreList.size(); i++) {
                        Integer[] integers = scoreList.get(i);
                        int stuScore = 0;
                        for (Integer score : integers) {
                            stuScore += score;
                        }
                        stuSumScore[i] = stuScore;
                        sumSore += stuScore;
                    }
                    // 平均成绩为
                    int avl = (int)(sumSore / scoreList.size());
                    System.out.println("平均成绩为：" + avl);
                    // 大于平均成绩的人数
                    int largeSum = 0;
                    for (int i = 0; i < stuSumScore.length; i++) {
                        if (stuSumScore[i] > avl) {
                            largeSum += 1;
                        }
                    }
                    System.out.println("超过平均成绩的有：" + largeSum + " 位同学");
                }
                break;
            }
        }
    }
}