package recursion;

import java.util.Arrays;

public class Recursion {

    long factorial(long v) {
        return v == 1 ? 1 : v * factorial(v - 1);
    }

    public String stringClean(String str) {
        // base case = string is empty, return ""
        // recursive case stringClean substring
        // test if firstchar of shorter == first char of str, return shorter, else chr+shorter

        if (str.length() == 0) {
            return "";
        }
        char thisChar = str.charAt(0);
        String chrToStr = Character.toString(thisChar);
        String nextStr = stringClean(str.substring(1, str.length()));
        return (nextStr.length() == 0 || nextStr.charAt(0) != thisChar ? chrToStr : "") + nextStr;
    }

    public boolean splitArray(int[] nums) {
        return split(nums, 0, 0, 0);
    }

    boolean split(int[] n, int thisLoc, int lSum, int rSum) {
        if (thisLoc >= n.length) {
            return lSum == rSum;
        }
        return split(n, thisLoc + 1, lSum + n[thisLoc], rSum) || split(n, thisLoc + 1, lSum, rSum + n[thisLoc]);
    }

    public boolean groupSum5(int start, int[] nums, int target) {
        if (start == nums.length) return target == 0;
        boolean lastWasMultOf5 = (start > 0 && nums[start - 1] % 5 == 0);
        boolean dontInclude = (nums[start] % 5 != 0 && groupSum5(start + 1, nums, target));
        boolean include = (!(lastWasMultOf5 && nums[start] == 1) && groupSum5(start + 1, nums, target - nums[start]));

        return include || dontInclude;
    }

    public boolean groupNoAdj(int start, int[] nums, int target) {
        if (start >= nums.length) return target == 0;
        return groupNoAdj(start + 1, nums, target) || groupNoAdj(start + 2, nums, target - nums[start]);
    }

    boolean split53(int[] n) {
        return doSplit53(n, 0, 0, 0);
    }

    boolean doSplit53(int[] n, int thisLoc, int lSum, int rSum) {
        if (thisLoc >= n.length) {
            return lSum == rSum;
        }
        return ((n[thisLoc] % 5 != 0) && doSplit53(n, thisLoc + 1, lSum + n[thisLoc], rSum)) ||
                ((n[thisLoc] % 3 != 0) && doSplit53(n, thisLoc + 1, lSum, rSum + n[thisLoc]));
    }

    public boolean groupSum6(int start, int[] nums, int target) {
        if (start == nums.length) return target == 0;
        boolean lastWasMultOf5 = (start > 0 && nums[start - 1] % 5 == 0);
        boolean dontInclude = (nums[start] != 6 && groupSum6(start + 1, nums, target));
        boolean include = groupSum6(start + 1, nums, target - nums[start]);

        return include || dontInclude;
    }

    public boolean groupSumClump(int start, int[] nums, int target) {
        return doGroupSumClump(start, nums, target, false);
    }

    public boolean doGroupSumClump(int start, int[] nums, int target, boolean incPath) {
        if (start == nums.length) return target == 0;
        boolean thisIsDup = (start > 0 && nums[start - 1] == nums[start]);
        boolean dontInclude = ((!thisIsDup || !incPath) && doGroupSumClump(start + 1, nums, target, false));
        boolean include = (!thisIsDup || incPath) && doGroupSumClump(start + 1, nums, target - nums[start], true);

        return include || dontInclude;
    }

    public int strDist(String str, String sub) {
        // recursive step
        // base case "" = 0
        int right = lastPosOf(str, sub);
        int left = firstPosOf(str, sub);
        return right < 0 || left < 0 ? 0 : right - left;
    }

    public int firstPosOf(String str, String sub) {
        if (str.length() < sub.length()) return -1;
        if (str.indexOf(sub) == 0)
            return 0;
        return 1 + firstPosOf(str.substring(1, str.length()), sub);
    }

    public int lastPosOf(String str, String sub) {
        if (str.length() < sub.length()) return -1;
        if (str.lastIndexOf(sub) == str.length() - sub.length())
            return str.length();
        return lastPosOf(str.substring(0, str.length() - 1), sub);
    }

    public static void main(String[] args) {
        Recursion r = new Recursion();

        System.out.println(r.stringClean("aabbbcccca"));
        System.out.println();
        System.out.println(r.splitArray(new int[]{1, 2, 3}));
        System.out.println(r.splitArray(new int[]{1, 2, 3, 5}));
        System.out.println(r.splitArray(new int[]{2, 2}));
        System.out.println(r.splitArray(new int[]{2, 3}));
        System.out.println(r.splitArray(new int[]{5, 2, 3}));
        System.out.println();
        System.out.println(r.groupSum5(0, new int[]{2, 5, 10, 4}, 19));
        System.out.println(r.groupSum5(0, new int[]{2, 5, 10, 4}, 17));
        System.out.println(r.groupSum5(0, new int[]{2, 5, 10, 4}, 12));
        System.out.println(r.groupSum5(0, new int[]{2, 5, 10, 4}, 7));
        System.out.println();
        System.out.println(r.groupNoAdj(0, new int[]{2, 5, 10, 4}, 12));
        System.out.println(r.groupNoAdj(0, new int[]{2, 5, 10, 4}, 14));
        System.out.println(r.groupNoAdj(0, new int[]{2, 5, 10, 4}, 7));

        System.out.println();
        System.out.println(r.split53(new int[]{1, 1}));
        System.out.println(r.split53(new int[]{1, 1, 1}));
        System.out.println(r.split53(new int[]{2, 4, 2}));

        System.out.println();
        System.out.println(r.groupSum6(0, new int[]{5, 6, 2}, 8));
        System.out.println(r.groupSum6(0, new int[]{5, 6, 2}, 9));
        System.out.println(r.groupSum6(0, new int[]{5, 6, 2}, 7));

        System.out.println();
        System.out.println(r.groupSumClump(0, new int[]{2, 4, 8}, 10));
        System.out.println(r.groupSumClump(0, new int[]{1, 2, 4, 8, 1}, 14));
        System.out.println(r.groupSumClump(0, new int[]{2, 4, 4, 8}, 14));

        System.out.println();
        System.out.println(r.strDist("catcowcat", "cat"));  // 9
        System.out.println(r.strDist("catcowcat", "cow"));  // 3
        System.out.println(r.strDist("cccatcowcatxx", "cat"));  // 9
    }

    public int recursiveStringLength(String s) {
        if (s.length() == 0) return 0;
        return 1 + recursiveStringLength(s.substring(1, s.length()));
    }

    public int binarySearch(int items[], int target) {
        return doBinarySearch(items, target, 0, items.length - 1);
    }

    public int doBinarySearch(int items[], int target, int first, int last) {
        if (first > last) return -1;
        int middle = (first + last) / 2;
        if (items[middle] == target) return middle;
        if (items[middle] < target)
            return doBinarySearch(items, target, first, middle - 1);
        else
            return doBinarySearch(items, target, middle + 1, last);
    }

}


