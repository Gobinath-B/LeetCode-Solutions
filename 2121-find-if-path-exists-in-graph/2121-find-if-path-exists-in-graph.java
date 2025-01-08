import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Create an adjacency list using an array of lists
        List<Integer>[] graph = new ArrayList[n];
        
        // Initialize the array of lists
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // Build the graph using the edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u); // Since the graph is undirected
        }
        
        // Create a visited array to keep track of visited nodes
        boolean[] visited = new boolean[n];
        
        // Perform DFS from the source node
        return dfs(source, destination, graph, visited);
    }
    
    private boolean dfs(int node, int destination, List<Integer>[] graph, boolean[] visited) {
        // Base case: If we've reached the destination
        if (node == destination) {
            return true;
        }
        
        // Mark the current node as visited
        visited[node] = true;
        
        // Explore all the neighbors of the current node
        for (int neighbor : graph[node]) {
            // If the neighbor hasn't been visited, perform DFS on it
            if (!visited[neighbor]) {
                if (dfs(neighbor, destination, graph, visited)) {
                    return true; // If a path is found, return true
                }
            }
        }
        
        // If no valid path is found, return false
        return false;
    }
}
