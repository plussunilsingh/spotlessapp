package com.testp.spotlessapp.dirtytestcode;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DirtyTestCode {
    public static void main(String[] args) {
        System.out.println("testing dirty code");

        //empty code check


        A a = new DirtyTestCode.A();

        for (Map<String, String> map : a.m1()) {

            map.forEach((key,val)->System.out.println(key + " : "+ val));

        }

    }

    static class A {
        public List<Map<String, String>> m1() {
            return List.of(Map.of("name", "singh"),
                    Map.of("name", "ravi"),
                    Map.of("name", "vivek"),
                    Map.of("name", "venkatesh"));
        }
    }
}
