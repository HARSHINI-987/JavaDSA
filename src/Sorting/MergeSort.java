package Sorting;
/**
 * Recursive call for splitting left and right of mid upto single element
 * after that merge method on recursive call
 * temporary array 1 with length of left 
 * temporary array 2 with the length of right
 * data loaded from splitted array to temporary array
 * compare left with right temporary array for smaller element and place element in main array
 * if all element in a single sided array is small copy the element in another sided array into main array
 * repeat until all elements have to be merged
 */
public class MergeSort {
	//Dividing
	public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
	//Merging
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    public static void main(String[] args) {
    	int arr[]= {9,7,5,14,2,3,6,10};
   	 	mergeSort(arr, 0, arr.length - 1);
   	 	for(int i:arr) {
   	 		System.out.print(i+"  ");
   	 	}
	}
}
