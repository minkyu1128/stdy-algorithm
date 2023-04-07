package com.mk.stdyalgorithm.graph;

public class Excutor {
    public static void bfs() {
        //노드 생성
        Bfs graph = new Bfs(4);

        //간선 연결
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        //탐색
        graph.BFS(2);   //2번째 노드를 시작으로 BFS 탐색
    }
    public static void dfs() {
        //노드 생성
        Dfs graph = new Dfs(4);

        //간선 연결
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        //탐색
        graph.DFS(2);   //2번째 노드를 시작으로 BFS 탐색
        graph.DFS();   //비연결 그래프인 경우 탐색
    }
}
