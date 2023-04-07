package com.mk.stdyalgorithm.codingtest.netmarble;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Exam1 {
    @Test
    public void excute() {
        /* ==========================================================
        Question
        -------------------------------------------------------------
            0: 신입생, 1: 재학생 이고
            student(전체학생) 중 k(재학생 수)가 포함된 하나의 그룹만 만들어야 할때
            경우의 수를 구하시오.
         ========================================================== */
        solution(Arrays.asList(0, 1, 0, 0).stream().mapToInt(v -> v).toArray(), 1); //result = 6
        solution(Arrays.asList(0, 1, 0, 0, 1, 1, 0).stream().mapToInt(v -> v).toArray(), 2);    //result = 8
        solution(Arrays.asList(0, 1, 0).stream().mapToInt(v -> v).toArray(), 2);    //result = 0

    }


    private int n; // nPr의 n
    private int r; // nPr의 r
    private ArrayList<Integer> itemList;
    private int[] res;

    private int solution(int[] student, int k) {
        this.r = k;             // nPr의 r
        this.n = student.length; // nPr의 n
        this.res = new int[r];  // 결과값 배열

        // 아이템이 들어갈 리스트
        itemList = new ArrayList<Integer>();
        for (int item : student)
            itemList.add(item);

        System.out.println(res.length);
        return res.length;

//
//        //재학생 위치 저장
//        List<Integer> old = new ArrayList<>();
//        for (int i = 0; i < student.length; i++)
//            if (student[i] == 1) old.add(i);
//
//        //그룹
//        Set<String> groups = new HashSet<>();
//
//        //탐색
//        for (int i = 0; i < old.size(); i++)
//            search(old, i, student, k, groups);
//
//        return groups.size() == 0 ? -1 : groups.size();
    }


    private void perm(int depth) {
        perm(itemList, 0);
    }

    private void perm(ArrayList<Integer> itemList, int depth) {

        // depth가 0부터 시작했을 경우 depth == r에서 리턴
        if (depth == r) {
            System.out.println(Arrays.toString(res));
            return;
        }

        for (int i = 0; i < n - depth; i++) {
            res[depth] = itemList.remove(i); // 아이템 선택 + 리스트에서 제거
            perm(itemList, depth + 1); // 재귀호출
            itemList.add(i, res[depth]);     // 제거된 아이템 복원
        }
    }

}
