package com.yuki.bigdata.common.util;

import java.util.Arrays;
import java.util.List;

public class StringUtil {
    public static List<String>  transfer(String arr){
        if(arr==null){
            return null;
        }
        return Arrays.asList(arr.replace("[", "").replace("]", "").split(","));
    }
}
