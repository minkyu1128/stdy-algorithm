package com.mk.stdyalgorithm.graph;

import java.util.Iterator;

/**
 * 깊이 우선 탐색
 * Depth-First Search
 */
/* ==============================================================
* 슈도코드(pseudocode)
* ---------------------------------------------------------------
* void search(Node root) {
*     if (root == null) return;
*     // 1. root 노드 방문
*     visit(root);
*     root.visited = true; // 1-1. 방문한 노드를 표시
*     // 2. root 노드와 인접한 정점을 모두 방문
*     for each (Node n in root.adjacent) {
*         if (n.visited == false) { // 4. 방문하지 않은 정점을 찾는다.
*             search(n); // 3. root 노드와 인접한 정점 정점을 시작 정점으로 DFS를 시작
*         }
*     }
* }
*
============================================================== */
public class Dfs extends Graph {
    /**
     * 생성자
     *
     * @param v
     */
    Dfs(int v) {
        super(v);
    }


    /**
     * DFS에 의해 사용되는 함수
     */
    void DFSUtil(int v, boolean visited[]) {
        // 현재 노드를 방문한 것으로 표시하고 값을 출력
        visited[v] = true;
        System.out.print(v + " ");

        // 방문한 노드와 인접한 모든 노드를 가져온다.
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            // 방문하지 않은 노드면 해당 노드를 시작 노드로 다시 DFSUtil 호출
            if (!visited[n])
                DFSUtil(n, visited); // 순환 호출
        }
    }

    /**
     * 주어진 노드를 시작 노드로 DFS 탐색
     */
    void DFS(int v) {
        // 노드의 방문 여부 판단 (초깃값: false)
        boolean visited[] = new boolean[V];

        // v를 시작 노드로 DFSUtil 순환 호출
        DFSUtil(v, visited);
    }

    /**
     * DFS 탐색
     */
    void DFS() {
        // 노드의 방문 여부 판단 (초깃값: false)
        boolean visited[] = new boolean[V];

        // 비연결형 그래프의 경우, 모든 정점을 하나씩 방문
        for (int i = 0; i < V; ++i) {
            if (visited[i] == false)
                DFSUtil(i, visited);
        }
    }
}
