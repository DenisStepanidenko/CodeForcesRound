package code.denis.codeforcesRound954.problemA;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int t = input.nextInt();
        PrintWriter out = new PrintWriter(System.out);
        while (t > 0) {
            int x1 = input.nextInt();
            int x2 = input.nextInt();
            int x3 = input.nextInt();


            int[] arr = new int[3];
            arr[0] = x1;
            arr[1] = x2;
            arr[2] = x3;
            Arrays.sort(arr);

            int min = Integer.MAX_VALUE;


            for (int a = arr[0]; a <= arr[2]; a++) {
                int currentAns = Math.abs(x1 - a) + Math.abs(x2 - a) + Math.abs(x3 - a);
                min = Math.min(min, currentAns);
            }

            out.println(min);
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
