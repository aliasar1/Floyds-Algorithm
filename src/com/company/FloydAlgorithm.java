package com.company;

public class FloydAlgorithm {

    final static int INF = 99999, V = 4;

    public void shortestPath(int[][] graph){
        int [][]distance = new int[V][V];
        int i,j,k;

        for(i=0; i<V; i++){
            for (j=0; j<V; j++){
                distance[i][j] = graph[i][j];
            }
        }

        for (k=0; k<V; k++){
            for (i=0; i<V; i++){
                for (j=0; j<V; j++){
                    if (distance[i][k] + distance[k][j] < distance[i][j]){
                        // if true update value
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }
        // Checking for negative edge weight cycle
        for (i=0; i<V;i++){
            if (distance[i][i] < 0){
                System.out.println("Negative edge weight cycle is present!");
                return;
            }
        }
        print(distance);
    }

    public void print(int [][]distance){
        System.out.println("The shortest distance between every pair of vertices: ");
        for (int i=0; i<V; i++) {
            for (int j = 0; j<V; j++) {
                if (distance[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(distance[i][j] + " ");
//                if (distance[i][j] == INF){
//                    System.out.print("INF");
//                }
//                else {
//                    System.out.print(distance[i][j] + " ");
//                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] graph = {   {0, 3, INF, 7},
                            {8, 0, 2, INF},
                            {5, INF, 0, 1},
                            {2, INF, INF, 0}
                        };
        FloydAlgorithm fa = new FloydAlgorithm();
        fa.shortestPath(graph);
    }
}
