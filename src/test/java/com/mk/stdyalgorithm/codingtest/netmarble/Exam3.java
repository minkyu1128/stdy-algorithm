package com.mk.stdyalgorithm.codingtest.netmarble;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Exam3 {
    @Test
    public void excute() {
        /* ==========================================================
        Question
        -------------------------------------------------------------
            신규ID목록(additional)에 작성된 ID를 시스템에 등록하려고 한다.
            이때 기등록ID(teamIDs)와 중복 작성된 ID를 제외하여  
            등록 해야하는 ID를 구하시오.
         ========================================================== */
        String[] teamIds = Arrays.asList("world", "prog").toArray(new String[2]);
        String[] additional = Arrays.asList("hello", "world", "code", "hello", "try", "code").toArray(new String[6]);
        solution(teamIds, additional);  // result = ["hello","code","try"]


        String[] teamIds2 = Arrays.asList("abc", "hq", "xyz").toArray(new String[2]);
        String[] additional2 = Arrays.asList("hq", "abc", "pp", "xy", "pp", "hq").toArray(new String[6]);
        solution(teamIds2, additional2); // result = ["pp", "xy"]
    }

    private String[] solution(String[] teamIDs, String[] additional) {
        //신규ID 중복제거
        Set<String> generator = new LinkedHashSet<>();
        for (int i = 0; i < additional.length; i++)
            generator.add(additional[i]);
        //기등록ID 제거
        for (int i = 0; i < teamIDs.length; i++)
            generator.remove(teamIDs[i]);

//        System.out.println(generator.toString());

        String[] answer = generator.stream().toArray(String[]::new);
        return answer;
    }


}
