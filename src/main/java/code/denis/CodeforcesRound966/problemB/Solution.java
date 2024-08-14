package code.denis.CodeforcesRound966.problemB;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        int t = input.nextInt();

        while (t > 0) {
            int n = input.nextInt();
            String answer = "YES";
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                int x = input.nextInt();
                arr[i] = x;
            }

            int[] places = new int[n];

            for (int i = 0; i < n; i++) {
                int currentPlace = arr[i] - 1;
                if (i == 0) {
                    places[currentPlace] = 1;
                    continue;
                }

                if (currentPlace == 0) {
                    if (places[currentPlace + 1] == 0) {
                        answer = "NO";
                        break;
                    }
                    places[currentPlace] = 1;
                } else if (currentPlace == n - 1) {
                    if (places[currentPlace - 1] == 0) {
                        answer = "NO";
                        break;
                    }
                    places[currentPlace] = 1;
                } else {
                    if (places[currentPlace - 1] == 0 && places[currentPlace + 1] == 0) {
                        answer = "NO";
                        break;
                    }
                    places[currentPlace] = 1;
                }
            }

            out.println(answer);
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
