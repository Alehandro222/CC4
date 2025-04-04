package CC4;
import java.util.*;
public class CC4_Graph {
    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    class Subset {
        int parent, rank;
    }

    public class KruskalMST {

        static int V; // number of vertices
        static List<Edge> edges = new ArrayList<>();

        static int find(Subset subsets[], int i) {
            if (subsets[i].parent != i)
                subsets[i].parent = find(subsets, subsets[i].parent);
            return subsets[i].parent;
        }

        static void union(Subset subsets[], int x, int y) {
            int xroot = find(subsets, x);
            int yroot = find(subsets, y);

            if (subsets[xroot].rank < subsets[yroot].rank)
                subsets[xroot].parent = yroot;
            else if (subsets[xroot].rank > subsets[yroot].rank)
                subsets[yroot].parent = xroot;
            else {
                subsets[yroot].parent = xroot;
                subsets[xroot].rank++;
            }
        }

        void kruskalMST() {
            Edge[] result = new Edge[V - 1];
            int e = 0;
            int i = 0;

            Collections.sort(edges);

            Subset[] subsets = new Subset[V];
            for (i = 0; i < V; ++i) {
                subsets[i] = new Subset();
                subsets[i].parent = i;
                subsets[i].rank = 0;
            }

            i = 0;
            while (e < V - 1 && i < edges.size()) {
                Edge next_edge = edges.get(i++);

                int x = find(subsets, next_edge.src);
                int y = find(subsets, next_edge.dest);

                if (x != y) {
                    result[e++] = next_edge;
                    union(subsets, x, y);
                }
            }

            System.out.println("Edges in the Minimum Cost Spanning Tree:");
            int minimumCost = 0;
            for (i = 0; i < e; ++i) {
                System.out.println(result[i].src + " - " + result[i].dest + " = " + result[i].weight);
                minimumCost += result[i].weight;
            }
            System.out.println("Minimum Cost: " + minimumCost);
        }

        public void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            do {
                edges.clear();
                System.out.print("Enter number of vertices: ");
                V = sc.nextInt();

                int[][] adjMatrix = new int[V][V];

                System.out.println("Enter adjacency matrix (0 if no edge):");
                for (int i = 0; i < V; i++) {
                    for (int j = 0; j < V; j++) {
                        adjMatrix[i][j] = sc.nextInt();
                        if (j > i && adjMatrix[i][j] != 0) {
                            Edge edge = new Edge();
                            edge.src = i;
                            edge.dest = j;
                            edge.weight = adjMatrix[i][j];
                            edges.add(edge);
                        }
                    }
                }

                System.out.println("Adjacency Matrix:");
                for (int i = 0; i < V; i++) {
                    for (int j = 0; j < V; j++) {
                        System.out.print(adjMatrix[i][j] + " ");
                    }
                    System.out.println();
                }

                kruskalMST();

                System.out.print("Try again? (y/n): ");
            } while (sc.next().equalsIgnoreCase("y"));
        }
    }
}
