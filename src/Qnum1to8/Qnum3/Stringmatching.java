//package Qnumthree;
//
//public class Anum3b {
//    boolean solve(String str, String pattern, int i, int j, boolean[][] dp) {
////base cases
//// if both string ends at same time
//        if (i < 0 && j < 0) {
//            return true;
//        }
////if pattern string ends but str is left
//        if (i >= 0 && j < 0) {
//            return false;
//        } //if pattern is left but str is ended
//        if (i < 0 && j >= 0) {
//            for (int k = 0; k <= j; k++) {
//                if (pattern.charAt(k) != '@') {
//                    return false;
//                }
//            }
//            return true;
//        }
////matching
//        if (str.charAt(i) == pattern.charAt(j) && pattern.charAt(j) == '#') {
//            return dp[i][j] = solve(str, pattern, i - 1, j - 1, dp);
//        } else if (pattern.charAt(j) == '@') {
//            return dp[i][j] = (solve(str, pattern, i - 1, j, dp));
//        } else {
//            return false;
//        }
//    }
//
//    boolean match(String str, String pattern) {
//        int i = str.length() - 1;
//        int j = pattern.length() - 1;
//        boolean matrix[][] = new boolean[i + 1][j + 1];
//        boolean result = solve(str, pattern, i, j, matrix);
//        System.out.println(result);
//        return result;
//    }
//
//    public static void main(String[] args) {
//        Anum3b dp = new Anum3b();
//        String str = "tt";
//        String pattern = "@";
//        dp.match(str, pattern); // prints true
//
//        str = "ta";
//        pattern = "t";
//        dp.match(str, pattern); // prints false
//
//        str = "ta";
//        pattern = "t#";
//        dp.match(str, pattern); // prints true
//    }
//
//}
//
//


package Qnum1to8.Qnum3;

public class Stringmatching {
    boolean solve(String str, String pattern, int i, int j, boolean[][] dp) {
        //base cases
        // if both string ends at same time
        if (i < 0 && j < 0) {
            return true;
        }
        //if pattern string ends but str is left
        if (i >= 0 && j < 0) {
            return false;
        }        //if pattern is left but str is ended
        if (i < 0 && j >= 0) {
            for (int k = 0; k <= j; k++) {
                if (pattern.charAt(k) != '@') {
                    return false;
                }

            }
            return true;
        }
        //matching
        if (str.charAt(i) == pattern.charAt(j) && pattern.charAt(j) == '#') {
            return dp[i][j] = solve(str, pattern,i - 1, j - 1, dp);
        } else if (pattern.charAt(j) == '@') {
            return dp[i][j] = (solve(str, pattern, i - 1, j, dp));
        } else {
            return false;
        }
    }

    boolean match(String str, String pattern) {
        int i = str.length() - 1;
        int j = pattern.length() - 1;
        boolean matrix[][] = new boolean[i + 1][j + 1];
        return solve(str, pattern, i, j, matrix);
    }

    public static void main(String[] args) {
        Stringmatching dp = new Stringmatching();
        String str1 = "tt";
        String pattern1 = "@";
        System.out.println(dp.match(str1, pattern1)); // true

        String str2 = "ta";
        String pattern2 = "t";
        System.out.println(dp.match(str2, pattern2)); // false

        String str3 = "ta";
        String pattern3 = "t#";
        System.out.println(dp.match(str3, pattern3)); // true
    }
}
