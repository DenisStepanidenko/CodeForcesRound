package code.denis.educationalCodeforcesRound168.problemD;




import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Solution {
    static final int INF = 1_000_000_000;
    static FastestReader sc = new FastestReader();
    static List<Integer>[] graph;
    static long[] valueOfTop;

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            valueOfTop = new long[n];
            for (int i = 0; i < n; i++) {
                long x = sc.nextLong();
                valueOfTop[i] = x;
            }

            graph = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 2; i <= n; i++) {
                int parent = sc.nextInt();
                graph[parent - 1].add(i - 1);
            }

            long result = solve();

            out.println(valueOfTop[0] + result);
            t--;
        }
        out.flush();
        out.close();
    }

    private static long solve() {
        long l = 1, r = INF;

        while (l <= r) {
            long mid =l + (r-l)/2;

            if (check(0, mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }

        return l - 1;
    }

    private static boolean check(int v, long x) {
        if (graph[v].size() == 0) return valueOfTop[v] >= x;
        if (x > INF) return false;
        boolean ans = true;
        if (v != 0) {
            x += Math.max(0, x - valueOfTop[v]);
        }
        for (int u : graph[v]) {
            ans &= (check(u, x));
        }
        return ans;

    }


    private static final class FastestReader {
        private static final int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastestReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public FastestReader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        private static boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        private int skip() throws IOException {
            int b;
            //noinspection StatementWithEmptyBody
            while ((b = read()) != -1 && isSpaceChar(b)) {}
            return b;
        }

        public String next() throws IOException {
            int b = skip();
            final StringBuilder sb = new StringBuilder();
            while (!isSpaceChar(b)) { // when nextLine, (isSpaceChar(b) && b != ' ')
                sb.appendCodePoint(b);
                b = read();
            }
            return sb.toString();
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();

            final boolean neg = c == '-';
            if (neg) c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            return neg?-ret:ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') c = read();

            final boolean neg = c == '-';
            if (neg) c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            return neg?-ret:ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ') c = read();

            final boolean neg = c == '-';
            if (neg) c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
                while ((c = read()) >= '0' && c <= '9')
                    ret += (c - '0') / (div *= 10);

            return neg?-ret:ret;
        }
        public String nextLine() throws IOException {
            final byte[] buf = new byte[(1<<10)]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    break;
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }
        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }
        public void close() throws IOException {
            din.close();
        }
    }
}
