package code.denis.codeforcesRound954.problemC;



import java.io.*;
import java.util.*;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int t = input.nextInt();

        PrintWriter out = new PrintWriter(System.out);
        while (t > 0) {
            int n = input.nextInt();
            int m = input.nextInt();
            String s = input.nextLine();
            List<Character> sArr = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                sArr.add(s.charAt(i));
            }

            TreeSet<Integer> ind = new TreeSet<>();
            int count = m;
            for (int i = 0; i < m; i++) {
                int x = input.nextInt();
                if(ind.contains(x)) count--;
                ind.add(x);
            }

            String c = input.nextLine();
            List<Character> cArr = new ArrayList<>();
            for (int i = 0; i < c.length(); i++) {
                cArr.add(c.charAt(i));
            }
            Collections.sort(cArr);

            for (int i = 0; i < count; i++) {
                int index = ind.pollFirst();
                sArr.set(index - 1, cArr.get(i));
            }

            StringBuilder ans = new StringBuilder();

            for(Character x : sArr){
                ans.append(x);
            }

            out.println(ans);
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
