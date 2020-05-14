package codeforces;

public class Binary {

    public static void main(String[] args) {

        Binary binary = new Binary();
//        System.out.println(binary.search(new int[] {4,5,6,7,0,1,2}, 0)); // 4
//        System.out.println(binary.search(new int[] {4,5,6,7,0,1,2}, 3)); // -1
//        System.out.println(binary.search(new int[] {6,0,2,5}, 6));       // 0
//        System.out.println(binary.search(new int[] {5,6,0,2}, 6));       // 1
//        System.out.println(binary.search(new int[] {4,5,6,7,0,1,2}, 4)); // 0
//        System.out.println(binary.search(new int[] {2,4,5,6,7,0,1}, 4)); // 1

//        System.out.println(binary.search(new int[] {7,0,1,2,4,5,6}, 4)); // 4
//        System.out.println(binary.search(new int[] {6,7,0,1,2,4,5}, 0)); // 2
//        System.out.println(binary.search(new int[] {0,1,2,4,5,6,7}, 0)); // 0
//        System.out.println(binary.search(new int[] {0}, 0));             // 0

//        System.out.println(binary.search(new int[] {1}, 0));             // -1
//        System.out.println(binary.search(new int[] {0,2}, 0));           // 0
//        System.out.println(binary.search(new int[] {0,2}, 4));           // -1
//        System.out.println(binary.search(new int[] {0,2,5}, 5));         // 2
//        System.out.println(binary.search(new int[] {0,2,5,6}, 6));       // 3
//
//        System.out.println(binary.search(new int[] {0,2,5,6}, 0));       // 0
//        System.out.println(binary.search(new int[] {6,0,2,5}, 0));       // 1
//        System.out.println(binary.search(new int[] {5,6,0,2}, 0));       // 2
//        System.out.println(binary.search(new int[] {2,5,6,0}, 0));       // 3

//        System.out.println(binary.search(new int[] {2,5,6,0}, 8));       // -1
        System.out.println(binary.search(new int[] {}, 5));              // -1
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int pivot = findPivot(nums, 0, nums.length);

//        System.out.println("pivot " + pivot);

        if (pivot == -1) {
            return binarySearch(nums, 0, nums.length-1, target);
        }

        if (target == nums[pivot]) {
            return pivot;
        } else if (target > nums[nums.length-1]) {
//            System.out.println("bzdo 0 " + (pivot-1));
            return binarySearch(nums, 0, pivot-1, target);
        }
//        System.out.println("go");
        return binarySearch(nums, pivot+1, nums.length-1, target);
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        int pivot = (start + end) / 2;

//        System.out.println("pivot: " + pivot + " " + start + " " + end);

        if (nums[pivot] == target) {
            return pivot;
        } else if (start >= end) {
            return -1;
        } else if (target >= nums[pivot]) {
            // 2,4,5,6,7,0,1
//            System.out.println("ass: " + pivot + " " + end);
            return binarySearch(nums, pivot+1, end, target);
        }
//        System.out.println("dno: " + pivot + " " + start + " " + (pivot-1));
        return binarySearch(nums, start, pivot-1, target);
    }

    private int findPivot(int[] nums, int start, int end) {
        int pivot = (start + end) / 2;
        if (start >= end) {
            return -1;
        }
        if ((pivot+1) < nums.length && nums[pivot+1] < nums[pivot]) {
            return pivot+1;
        } else if ((pivot-1) >= 0 && nums[pivot-1] > nums[pivot]) {
            return pivot;
        } else if (nums[start] >= nums[pivot]) {
            return findPivot(nums, start, pivot);
        } else {
            return findPivot(nums, pivot, end);
        }
    }
}
