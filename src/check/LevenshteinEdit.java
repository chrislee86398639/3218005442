package check;

public class LevenshteinEdit {//最小编辑距离动态规划
    public static int minDistance(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        int dp[][] = new int[len1+1][len2+1];
        for(int i = 0; i <= len1; i ++) {
            dp[i][0] = i;
        }
        for(int j = 0; j <= len2; j ++) {
            dp[0][j] = j;
        }
        for(int i = 0; i < len1; i ++) {
            char c1 = str1.charAt(i);
            for(int j = 0; j < len2; j ++) {
                char c2 = str2.charAt(j);
                if(c1 == c2) {
                    dp[i+1][j+1] = dp[i][j];
                }
                else {
                    int insert = dp[i+1][j] + 1;//插入字符
                    int delete = dp[i][j+1] + 1;//删除字符
                    int replace = dp[i][j] + 1;//替换字符
                    int min = insert>delete ? delete : insert;
                    min = min > replace ? replace : min;
                    dp[i+1][j+1] = min;
                }
            }
        }
        return dp[len1][len2];
    }
}