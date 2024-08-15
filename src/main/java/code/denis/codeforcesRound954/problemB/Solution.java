package code.denis.codeforcesRound954.problemB;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int t = input.nextInt();
        PrintWriter out = new PrintWriter(System.out);
        while (t > 0) {
            int n = input.nextInt();
            int m = input.nextInt();
            int[][] arr = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int x = input.nextInt();
                    arr[i][j] = x;
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    List<Integer> numbers = new ArrayList<>();

                    if ((i + 1) < n) {
                        numbers.add(arr[i + 1][j]);
                    }

                    if ((i - 1) >= 0) {
                        numbers.add(arr[i - 1][j]);
                    }

                    if ((j - 1) >= 0) {
                        numbers.add(arr[i][j - 1]);
                    }

                    if ((j + 1) < m) {
                        numbers.add(arr[i][j + 1]);
                    }

                    Collections.sort(numbers);

                    int max = numbers.get(numbers.size() - 1);

                    if (max >= arr[i][j]) continue;
                    else {
                        arr[i][j] = max;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    out.print(arr[i][j] + " ");
                }
                out.println();
            }

            t--;
        }

        out.flush();
        out.close();
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
