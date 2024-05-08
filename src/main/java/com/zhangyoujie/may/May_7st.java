package com.zhangyoujie.may;

import java.util.*;

public class May_7st {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> list1 = new LinkedList<>();

        Set<String> set = new HashSet<>();
        SortedSet<String> set1 = new TreeSet<>();

        set.add("13124");
        set.add("gwrwer");
        set.add("gsrwerw24");
        set.add("423524234rw");
        set.add("43522424");

        set1.add("1");
        set1.add("2");
        set1.add("3");
        set1.add("44");
        set1.add("55");

        for (String s : set) {
            System.out.println(s);
        }
        System.out.println("-----------------");

        for (String s : set1) {
            System.out.println(s);
        }



    }
}
