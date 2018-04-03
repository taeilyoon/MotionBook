package com.example.yuntaeil.motionbooks.Views;

import java.util.HashMap;
import java.util.Map;

public enum MainTabsType
{
        Featured (0),
        Search (1),
        BookMark (2),
        Setting(3),
        ;

        int value;
        MainTabsType(int value) {
                this.value = value;
        }

        public int getValue() {
                return value;
        }
        
        
        public static Map<Integer, MainTabsType> MainTabsPositionMapping = new HashMap<Integer, MainTabsType>(){{
                put(0, MainTabsType.Featured);
                put(1, MainTabsType.Search);
                put(2, MainTabsType.BookMark);
                put(3, MainTabsType.Setting);
        }};
}
