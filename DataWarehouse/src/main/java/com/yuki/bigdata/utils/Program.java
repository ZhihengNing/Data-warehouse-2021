package com.yuki.bigdata.utils;

import java.io.IOException;

public class Program {

    private static final String info0="src/main/resources/information.json";

    private static final String info1="src/main/resources/info1.json";

    private static final String info2="src/main/resources/info2.json";

    public static void main(String[] args) throws IOException {
        //DataCleaningUtil.CleanBefore(info0,info1);
        DataCleaningUtil.CleanOne(info1,info2);
    }
}
