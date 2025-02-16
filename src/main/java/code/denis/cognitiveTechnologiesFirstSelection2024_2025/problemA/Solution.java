package code.denis.cognitiveTechnologiesFirstSelection2024_2025.problemA;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int t = input.nextInt();
        StringBuilder ans = new StringBuilder();
        while (t > 0) {
            int n = input.nextInt();
            int m = input.nextInt();
            ans.append(solve(n, m)).append('\n');
            t--;
        }
        System.out.println(ans);
    }

    private static String solve(int n, int m) {
        StringBuilder ans = new StringBuilder();

        if (n > m) {
            ans.append("-1");
            return ans.toString();
        } else {
            while (true) {
                if (m % n == 0) {
                    int number = m / n;
                    for (int j = 0; j < n; j++) {
                        ans.append(number).append(" ");
                    }
                    return ans.toString();
                }
                ans.append(1).append(" ");
                m--;
                n--;
            }
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
