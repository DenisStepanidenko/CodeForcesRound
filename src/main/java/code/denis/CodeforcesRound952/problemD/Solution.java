package code.denis.CodeforcesRound952.problemD;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int t = input.nextInt();
        PrintWriter out = new PrintWriter(System.out);

        while (t > 0) {
            int n = input.nextInt();
            int m = input.nextInt();

            String[] field = new String[n];
            for (int i = 0; i < n; i++) {
                String currentRow = input.nextLine();
                field[i] = currentRow;
            }

            int x1 = 0, y1 = 0, x2 = 0, y2 = 0;

            for (int i = 0; i < field.length; i++) {
                String currentRow = field[i];
                int index = currentRow.indexOf('#');
                if (index == -1) continue;
                x1 = index + 1;
                y1 = i + 1;
            }

            for (int i = field.length - 1; i >= 0; i--) {
                String currentRow = field[i];
                int index = currentRow.indexOf('#');
                if (index == -1) continue;
                x2 = index + 1;
                y2 = i + 1;
            }
            out.println((y1 + y2) / 2 + " " + (x1 + x2) / 2);
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
