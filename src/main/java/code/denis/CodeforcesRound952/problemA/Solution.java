package code.denis.CodeforcesRound952.problemA;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) throws IOException {
        int t = input.nextInt();
        PrintWriter out = new PrintWriter(System.out);

        while (t > 0) {
            String line = input.nextLine();
            if (!line.isEmpty()) {
                String[] words = line.split(" ");
                String a = words[0];
                String b = words[1];

                String aNew = b.charAt(0) + a.substring(1);
                String bNew = a.charAt(0) + b.substring(1);

                out.println(aNew + " " + bNew);
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
