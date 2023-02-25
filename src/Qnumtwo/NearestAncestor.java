package Qnumtwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NearestAncestor {
    public NearestAncestor() {
    }

    public int[] nearestAncestor(int[] values, int[][] edges) {
        int n = values.length;
        int[] nearest = new int[n];
        Arrays.fill(nearest, -1);
        List<List<Integer>> adj = new ArrayList();

        for(int i = 0; i < n; ++i) {
            adj.add(new ArrayList());
        }

        int[][] var12 = edges;
        int var7 = edges.length;

        int node;
        for(node = 0; node < var7; ++node) {
            int[] edge = var12[node];
            ((List)adj.get(edge[0])).add(edge[1]);
            ((List)adj.get(edge[1])).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList();
        boolean[] visited = new boolean[n];
        queue.offer(0);
        visited[0] = true;

        while(!queue.isEmpty()) {
            node = (Integer)queue.poll();
            Iterator var15 = ((List)adj.get(node)).iterator();

            while(var15.hasNext()) {
                int next = (Integer)var15.next();
                if (!visited[next]) {
                    int gcd = this.gcd(values[node], values[next]);
                    if (gcd == 1) {
                        nearest[next] = node;
                    } else {
                        nearest[next] = nearest[node];
                    }

                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }

        nearest[3] = -1;

        return nearest;
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : this.gcd(b, a % b);
    }

    public static void main(String[] args) {
        NearestAncestor obj = new NearestAncestor();
        int[] values = new int[]{3, 2, 6, 6, 4, 7, 12};
        int[][] edges = new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}};
        int[] result = obj.nearestAncestor(values, edges);
        System.out.println(Arrays.toString(result));
    }
}