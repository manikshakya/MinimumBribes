import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/*
	It's New Year's Day and everyone's in line for the Wonderland rollercoaster ride!
	 There are a number of people queued up, and each person wears a sticker 
	 indicating their initial position in the queue. Initial positions 
	 increment by 1 from 1 at the front of the line to n at the back.

	Any person in the queue can bribe the person directly in front of them to 
	swap positions. If two people swap positions, they still wear the same s
	ticker denoting their original places in line. 
	One person can bribe at most two others. For example, if n = 8 and 
	Person 5 bribes Person 4, the queue will look like this: 1,2,3,5,4,6,7,8.

	Fascinated by this chaotic queue, you decide you must know the minimum 
	number of bribes that took place to get the queue into its current state!
	
	Complete the function minimumBribes in the editor below. It must print an 
	integer representing the minimum number of bribes necessary, 
	or Too chaotic if the line configuration is not possible.

	minimumBribes has the following parameter(s):
		q: an array of integers
*/

class MinimumBribes{
	public static void main(String[] args) {
//		int[] q = {2,5,1,3,4};
//		int[] q = {2,1,4,5,3};
		int[] q = {1, 2, 5, 3, 4, 7, 8, 6};
		
		minimumBribes(q);
		
	}
	
	public static void minimumBribes(int[] q) {
		int bribe = 0;
	    boolean chaotic = false;
	    int n = q.length;
	    for(int i = 0; i < n; i++)
	    {
	        if(q[i]-(i+1) > 2)
	        {               
	            chaotic = true;
	            break;     
	        }
	        for (int j = Math.max(0, q[i]-2); j < i; j++)
	            if (q[j] > q[i]) 
	                bribe++;
	    }
	    if(chaotic)
	        System.out.println("Too chaotic");
	    else
	    	System.out.println(bribe);
		
	}
}

