//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Qnum1to8.Qnum8;

public class KthMissingEvennum {
    public KthMissingEvennum() {
    }

    public static int findKthMissingEven(int[] a, int k) {
        int low = 0;
        int high = a.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int count = a[mid] / 2 - a[0] / 2 + 1 - mid;
            if (count >= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return a[0] + 2 * (k + low - 1);
    }

    public static void main(String[] args) {
        int[] a = new int[]{0, 2, 6, 18, 22};
        int k = 6;
        System.out.println(findKthMissingEven(a, k));
    }
}
