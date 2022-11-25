package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OnlyTestTest {
    public static Map<Integer,String> maps = new HashMap<>();

    static{
        maps.put(1,"하나");
        maps.put(2,"둘");
        maps.put(3,"셋");
    }

    @Test
    @DisplayName("map에다가 4,넷을 추가하였으므로 사이즈는 4여야한다")
    void addOne(){
        maps.put(4,"넷");
        assertEquals(4,maps.size());
    }
    @Test
    @DisplayName("map에는 사이즈가 3이여야하고 당연히 null값이면 안된다.")
    void showme(){
        assertEquals(3,maps.size());
        assertNotNull(maps);
    }

}