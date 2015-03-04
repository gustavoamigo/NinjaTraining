package list;
import java.util.*;
/* 
 * Not a Leetcode problem
 */

public class LinkedListSum {

	public static List<Integer> sumLists(List<Integer> first, List<Integer> second) {
		LinkedList<Integer> result = new LinkedList<Integer>();
		
		Iterator<Integer> firstIter = first.iterator();
		Iterator<Integer> secondIter = second.iterator();
		
		int rest = 0;
		while(firstIter.hasNext()) {
			int firstValue = firstIter.next();
			int secondValue = secondIter.next();
			int sum = firstValue + secondValue + rest;
			if(sum>9) {
				rest = 1;
				sum = 10 - sum;
			} else {
				rest = 0;
			}
			result.add(sum);
		}
		
		return result;
	}
	
	public static void printList(List<Integer> list){
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + (iterator.hasNext()?"->":"\n") );
		}
	}
	
	public static void main(String[] args) {
		List<Integer> first = new LinkedList<Integer>();
		first.add(3); first.add(1); first.add(5);
		printList(first);
		
		List<Integer> second = new LinkedList<Integer>();
		second.add(5); second.add(9); second.add(2);
		printList(second);
		
		printList(sumLists(first, second));
		
		Collections.sort(first);

	}

}
