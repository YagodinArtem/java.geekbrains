package ru.geekbrains.algorithms.lesson7;

public class Main {

    /**
     * 1. Реализовать программу, в которой задается граф из 10 вершин.
     * Задать ребра и найти кратчайший путь с помощью поиска в ширину.
     * @param args *
     */
    public static void main(String[] args) {
        Graph graph = new Graph(10);

        graph.addEdge(1,2);
        graph.addEdge(0,4);
        graph.addEdge(1,4);
        graph.addEdge(3,4);
        graph.addEdge(7,8);
        graph.addEdge(1,3);
        graph.addEdge(9,1);
        graph.addEdge(9,3);
        graph.addEdge(9,7);

        BreadthFirstPath bfp = new BreadthFirstPath(graph, 1);

        System.out.println(bfp.shortestPathFromTo(0,8, graph));


    }
}
