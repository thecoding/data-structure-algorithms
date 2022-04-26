package leetcode.top100;

import java.util.*;

public class Q36 {

    public static void main(String[] args) {
//       Q36 q = new Q36();
//       q.test();
//        String string = "12  7  8 111";
//        string = string.replaceAll( " + ", "");
//        System.out.println(string);
//
//        System.out.println("a       a".replaceAll(" + ", " "));

        String s1 = "12**3*111";
        String s2 = "12***3111";
        String s3 = "12****3111";


        System.out.println(s1.replaceAll("\\*", " ").replaceAll(" + ", "%").replaceAll(" ", "%"));
        System.out.println(s2.replaceAll("\\*", " ").replaceAll(" + ", "%").replaceAll(" ", "%"));
        System.out.println(s3.replaceAll("\\*", " ").replaceAll(" + ", "%").replaceAll(" ", "%"));

    }

    private void test() {
        List<TObject> list = new ArrayList<>();
        list.add(new TObject(1, "A"));
        list.add(new TObject(2,"无意向"));
        list.add(new TObject(3,"C"));
        list.add(new TObject(4, "B"));

        // 方式一
//        Collections.sort(list, new Comparator<TObject>() {
//            @Override
//            public int compare(TObject o1, TObject o2) {
//                return o1.getValue().compareTo(o2.getValue());
//            }
//        });

//        list.forEach(v -> System.out.println( v.getId() + " -- " + v.getValue()));
        System.out.println();

        // 方式二
//        list.stream().sorted(Comparator.comparing(TObject::getValue));

//        list.forEach(v -> System.out.println( v.getId() + " -- " + v.getValue()));


        List<TObject> list2 = new ArrayList<>();
        list2.add(new TObject(3, "A"));
        list2.add(new TObject(14,"无意向"));
        list2.add(new TObject(2,"C"));
        list2.add(new TObject(34, "B"));


        MainObj m1 = new MainObj();
        m1.setmId(1);
        m1.setObjList(list);

        MainObj m2 = new MainObj();
        m2.setmId(2);
        m2.setObjList(list2);

        List<MainObj> mList = new ArrayList<>();
        mList.add(m1);
        mList.add(m2);


//        mList.stream().sorted(Comparator.comparing(TObject::getValue)).collect(Arrays::new)
    }


    // 暴力
    public int trap(int[] height) {
        int r = 0;
        int i = 0;
        while (i < height.length - 1) {
            
        }
        return -1;
    }
}
class MainObj{
    private int mId;
    private List<TObject> objList;

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public List<TObject> getObjList() {
        return objList;
    }

    public void setObjList(List<TObject> objList) {
        this.objList = objList;
    }
}

class TObject {
    private String value;
    private int id;

    public TObject(int id, String value) {
        this.value = value;
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
