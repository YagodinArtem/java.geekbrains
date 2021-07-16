package ru.geekbrains.algorithms.lesson7;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    private int vertexCount;
    private int edgeCount;
    private LinkedList<Integer>[] adjList;

    public Graph(int vertexCount) {
        if (vertexCount <= 0) {
            throw new IllegalArgumentException("vertexCount:" + vertexCount);
        }
        this.vertexCount = vertexCount;
        adjList = new LinkedList[vertexCount];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public int getEdgeCount() {
        return edgeCount;
    }

    public List<Integer> getAdjList(int vertex) {
        return Collections.unmodifiableList(adjList[vertex]);
    }

    public void addEdge(int v1, int v2) {
        if (v1 < 0 || v2 < 0 || v1 >= vertexCount || v2 >= vertexCount) {
            throw new IllegalArgumentException();
        }
        adjList[v1].add(v2);
        if (v1 == v2) {
            return;
        }
        adjList[v2].add(v1);
    }

}
