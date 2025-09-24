package collections;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
public class TCSNqt {
	public static void main(String[] args) {
		Integer arr[]= {1,2,3,4,5,6};
		List <Integer> li=new ArrayList<>(Arrays.asList(arr));
		System.out.println(li);
		Integer arr1[]=li.toArray(new Integer[0]);
	}
}
