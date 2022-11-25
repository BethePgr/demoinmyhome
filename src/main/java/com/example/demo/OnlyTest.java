package com.example.demo;

import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
public class OnlyTest {

    public static Map<Integer,String> maps = new HashMap<>();

    static{
        maps.put(1,"하나");
        maps.put(2,"둘");
        maps.put(3,"셋");
    }

    public void putting(int num, String strs){
        maps.put(num,strs);
    }

    public Map<Integer, String> showme(){
        return maps;
    }

}
