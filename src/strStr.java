// 28.实现strStr()
class KMP {
    private int[][] dp;
    private String pat;

    public KMP(String pat) {
        this.pat = pat;
        int M = pat.length();
        // dp数组的定义是状态为M，下一个字符是c时，下一个状态是什么
        dp = new int[M][256];

        dp[0][pat.charAt(0)] = 1;

        int X = 0;

        for (int j = 1; j < M; j++) {
            for (int c = 0; c < 256; c++) {
                dp[j][c] = dp[X][c];
            }
            dp[j][pat.charAt(j)] = j + 1;
            X = dp[X][pat.charAt(j)];
        }
    }

    public int search(String txt) {
        int M = pat.length();
        int N = txt.length();

        int j = 0;

        for (int i = 0; i < N; i++) {
            j = dp[j][txt.charAt(i)];
            if (j == M) return i - M + 1;
        }

        return -1;
    }
}

public class strStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        KMP kmp = new KMP(needle);
        return kmp.search(haystack);
    }
}
