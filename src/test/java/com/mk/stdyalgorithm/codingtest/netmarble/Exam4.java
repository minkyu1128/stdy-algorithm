package com.mk.stdyalgorithm.codingtest.netmarble;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.Map.Entry;

public class Exam4 {
    @Test
    public void excute() {
        /* ==========================================================
        Question
        -------------------------------------------------------------
            배열(numbers)에 저장된 자연수 원소 중 과반수를 차지하는 원소를
            구하고 과반수에 해당 하는 원소가 없을 경우 -1을 리턴 하시오.
         ========================================================== */
        solution(Arrays.asList(6, 1, 6, 6, 7, 6, 6, 7).stream().mapToInt(value -> value).toArray());    //result = 6
        solution(Arrays.asList(6, 1, 6, 6, 7, 5, 6, 7).stream().mapToInt(value -> value).toArray());    //result = -1
    }

    private int solution(int[] numbers) {
        //value 누적
        Map<Integer, Integer> dupl = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            dupl.put(numbers[i], dupl.getOrDefault(numbers[i], 0) + 1);
        }


        //Comparator 정의
        Comparator<Entry<Integer, Integer>> comparator = new Comparator<Entry<Integer, Integer>>() {
            @Override
            public int compare(Entry<Integer, Integer> e1, Entry<Integer, Integer> e2) {
                return e1.getValue().compareTo(e2.getValue());
            }
        };

        //get MaxValue Entry
        Entry<Integer, Integer> maxEntry = Collections.max(dupl.entrySet(), comparator);


//        System.out.println(dupl.toString());
//        System.out.println(maxEntry);
//        Integer maxValue = Collections.max(dupl.values());
//        System.out.println(maxValue);
        return maxEntry.getValue() > numbers.length / 2 ? maxEntry.getKey() : -1;
    }


}
