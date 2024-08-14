package code.denis.educationalCodeforcesRound168.problemA;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {

        int t = input.nextInt();
        StringBuilder answer = new StringBuilder();
        while (t > 0) {
            String s = input.nextLine();
            answer.append(solve(s)).append("\n");
            t--;
        }

        System.out.println(answer);
    }

    private static String solve(String s) {
        int left = 0;
        int right = 0;

        char currentChar = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == currentChar) {
                left = i - 1;
                right = i;
                break;
            } else {
                currentChar = s.charAt(i);
            }
        }

        if (left == 0 && right == 0) {
            // нужно просто добавить в конец любой символ, который не равен последнему
            char lastSymbol = s.charAt(s.length() - 1);
            if (lastSymbol == 'z') {
                return s + 'a';
            }
            char newLastSymbol = (char) ((int) lastSymbol + 1);
            return s + newLastSymbol;
        } else {
            char leftSymbol = s.charAt(left);

            char newSymbol;

            if (leftSymbol == 'z') {
                newSymbol = 'a';
            } else {
                newSymbol = (char) ((int) leftSymbol + 1);
            }

            StringBuilder ans = new StringBuilder();
            ans.append(s.substring(0, left + 1));
            ans.append(newSymbol);
            ans.append(s.substring(right));

            return ans.toString();
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



