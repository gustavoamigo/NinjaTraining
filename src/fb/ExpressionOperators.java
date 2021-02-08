package fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/expression-add-operators/solution/
 */
public class ExpressionOperators {
    private static Long eval(List<String> elements) {
        if(elements.size() == 1) return Long.parseLong(elements.get(0));
        String operator = elements.get(1);
        if(operator.equals("*")) {
            long num1 = Long.parseLong(elements.get(0));
            long num2 = Long.parseLong(elements.get(2));
            long mult = num1 * num2;
            ArrayList<String> newList = new ArrayList<>(elements.subList(2, elements.size()));
            newList.set(0, String.valueOf(mult));
            long ans = eval(newList);
            return ans;
        } else  if(operator.equals("-")) {
            long num1 = Long.parseLong(elements.get(0));
            ArrayList<String> newList = new ArrayList<>(elements.subList(2, elements.size()));
            newList.set(0, "-" + newList.get(0));
            long ans = num1 + eval(newList);
            return ans;
        } else {
            long num1 = Long.parseLong(elements.get(0));
            long ans = num1 + eval(elements.subList(2, elements.size()));
            return ans;
        }
    }


    private void recursion(List<String> elements, String num, int target, List<String> solutions) {

        if(!elements.isEmpty()
                && num.isEmpty()
                && eval(new ArrayList<>(elements)) == target
        ) {
            solutions.add(String.join("", elements));
        }

        for(int i = 0; i < num.length(); i++) {
            String currentNum = num.substring(0,i + 1);
            if(!currentNum.equals(String.valueOf(Long.parseLong(currentNum))))
                continue;
            String suffix = num.substring(i+1);
            if(suffix.isEmpty()) {
                elements.add(currentNum);
                recursion(elements, "", target, solutions);
                elements.remove(elements.size() - 1);
            } else {
                elements.add(currentNum);
                elements.add("+");
                recursion(elements, num.substring(i+1), target, solutions);
                elements.remove(elements.size() - 1);

                elements.add("-");
                recursion(elements, num.substring(i+1), target, solutions);
                elements.remove(elements.size() - 1);

                elements.add("*");
                recursion(elements, num.substring(i+1), target, solutions);
                elements.remove(elements.size() - 1);
                elements.remove(elements.size() - 1);

            }
        }
    }

    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        recursion(new ArrayList<>(), num, target, ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(12-3*4*5-6+78+9);
        System.out.println(eval(Arrays.asList("12","-","3","*","4","*","5","-","6","+","78","+","9")));

        System.out.println(12*5-6+78+9);
        System.out.println(eval(Arrays.asList("12","*","5","-","6","+","78","+","9")));

        System.out.println(12*5-6+78);
        System.out.println(eval(Arrays.asList("12","*","5","-","6","+","78")));

        System.out.println(60-6+78);
        System.out.println(eval(Arrays.asList("60","-","6","+","78")));
    }


}
