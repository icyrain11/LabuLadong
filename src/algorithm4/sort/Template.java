package algorithm4.sort;

/**
 * 排序类模板
 *
 * @author icyrain11
 * @version 1.8
 */
public class Template {

    public Template() {
    }

    //排序方法
    public static void sort() {

    }

    //比较
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] nums, int i, int j) {
        Comparable temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void show(Comparable[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i] + " ");
        }
    }

    //是否排序
    public static boolean isSorted(Comparable[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (less(nums[i], nums[i - 1])) {
                return false;
            }
        }
        return true;
    }
}
