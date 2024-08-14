package code.denis.CodeforcesRound952.problemE;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        int t = input.nextInt();
        while (t > 0) {
            long x = input.nextLong();
            long y = input.nextLong();
            long z = input.nextLong();
            long k = input.nextLong();

            long result = solve(x, y, z, k);
            out.println(result);
            t--;
        }

        out.flush();
        out.close();
    }

    private static long solve(long x, long y, long z, long k) {
        // нужно перебирать все a,b
        long answer = 0;

        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                // теперь нужно найти значение c

                double c = ((double) k / (i * j));

                // нужно проверить ограниченя на c
                if (c > z) continue;
                if (c != (int) c) continue;

                long xNew = i;
                long yNew = j;
                long zNew = (long) c;


                long newAnswer = (x - xNew + 1) * (y - yNew + 1) * (z - zNew + 1);
                answer = Math.max(answer, newAnswer);
            }
        }

        return answer;
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
