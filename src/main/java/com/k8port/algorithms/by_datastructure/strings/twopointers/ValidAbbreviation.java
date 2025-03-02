package com.k8port.algorithms.by_datastructure.strings.twopointers;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidAbbreviation {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidAbbreviation.class);

    public static boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;

        while (i < word.length() && j < abbr.length()) {
            char c = abbr.charAt(j);

            if (Character.isDigit(c)) {
                if (c == '0') {
                    // no leading zeros
                    return false;
                }
                int num = 0;
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    num = num * 10 + (abbr.charAt(j) - '0');
                    j++;
                }
                i += num;
            } else {
                if (i >= word.length() || word.charAt(i) != c) {
                    return false;
                }
                i++;
                j++;
            }
        }

        return i == word.length() && j == abbr.length();
    }

    public static void main(String[] args) {
        String[][] params = {
            {"internationalization", "i3iz4n"},
            {"helloworld", "4orworld"},
            {"minimum", "min2um"},
            {"subsequences", "3sequ3es"},
            {"computation", "compu03on"}         
        };

        for (String[] param : params) {
            boolean result = validWordAbbreviation(param[0], param[1]);
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("{}: {}", Arrays.toString(param), result);
            }
        }

        Predicate<String> lengther = (s) -> s.length() < 2;
        Predicate<String> equalizer = Predicate.isEqual("car");
        Function<Boolean, String> booleaner = i -> Boolean.toString(i);
        Function<String, Boolean> stringer = s -> Boolean.parseBoolean(s);

        System.out.println(stringer.compose(booleaner).apply(true));
    }
}
