package zk;


// 计算阶乘
public class Q1 {

    public static void main(String[] args) {
        System.out.println(computer(3));
    }

    public static long computer(int i){
        return mut(i);
    }

    private static long mut(long a) {
        if (a <= 1) {
            return 1;
        }else{
            return a * mut(a - 1);
        }
    }
}
