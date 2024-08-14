package code.denis.educationalCodeforcesRound168.problemC;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int t = input.nextInt();
        StringBuilder answer = new StringBuilder();
        while (t > 0) {
            int n = input.nextInt();
            String s = input.nextLine();
            answer.append(solve(s, n)).append("\n");
            t--;
        }
        System.out.println(answer);
    }

    private static int solve(String s, int n) {
        int balance = 0;
        int sum = 0;
        Stack<Integer> indexOfOpen = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '_') {
                if (balance == 0) {
                    indexOfOpen.push(i + 1);
                    balance++;
                } else {
                    int indexOfCurrentOpen = indexOfOpen.pop();
                    sum += ((i + 1) - indexOfCurrentOpen);
                    balance--;
                }
            } else {
                if (s.charAt(i) == ')') {
                    int indexOfCurrentOpen = indexOfOpen.pop();
                    sum += ((i + 1) - indexOfCurrentOpen);
                    balance--;
                } else {
                    indexOfOpen.push(i + 1);
                    balance++;
                }
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
