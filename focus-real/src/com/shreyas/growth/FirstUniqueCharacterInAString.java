package com.shreyas.growth;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        int index = FirstUniqueCharacterInAString.firstUniqChar("leetcode");
        if (0 == index) {
            System.out.println("Pass");
        } else {
            System.out.println("Retry");
        }
    }

    public static int firstUniqChar(String s) {
        Map<Character, Integer> unique = new LinkedHashMap<>();
        Set<Character> nonUnique = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (nonUnique.contains(c)) {
                continue;
            }
            if (unique.containsKey(c)) {
                unique.remove(c);
                nonUnique.add(c);
            } else {
                unique.put(c, i);
            }
        }
        if (unique.isEmpty()) {
            return -1;
        } else {

            return unique.entrySet().stream().findFirst().get().getValue();
        }
    }
}
