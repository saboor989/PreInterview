package PreInterview;
import java.util.HashSet;
import java.util.Arrays;

public class ArrayAddSub {
	public static void main(String[] args) {
		
		  int[] current = {1, 3, 5, 6, 8, 9};
	      int[] target = {1, 2, 5, 7, 9};
	      System.out.println("additions: " + difference(current, target));
	      System.out.println("deletions: " + difference(target, current));
	} 
	
	private static HashSet<Integer> difference(int[] current, int[] target) {
		HashSet<Integer> value = new HashSet<>();
		try {
	    	for ( int element : target ) {
		    	if ( Arrays.binarySearch( current, element ) < 0 ) {
		    		value.add(element);
			    }
	    	}
		}catch (Exception e) {
            e.printStackTrace();
			System.out.println("The integer array are empty please provide the values:"+ e);
		}
    	return value;
	}
}
