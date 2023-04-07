package com.mk.stdyalgorithm.graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 너비 우선 탐색
 * Breadth-First Search
 */
/* ==============================================================
* 슈도코드(pseudocode)
* ---------------------------------------------------------------
*  void search(Node root) {
*      Queue queue = new Queue();
*      root.marked = true; // (방문한 노드 체크)
*      queue.enqueue(root); // 1-1. 큐의 끝에 추가
*
*      // 3. 큐가 소진될 때까지 계속한다.
*      while (!queue.isEmpty()) {
*          Node r = queue.dequeue(); // 큐의 앞에서 노드 추출
*          visit(r); // 2-1. 큐에서 추출한 노드 방문
*          // 2-2. 큐에서 꺼낸 노드와 인접한 노드들을 모두 차례로 방문한다.
*          foreach(Node n in r.adjacent) {
*              if (n.marked == false) {
*                  n.marked = true; // (방문한 노드 체크)
*                  queue.enqueue(n); // 2-3. 큐의 끝에 추가
*              }
*          }
*       }
*   }
============================================================== */

public class Bfs extends Graph {

    /**
     * 생성자
     *
     * @param v
     */
    Bfs(int v) {
        super(v);
    }

    /**
     * s를 시작 노드으로 한 BFS로 탐색하면서 탐색한 노드들을 출력
     */
    void BFS(int s) {
        // 노드의 방문 여부 판단 (초깃값: false)
        boolean visited[] = new boolean[V];
        // BFS 구현을 위한 큐(Queue) 생성
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // 현재 노드를 방문한 것으로 표시하고 큐에 삽입(enqueue)
        visited[s] = true;
        queue.add(s);

        // 큐(Queue)가 빌 때까지 반복
        while (queue.size() != 0) {
            // 방문한 노드를 큐에서 추출(dequeue)하고 값을 출력
            s = queue.poll();
            System.out.print(s + " ");

            // 방문한 노드와 인접한 모든 노드를 가져온다.
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                // 방문하지 않은 노드면 방문한 것으로 표시하고 큐에 삽입(enqueue)
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

}
