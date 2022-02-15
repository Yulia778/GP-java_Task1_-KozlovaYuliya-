public class Dijkstra {

    public static void dijkstra(int[][] graph, int initialVertex){
        int vertexCount = graph.length;
        boolean[] visitedVertex = new boolean[vertexCount];
        int[] distance = new int[vertexCount];
        for (int i = 0; i < vertexCount; i++){
            visitedVertex[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }
        distance[initialVertex] = 0;
        for (int i = 0; i < vertexCount; i++){
            int u = findMaxDistance(distance, visitedVertex);
            visitedVertex[u] = true;
            for (int v =0 ; v < vertexCount; v++){
                if(!visitedVertex[v] && graph[u][v] != 0 && (distance[u] + graph[u][v] < distance[v])){
                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }
        for (int i = 0; i < distance.length; i++){
            System.out.println(String.format("Distance from initial vertex %s to vertex %s is %s", initialVertex, i, distance[i]));
        }

    }

    private static int findMaxDistance(int[] distance, boolean[] visitedVertex) {
        int maxDistance = Integer.MAX_VALUE;
        int maxDistanceVertex = -1;
        for (int i =0; i < distance.length; i++){
            //the vertex should not be visited and the distance should be the minimum.
            //this is similar to finding the min element of an array
            if(!visitedVertex[i] && distance[i] < maxDistance){
                maxDistance = Math.max(distance[i],maxDistance);
                maxDistanceVertex = i;
            }
        }
        return maxDistanceVertex;
    }

    public static void main(String[] args) {
        int graph[][] = new int[][] { {1, 3, 3},
                {2, 1, 4},
                {0, 6, 4}
        };
        Dijkstra t = new Dijkstra();
        t.dijkstra(graph, 2);
    }
}

