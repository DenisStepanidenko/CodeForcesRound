package code.denis.CodeforcesRound1003Div4.problemC;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    static Reader input = new Reader();

    public static void main(String[] args) {
        int t = input.nextInt();

        while (t > 0) {
            int n = input.nextInt();
            int m = input.nextInt();

            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                int x = input.nextInt();
                a[i] = x;
            }

            int[] b = new int[m];

            for (int i = 0; i < m; i++) {
                int x = input.nextInt();
                b[i] = x;
            }

            if (n == 1) {
                System.out.println("YES");
            } else {
                a[0] = Math.min(a[0], b[0] - a[0]);

                String ans = "YES";

                for (int i = 1; i < n; i++) {

                    if (Math.min(a[i], b[0] - a[i]) >= a[i - 1]) {
                        a[i] = Math.min(a[i], b[0] - a[i]);
                    } else if (Math.max(a[i], b[0] - a[i]) >= a[i - 1]) {
                        a[i] = Math.max(a[i], b[0] - a[i]);
                    } else {
                        ans = "NO";
                        break;
                    }
                }

                System.out.println(ans);
            }

            t--;
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
