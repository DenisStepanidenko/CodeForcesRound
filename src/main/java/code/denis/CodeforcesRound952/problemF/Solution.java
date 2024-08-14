package code.denis.CodeforcesRound952.problemF;



import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        int t = input.nextInt();
        while (t > 0) {
            long h = input.nextLong();
            int n = input.nextInt();

            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                long x = input.nextLong();
                a[i] = x;
            }

            long[] c = new long[n];
            for (int i = 0; i < n; i++) {
                long x = input.nextLong();
                c[i] = x;
            }

            TreeSet<Pair> pairs = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                pairs.add(new Pair(1, a[i], c[i]));
            }

            // начинается fight
            long lastMove = 1;


            while(h > 0){
                Pair currentPair = pairs.pollFirst();
                h -= currentPair.getA();
                lastMove = currentPair.getT();
                currentPair.setT(lastMove + currentPair.getAdd());
                pairs.add(currentPair);
            }
            out.println(lastMove);
            t--;
        }


        out.flush();
        out.close();
    }

    static class Pair implements Comparable<Pair> {

        public long getAdd() {
            return add;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "t=" + t +
                    ", a=" + a +
                    '}';
        }

        public long t;
        public long a;

        public Pair(long t, long a, long add) {
            this.t = t;
            this.a = a;
            this.add = add;
        }

        public void setT(long t) {
            this.t = t;
        }

        public void setA(long a) {
            this.a = a;
        }

        public void setAdd(long add) {
            this.add = add;
        }

        public long add;


        public long getT() {
            return t;
        }

        public long getA() {
            return a;
        }

        public Pair(long t, long a) {
            this.t = t;
            this.a = a;
        }

        @Override
        public int compareTo(Pair o) {
            if (t > o.getT()) return 1;

            if (t < o.getT()) return -1;


            else {
                // тут случай t = o.getT()
                if (a > o.getA()) return -1;

                if (a < o.getA()) return 1;

                return -1;
            }
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
