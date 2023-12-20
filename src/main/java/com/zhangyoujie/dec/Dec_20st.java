package com.zhangyoujie.dec;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangyoujie
 * @date 2023/12/20
 */
public class Dec_20st {


    public boolean isAcronym(List<String> words, String s) {
        return words.stream()
                .map(item -> String.valueOf(item.charAt(0)))
                .collect(Collectors.joining()).equals(s);

    }
}
