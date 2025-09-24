package Sorting;
/**
 *Partion
 * low-----> start index
 * high ----> end index
 * pivot ---> start or mid or last element
 * i ---->left index pointer (it should smaller pivot)
 * j -----> right index pointer (it should greater pivot)
 * i and j should not initialize with pivot index
 * if element of i (arr[i]) > pivot and element
 * element of j(arr[j]) < pivot and i<=j swap element of i and j
 * if element of i (arr[i]) > pivot and element of j(arr[j]) < pivot and i>j swap element of j and low
 * recursive call quickSort for divide and con(low to j-1(pivot-1) and (j+1) to high)
 */
public class QuickSort {
	public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low]; int i = low + 1; int j = high; 
        while (i <= j){  //{9,7,5,14,2,3,6,10};
            while (i <= j && arr[i] <= pivot) {
                i++;
            }
            while (i <= j && arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        return j; 
    }
public static void main(String[] args) {
	int arr[]= {9,7,5,14,2,3,6,10};
	 quickSort(arr, 0, arr.length - 1);
	for(int i:arr) {
		System.out.print(i+"  ");
	}
}
}
