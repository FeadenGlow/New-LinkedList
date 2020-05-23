package com.company;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws SizeException{
        LinkedList2 list = new LinkedList2();
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println(list.size());
        System.out.println(list.get(0));
        list.set(0, "4");
        System.out.println(list.get(0));
        list.remove(0);
        System.out.println(list.get(0));
        list.clear();

    }
}
