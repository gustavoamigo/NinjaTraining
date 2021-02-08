package fb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> hash = new HashMap<>();
        for(String s: strings) {
            StringBuffer buf = new StringBuffer();
            buf.append("start-");
            for(int i = 1; i<s.length(); i++) {
                int diff = (s.charAt(i - 1)) - (s.charAt(i));
                if(diff < 0) diff = diff + 'z' - 'a' + 1;
                buf.append(diff);
                buf.append("-");
            }
            if(!hash.containsKey(buf.toString())) hash.put(buf.toString(), new ArrayList());
            hash.get(buf.toString()).add(s);
        }
        List<List<String>> result = new ArrayList<>();
        for(List<String> list: hash.values()) {
            result.add(list);
        }
        return result;
    }
}
