package test;

import javax.sound.midi.Soundbank;
import java.util.*;

public class Test1 {

    public static void main(String[] args) {
//        String str = "1,2,3";
//        System.out.println(str.split(",").length);
//        System.out.println(str.substring(0, str.indexOf(",", str.indexOf(",", str.indexOf(",") + 1) + 1)));


        String[] addStr = {"意向总价", "意向面积"};
        Set<String> addSet = new HashSet<String>(Arrays.asList(addStr));

        List<String> t = new ArrayList<>();
        t.add("意向总价");

        t = new ArrayList<>();

        addSet.removeAll(t);

        addSet.forEach(System.out::println);
    }
}
