package com.mk.stdyalgorithm.codingtest.netmarble;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Exam2 {
    @Test
    public void excute() {
        /* ==========================================================
        Question
        -------------------------------------------------------------
            m개의 적군기지를 점령하고자 할때 t(적군기지에 배치된 탱크 수)보다
            최소 1대가 많아야 점령이 가능하다고 가정할 때
            필요한 최소 탱크 수를 구하시오.
         ========================================================== */
        solution(Arrays.asList(3, 5, 2, 9, 8).stream().mapToInt(value -> value).toArray(), 3);  //result = 13
        solution(Arrays.asList(4, 2, 3, 1).stream().mapToInt(value -> value).toArray(), 2);    //result = 5
    }

    private int solution(int[] t, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < t.length; i++)
            list.add(t[i]);

        //적군 기지별 전차 수 오름차순 정렬
        AtomicInteger idx = new AtomicInteger();
        int answer = list.stream().sorted()
                .filter(v -> idx.get() < m)
                .peek(v -> idx.getAndIncrement())
                .reduce(Integer::sum).get();
        answer += m;    //적군 기지별 전차 + 1

//        System.out.println(list.stream().sorted().toString());
//        System.out.println(answer);
        return answer;
    }


}
