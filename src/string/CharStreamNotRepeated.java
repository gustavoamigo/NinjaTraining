package string;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CharStreamNotRepeated {
	
	public interface Stream{
	     public char getNext();  
	     public boolean hasNext();

	} 
	
	public static char firstCharNotRepeated ( Stream input ) {
	
		// We have to keep track of the position of the character 
		// in order to efficiently remove it later
		TreeMap<Integer,Character> notRepeatedCharsMap = 
				new TreeMap<Integer,Character>();	
	
		Map<Character,Integer> positionMap = 
				new HashMap<Character, Integer>(); 
		
		int i = 0; 
		
		while(input.hasNext() != false) {
			char next = input.getNext();
			
			// It means it is repeated
			if(positionMap.get(next) != null){ 
				
				// So, we remove from the not repeated list
				int position = positionMap.get(next);
				notRepeatedCharsMap.remove(position); 
				
			} else {
				notRepeatedCharsMap.put(i, next);
				positionMap.put(next, i);
			}
			i++;
		}
		if(notRepeatedCharsMap.firstEntry() == null) throw new RuntimeException("There are no chars repeated");
		return notRepeatedCharsMap.firstEntry().getValue();
	}
	
	static class StringStream implements Stream{
		String str;
		int i = 0;
		public StringStream(String str) {
			this.str = str;
		}

		@Override
		public char getNext() {
			char next = str.charAt(i); 
			i++;
			return next;
		}

		@Override
		public boolean hasNext() {
			if(i<str.length()) {
				return true;
			}
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println(firstCharNotRepeated(new StringStream("aAbBABac"))); //b
		System.out.println(firstCharNotRepeated(new StringStream("aAABABac"))); //c
		System.out.println(firstCharNotRepeated(new StringStream("a"))); //a
		System.out.println(firstCharNotRepeated(new StringStream("aA"))); //a
		System.out.println(firstCharNotRepeated(new StringStream("aAacB"))); //A
		
	}

}
