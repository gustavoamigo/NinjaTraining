package fb;

import java.util.List;
import java.util.Stack;

public class ExclusiveTime {
    public int[] exclusiveTime(int n, List<String> logs) {
        int ts = -1;
        Stack<Integer> stack = new Stack<>();

        int[] result = new int[n];
        for(String log: logs) {
            String[] parsed = log.split(":");
            int taskId = Integer.parseInt(parsed[0]);
            String op = parsed[1];
            int taskTs = Integer.parseInt(parsed[2]);
            int elapsed =  taskTs - ts ;
            ts = taskTs;

            if(op.equals("start")) {
                int currentTaskId = stack.empty() ? -1 : stack.peek();
                if(currentTaskId != -1) {
                    result[currentTaskId] += elapsed;
                }
                stack.add(taskId);
            } else if(op.equals("end")) {
                int endedTaskId = stack.pop();
                result[endedTaskId] += elapsed + 1;
                ts++;
            }
        }
        return result;
    }
}
