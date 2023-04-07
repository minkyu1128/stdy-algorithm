package com.mk.stdyalgorithm.graph;

import java.util.*;

/**
 * 그래프
 * <pre>
 *     그래프는 "노드(N, node)"와 그 노드를 연결하는 "간선(E, edge)"을 하나로 모아 놓은 자료구조다.
 * </pre>
 */
public class Graph {
    protected int V;   // 노드의 개수

    /**
        adj = [
            0 : [],
            1 : [],
            2 : [],
            3 : [],
            ...
        ]
     */
    protected LinkedList<Integer> adj[]; // 인접 리스트

    /**
     * 생성자
     */
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) // 인접 리스트 초기화
            adj[i] = new LinkedList();
    }

    /**
     * 노드를 연결 v->w
     */
    void addEdge(int v, int w) {
        adj[v].add(w);
    }
}
