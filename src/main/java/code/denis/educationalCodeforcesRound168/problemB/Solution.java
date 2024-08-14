package code.denis.educationalCodeforcesRound168.problemB;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int t = input.nextInt();
        StringBuilder answer = new StringBuilder();
        while (t > 0) {
            int n = input.nextInt();
            String s1 = input.nextLine();
            String s2 = input.nextLine();
            answer.append(solve(s1, s2)).append("\n");
            t--;
        }

        System.out.println(answer);
    }

    private static int solve(String s1, String s2) {
        int sum = 0;

        for (int i = 1; i < s2.length() - 1; i++) {
            if (s1.charAt(i) == '.' && s1.charAt(i - 1) == '.' && s1.charAt(i + 1) == '.' && s2.charAt(i) == '.' && s2.charAt(i - 1) == 'x' && s2.charAt(i + 1) == 'x') {
                sum++;
            }
        }

        for (int i = 1; i < s2.length() - 1; i++) {
            if (s2.charAt(i) == '.' && s2.charAt(i - 1) == '.' && s2.charAt(i + 1) == '.' && s1.charAt(i) == '.' && s1.charAt(i - 1) == 'x' && s1.charAt(i + 1) == 'x') {
                sum++;
            }
        }
        return sum;
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
