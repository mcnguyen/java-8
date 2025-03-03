package com.learnJava.defaults;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by z001qgd on 7/31/18.
 */
public interface Multiplier {

    // can NOT be overwritten
    static boolean isEmpty(List<Integer> integerList) {
//        return integerList != null && integerList.size() == 0;
        return integerList == null || integerList.size() == 0;
    }

    int multiply(List<Integer> integerList);

    // can be overwritten
    default int size(List<Integer> integerList) {
        System.out.println("Inside interface");
        return integerList.size();
    }
};
