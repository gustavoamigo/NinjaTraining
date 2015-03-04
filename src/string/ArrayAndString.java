package string;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class ArrayAndString {

	public ArrayAndString () {
	}
	
	/*
	 * Chapter 1 - 1.1
	 */
	static public boolean hasOnlyUniqueChars(String str) {
		for(int i = 0; i < str.length() - 1; i++) {
			char c = str.charAt(i);
			for(int j = i + 1; j < str.length(); j++) {
				char d = str.charAt(j);
				if (c == d) return false;
			}			
		}
		return true;
	}
	
	/*
	 * Optimize in time and space
	 */
	static public boolean hasOnlyUniqueChars2(String str) {
		BitSet bits = new BitSet();

		for(int i=0; i < str.length(); i++) {
			if(bits.get(str.charAt(i))) return false;
			bits.set(str.charAt(i));
		}

		return true;
	}
	
	public interface Stream{
	     public char getNext();  
	     public boolean hasNext();

	} 
public static char firstChar ( Stream input ) {
	
	// We have to keep track of the position of the charecter 
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
	return notRepeatedCharsMap.firstEntry().getValue();
}
	
	public static class TestStrem implements Stream{
		String str;
		int i = 0;
		public TestStrem(String str) {
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
			if(i<str.length()-1) {
				return true;
			}
			return false;
		}
		
		
	}

	
	/*
	 * Chapter 1 - 1.3
	 */
	 static public String removeDuplicate(String str) {
		StringBuffer uniqueString = new StringBuffer();
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			boolean isUnique = true;
			for(int j = 0; j < i; j++) {
				char d = str.charAt(j);
				if(c == d) isUnique = false;
			}
			if(isUnique) uniqueString.append(c);
		}
		return uniqueString.toString();
	 }
	
	

	public static void main(String[] args) {
//		System.out.println("hasOnlyUniqueChars - Ch1 1.1");
//		System.out.println("abca is unique := " + (hasOnlyUniqueChars("abca")?"yes":"no"));
//		System.out.println("abceg is unique := " + (hasOnlyUniqueChars("abceg")?"yes":"no"));
//		System.out.println("ababd is unique := " + (hasOnlyUniqueChars("ababd")?"yes":"no"));
//
//		System.out.println("hasOnlyUniqueChars2 - Ch1 1.1");
//		System.out.println("abca is unique := " + (hasOnlyUniqueChars2("abca")?"yes":"no"));
//		System.out.println("abceg is unique := " + (hasOnlyUniqueChars2("abceg")?"yes":"no"));
//		System.out.println("ababd is unique := " + (hasOnlyUniqueChars2("ababd")?"yes":"no"));		
//		
		
		
		
//		System.out.println("removeDuplicate - Ch 1 1.2");
//		System.out.println("abca := " + removeDuplicate("abca"));
//		System.out.println("abceg := " + removeDuplicate("abceg"));
//		System.out.println("ababd := " + removeDuplicate("ababd"));
		
		Stream stream = new TestStrem("aAbBABac");
		System.out.println("First char is :=" + firstChar(stream) );
		
		Stream stream2 = new TestStrem("ABCDBCDE");
		System.out.println("First char is :=" + firstChar(stream2) );
		
		Stream stream3 = new TestStrem("ABCABCFEF");
		System.out.println("First char is :=" + firstChar(stream3) );
		
		Stream stream4 = new TestStrem("ABCDEF");
		System.out.println("First char is :=" + firstChar(stream4) );		
	} 

}
