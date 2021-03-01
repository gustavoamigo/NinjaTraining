package fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/meeting-rooms/
 */
public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        for(int i = 0; i<intervals.length - 1; i++) {
            for(int j = i + 1; j<intervals.length; j++) {
                if(intervals[i][1]>intervals[j][0]&&intervals[i][0]<intervals[j][1]) return false;
            }
        }
        return true;
    }

    /*
    https://leetcode.com/problems/meeting-rooms-ii/
     */
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<Integer> rooms = new ArrayList<>();
        rooms.add(0);
        for(int[] meeting: intervals) {
            boolean found = false;
            for(int i = 0; i<rooms.size() && !found; i++) {
                if(meeting[0] >= rooms.get(i)) {
                    rooms.set(i, meeting[1]); // book room
                    found = true;
                    break;
                }
            }
            if(!found) rooms.add(meeting[1]); // add another room
        }
        return rooms.size();
    }
}
