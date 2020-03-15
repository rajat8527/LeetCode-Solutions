package com.leetcode.solutions.strings;

import java.util.*;

class Decompress {
    private int count;
    List<Decompress> decompressList;
    private char c;

    public Decompress(int num) {
        count = num;
        decompressList = new ArrayList<>();
    }

    public Decompress(char ch) {
        c = ch;
    }

    public String returnOutputStr() {
        StringBuilder result = new StringBuilder();
        if (decompressList != null) {
            for (int i = 0; i < count; i++) {
                for (Decompress decompress : decompressList) {
                    result.append(decompress.returnOutputStr());
                }
            }
        } else {
            result.append(c);
        }
        return result.toString();
    }
}

public class DecompressString {
    private static String decompressString(String s) {
        Deque<Decompress> deque = new LinkedList<>();
        Decompress d1 = new Decompress(1);
        deque.push(d1);

        StringBuilder input = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                input.append(c);
            } else if (c == '[') {
                if (input.length() == 0)
                    continue;

                int value = Integer.parseInt(input.toString());
                input = new StringBuilder();
                Decompress d2 = new Decompress(value);
                deque.push(d2);
            } else if (c == ']') {
                Decompress d3 = deque.pop();
                Objects.requireNonNull(deque.peek()).decompressList.add(d3);
            } else {
                Objects.requireNonNull(deque.peek()).decompressList.add(new Decompress(c));
            }
        }

        Decompress response = deque.pop();
        return response.returnOutputStr();
    }

    public static void main(String[] args) {
        System.out.println(decompressString("3[a]2[bc]"));
        System.out.println(decompressString("3[a2[c]]"));
        System.out.println(decompressString("2[abc]3[cd]ef"));
    }
}
