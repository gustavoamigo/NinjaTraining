package string;

import java.util.*;
/*
 * https://oj.leetcode.com/problems/text-justification/
 */
public class TextJustification {
	public String justifyLine(ArrayList<String> line, int maxLength, int minLength, boolean isLast) {
		StringBuilder builder = new StringBuilder();
		if(!isLast && line.size()!=1) {
			int spaceLeft = maxLength - minLength;
			int spaceBetween = 0;
			int spaceRemaining = 0;
			if(spaceLeft > 0 && line.size()>1) {
				spaceBetween = spaceLeft/(line.size()-1);
				spaceRemaining = spaceLeft % ((line.size()-1));
			}
			for(String word : line) {
				if(builder.length()!=0) {
					for(int i = 0; i<= spaceBetween;i++) builder.append(" ");
					if(spaceRemaining!=0) {
						builder.append(" ");
						spaceRemaining--;
					}
				}
				builder.append(word);
			}
		} else {
			for(String word : line) {
				if(builder.length()!=0) {
					builder.append(" ");
				}
				builder.append(word);
			}
			int remaining = maxLength - builder.length();
			for(int i = 0; i<remaining; i++) builder.append(" ");
		}
		return builder.toString();
	}

    public ArrayList<String> fullJustify(String[] words, int L) {
    	ArrayList<String> justifiedText = new ArrayList<String>();
    	ArrayList<String> line = new ArrayList<String>();
    	int i = 0;
    	int minLineLength = 0;
    	while(i<words.length) {
    		if( minLineLength + ((minLineLength==0) ? 0 : 1) + words[i].length() <= L) {
    			minLineLength +=
    					((minLineLength==0) ? 0 : 1) + words[i].length();
    			line.add(words[i]);
    			i++;
    		} else {
    			justifiedText.add(justifyLine(line, L, minLineLength, false));
    			line = new ArrayList<>();
    			minLineLength = 0;
    		}
    	}
    	if(line.size() != 0) justifiedText.add(justifyLine(line, L, minLineLength, true));
    	return justifiedText;
    }

    public static void main(String[] args) {
		String[] words = {"The","goblin","shark","is","a","rare,","poorly","understood","species","of","deep-sea","shark.",
				"Sometimes","called","a","living","fossil","it","is","the","only","extant","last"};
		TextJustification justification = new TextJustification();
		ArrayList<String> text = justification.fullJustify(words, 15);
		for(String line : text) {
			System.out.println("\""+ line + "\":" + line.length());
		}


	}

}
