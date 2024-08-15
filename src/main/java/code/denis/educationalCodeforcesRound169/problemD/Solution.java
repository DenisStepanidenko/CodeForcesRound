package code.denis.educationalCodeforcesRound169.problemD;

import java.io.*;
import java.util.*;

public class Solution {

    static Reader input = new Reader();

    public static void main(String[] args) {
        int t = input.nextInt();
        PrintWriter out = new PrintWriter(System.out);

        while (t > 0) {
            int n = input.nextInt();
            int q = input.nextInt();
            String[] portals = new String[n];
            for (int i = 0; i < n; i++) {
                portals[i] = input.next();
            }

            List<List<Edge>> graph = buildGraph(n, portals);

            while (q > 0) {
                int start = input.nextInt();
                start--;
                int end = input.nextInt();
                end--;
                int result = dijkstra(graph, start, end);
                out.println(result);
                q--;
            }
            t--;
        }

        out.flush();
        out.close();
    }


    static int dijkstra(List<List<Edge>> graph, int start, int end) {
        int n = graph.size();
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        queue.add(new Edge(start, 0));

        while (!queue.isEmpty()) {
            Edge current = queue.poll();
            int currentCity = current.to;
            int currentDistance = current.weight;

            if (currentCity == end) {
                return currentDistance;
            }

            if (currentDistance > distances[currentCity]) {
                continue;
            }

            for (Edge neighbor : graph.get(currentCity)) {
                int newDistance = currentDistance + neighbor.weight;
                if (newDistance < distances[neighbor.to]) {
                    distances[neighbor.to] = newDistance;
                    queue.add(new Edge(neighbor.to, newDistance));
                }
            }
        }

        return -1; // Если путь не найден
    }


    static List<List<Edge>> buildGraph(int n, String[] portals) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (shareCommonPortal(portals[i], portals[j])) {
                    int weight = Math.abs(i - j);
                    graph.get(i).add(new Edge(j, weight));
                    graph.get(j).add(new Edge(i, weight));
                }
            }
        }

        return graph;
    }

    static boolean shareCommonPortal(String portal1, String portal2) {
        String[] p1 = portal1.split("");
        String[] p2 = portal2.split("");
        return p1[0].equals(p2[0]) || p1[0].equals(p2[1]) || p1[1].equals(p2[0]) || p1[1].equals(p2[1]);
    }


    static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Reader extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        // standard input

        public Reader() {
            this(System.in, System.out);
        }

        public Reader(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        // USACO-style file input

        public Reader(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName));
        }

        // returns null if no more input
        String nextLine() {
            String str = "";
            try {
                str = r.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    st = new StringTokenizer(r.readLine());
                }
                return st.nextToken();
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {

            return Long.parseLong(next());
        }
    }
}
