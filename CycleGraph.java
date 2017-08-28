package kanthed;
import java.io.*;
import java.util.*;

//Directed graph using adjacency
public class CycleGraph
{
 private int V;   // No. of vertices
 private LinkedList<Integer> adj[]; //Adjacency List

 public CycleGraph(int v)
 {
     V = v;
     adj = new LinkedList[v];
     for (int i=0; i<v; ++i)
         adj[i] = new LinkedList();
 }

 // Edge into the graph
 public void addEdge(int v,int w)
 {
     adj[v].add(w);
     adj[w].add(v);
 }

 // Function that uses visited[] reachable from vertex v.
 public Boolean isRechable(int v, Boolean visited[], int parent)
 {
     // Visited Node
     visited[v] = true;
     Integer i;

     // Vertices adjacent to the vertex
     Iterator<Integer> it = adj[v].iterator();
     while (it.hasNext())
     {
         i = it.next();

         // If an adjacent is not visited, then recur for
         // that adjacent
         if (!visited[i])
         {
             if (isRechable(i, visited, v))
                 return true;
         }

         // If an adjacent is visited
         else if (i != parent)
            return true;
     }
     return false;
 }

 // Returns true if the graph is connected.
  public Boolean connected()
 {
     // Mark as not visited
     Boolean visited[] = new Boolean[V];
     for (int i = 0; i < V; i++)
         visited[i] = false;

     // Marks all vertices connected from 0.
     if (isRechable(0, visited, -1))
         return false;

     // Vertex if not reachable from 0, return false
     for (int u = 0; u < V; u++)
         if (!visited[u])
             return false;

     return true;
 }
}