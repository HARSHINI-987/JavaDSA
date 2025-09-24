package searching;

public class SearchingAlgo {
	static int interpolationSearch(int arr[], int x) {
        int lo = 0;
        int count = 0;
        int hi = arr.length - 1;

        while (lo <= hi && x >= arr[lo] && x <= arr[hi]) {
            count++;
            if (arr[hi] == arr[lo]) { // Avoid division by zero
                if (arr[lo] == x) {
                    System.out.println("Interpolation search loop count " + count);
                    return lo;
                } else {
                    break;
                }
            }

            int pos = lo + ((x - arr[lo]) * (hi - lo) / (arr[hi] - arr[lo]));

            if (arr[pos] == x) {
                System.out.println("Interpolation search loop count " + count);
                return pos;
            }

            if (arr[pos] < x) {
                lo = pos + 1;
            } else {
                hi = pos - 1;
            }
        }

        System.out.println("Interpolation search loop count " + count);
        return -1;
    }

    static int binarySearch(int num[], int target) {
        int count = 0;
        int l = 0;
        int r = num.length - 1;
        while (l <= r) {
            count++;
            int mid = l + (r - l) / 2;
            if (num[mid] == target) {
                System.out.println("Binary search loop count " + count);
                return mid;
            }
            if (num[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        System.out.println("Binary search loop count " + count);
        return -1;
    }

    static int linearSearch(int arr[], int target) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count++;
            if (arr[i] == target) {
                System.out.println("Linear search loop count " + count);
                return i;
            }
        }
        System.out.println("Linear search loop count " + count);
        return -1;
    }

    public static void main(String[] args) {
        int num[] = new int[100];
        for (int i = 0; i < num.length; i++) {
            num[i] = i + 1;
        }
        int target =90;
        System.out.println((linearSearch(num, target) == -1) ? "Not in arr" : "Present");
        System.out.println((binarySearch(num, target) == -1) ? "Not in arr" : "Present");
        System.out.println((interpolationSearch(num, target) == -1) ? "Not in arr" : "Present");
    }
}
