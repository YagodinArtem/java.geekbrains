package ru.geekbrains.algorithms.lesson7;

import java.util.LinkedList;

public class BreadthFirstPath {
    private boolean[] marked;
    private int[] edgeTo;
    private int source;

    public BreadthFirstPath(Graph g, int source) {
        this.source = source;
        marked = new boolean[g.getVertexCount()];
        edgeTo = new int[g.getVertexCount()];
        bfs(g, source);
    }

    private void bfs(Graph g, int source) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(source);
        marked[source] = true;

        while (!queue.isEmpty()){
            int vertex = queue.removeFirst();
            for (int w : g.getAdjList(vertex)) {
                if(!marked[w]){
                    marked[w] = true;
                    edgeTo[w] = vertex;
                    queue.addLast(w);
                }
            }
        }
    }


    public boolean hasPathTo(int v) {
        return marked[v];
    }

    /**
     * lesson7 homework
     * @param from откуда начинаем идти (Source)
     * @param to к какому элементу ищем путь
     * @param g Graph
     * @return LinkedList<Integer> stack если путь не найден то return null;
     */
    public LinkedList<Integer> shortestPathFromTo(int from, int to, Graph g) {
        return new BreadthFirstPath(g, from).pathTo(to);
    }

    public LinkedList<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int vertex = v;

        while (vertex != source){
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }
        return stack;
    }
}
