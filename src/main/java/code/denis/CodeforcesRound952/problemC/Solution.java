package code.denis.CodeforcesRound952.problemC;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int t = input.nextInt();
        PrintWriter out = new PrintWriter(System.out);
        while (t > 0) {
            int count = 0;
            int n = input.nextInt();
            long[] arr = new long[n];

            for (int i = 0; i < n; i++) {
                long x = input.nextLong();
                arr[i] = x;
            }

            long max = arr[0];
            long sum = 0;

            if (max - sum == 0) {
                count++;
            }

            for (int i = 1; i < arr.length; i++) {
                long currentNumber = arr[i];

                if(currentNumber > max){
                    sum += max;
                    max = currentNumber;
                }
                else{
                    sum += currentNumber;
                }


                if(max - sum == 0){
                    count++;
                }
            }
            out.println(count);
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
