package code.denis.educationalCodeforcesRound169.problemB;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int t = input.nextInt();
        PrintWriter out = new PrintWriter(System.out);
        while (t > 0) {
            int l = input.nextInt();
            int r = input.nextInt();

            int L = input.nextInt();
            int R = input.nextInt();

            int maxLeft = Math.max(l, L);
            int minRight = Math.min(r, R);


            if (r < L || R < l) {
                out.println(1);
            } else if (r == L) {
                out.println(2);
            } else if (l == L && r == R) {
                out.println(r - l);
            } else {
                int ans = minRight - maxLeft;

                if (maxLeft - Math.min(l, L) > 0) ans++;
                if (Math.max(r, R) - minRight > 0) ans++;
                out.println(ans);
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
