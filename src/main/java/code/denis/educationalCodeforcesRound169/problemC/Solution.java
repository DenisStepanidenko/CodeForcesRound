package code.denis.educationalCodeforcesRound169.problemC;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        int t = input.nextInt();

        while (t > 0) {
            int n = input.nextInt();
            long k = input.nextLong();

            long[] arr = new long[n];

            for (int i = 0; i < n; i++) {
                long x = input.nextLong();
                arr[i] = x;
            }

            Arrays.sort(arr);
            long sumAlice = 0;
            long sumBob = 0;
            int var = 1;
            for (int i = arr.length - 1; i >= 0; i--) {
                if (var == 1) {
                    sumAlice += arr[i];
                    var--;
                    continue;
                }

                if (var == 0) {
                    long diff = arr[i + 1] - arr[i];

                    if (diff <= k) {
                        arr[i] += diff;
                        k -= diff;
                    } else {
                        arr[i] += k;
                        k = 0;
                    }

                    sumBob += arr[i];
                    var++;
                }

            }

            out.println(sumAlice - sumBob);
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
