package check;

public class LevenshteinEdit {//最小编辑距离动态规划

    public int editDistanceCompute(String strA, String strB) {

        int iLengthA = strA.length() + 1;
        int iLengthB = strB.length() + 1;
        int maxtri[][] = new int[iLengthA][iLengthB];

        for (int i = 0; i < iLengthA; i++) {
            maxtri[i][0] = i;
        }

        for (int j = 1; j < iLengthB; j++) {
            maxtri[0][j] = j;
        }

        for (int j = 1; j < iLengthB; j++) {

            for (int i = 1; i < iLengthA; i++) {

                int min = maxtri[i - 1][j - 1] + (strA.charAt(i - 1) == strB.charAt(j - 1) ? 0 : 1);

                int iUp = maxtri[i][j - 1] + 1;

                int iLeft = maxtri[i - 1][j] + 1;

                if (min > iUp) {
                    min = iUp;
                }

                if (min > iLeft) {
                    min = iLeft;
                }

                maxtri[i][j] = min;
            }
        }

        return maxtri[iLengthA - 1][iLengthB - 1];
    }
}