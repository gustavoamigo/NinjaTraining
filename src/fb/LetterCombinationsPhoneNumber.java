package fb;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsPhoneNumber {
    String[][] keyMap = {
            {"a", "b", "c"},
            {"d", "e", "f"},
            {"g", "h", "i"},
            {"j", "k", "l"},
            {"m", "n", "o"},
            {"p", "q", "r", "s"},
            {"t", "u", "v"},
            {"w", "x", "y", "z"}
    };
    public void recursive(String prefix, String digits, ArrayList<String> output) {
        if(digits.length() == 0) {
            if(prefix.length() != 0) output.add(prefix);
            return;
        }
        String[] letters = keyMap[digits.charAt(0) - '2'];
        for(String letter: letters) {
            recursive(prefix + letter, digits.substring(1), output);
        }
    }
    public List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();
        recursive("", digits, result);
        return result;
    }
}
