package algorithm4.sort;

/**
 * @author icyrain11
 * @version 1.8
 */
public class Selection extends Template {

    public Selection() {
        super();
    }

    public static void sort(Comparable[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(nums[j], nums[min])) {
                    min = j;
                }
                exch(nums, j, min);
            }
        }
    }
}
