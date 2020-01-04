package com.sample.question.graph;

import java.util.*;

public class Graph {


    private Integer vertices;
    List<LinkedList<Integer>>adjencyList = new ArrayList<LinkedList<Integer>>();

    public Graph(int noOfVertices) {
     this.vertices = noOfVertices;
     for(int i=0;i< noOfVertices;i++){
         adjencyList.add(new LinkedList<>());
     }

    }

    public void addEdges(int start, int end){
      adjencyList.get(start).add(end);
      adjencyList.get(end).add(start);
    }



    public Integer getVertices() {
        return vertices;
    }

    public void setVertices(Integer vertices) {
        this.vertices = vertices;
    }


    public List<LinkedList<Integer>> getAdjencyList() {
        return adjencyList;
    }

    public void setAdjencyList(List<LinkedList<Integer>> adjencyList) {
        this.adjencyList = adjencyList;
    }

    public void printGraph(Graph graph){

        for (int v=0;v<graph.getVertices(); v++){
            System.out.println("Adjacency list of vertex "+ v);
            System.out.print("head");
            for(Integer pCrawl: graph.getAdjencyList().get(v)){
                System.out.print(" -> "+pCrawl);
            }
            System.out.println("\n");
        }
    }


    public static void main(String[] args) {
  // create the graph given in above figure
            int V = 5;
            Graph graph = new Graph(V);
            graph.addEdges( 0, 1);
            graph.addEdges(0, 4);
            graph.addEdges( 1, 2);
            graph.addEdges( 1, 3);
            graph.addEdges( 1, 4);
            graph.addEdges( 2, 3);
            graph.addEdges( 3, 4);

            // print the adjacency list representation of
            // the above graph
            graph.printGraph(graph);
        }

}
