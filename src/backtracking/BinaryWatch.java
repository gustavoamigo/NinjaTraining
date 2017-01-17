package backtracking;

import java.util.BitSet;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-watch/
 *
 */
public class BinaryWatch {

    private static int NUM_BITS = 10;

    public List<String> readBinaryWatch(int num) {
        LinkedList<BitSet> backtracking = backtracking(new BitSet(NUM_BITS), 0, num);
        LinkedList<String> strs = new LinkedList<>();
        for(BitSet elem: backtracking) {
            strs.add(toHour(elem));
        }
        return strs;
    }

    private static LinkedList<BitSet> backtracking(BitSet back, int bitindex, int num) {
        if(bitindex < NUM_BITS) {
            BitSet bit0 = (BitSet) back.clone();
            LinkedList<BitSet> backtracking0 = backtracking(bit0, bitindex + 1, num);

            if(num > 0) {
                BitSet bit1 = (BitSet) back.clone();
                bit1.set(bitindex);
                LinkedList<BitSet> backtracking1 = backtracking(bit1, bitindex + 1, num - 1);

                backtracking1.addAll(backtracking0);
                return backtracking1;
            } else {
                return backtracking0;
            }
        } else {
            LinkedList<BitSet> backtraking = new LinkedList<>();
            if(num == 0 && isValid(back)) backtraking.add(back);
            return backtraking;
        }
    }


    private static String toHour(BitSet bitset) {
        int hour = toInt(bitset, 0, 3);
        int minute = toInt(bitset, 4, 9);
        return String.format("%d:%02d",hour,minute);
    }

    private static int toInt(BitSet bitset, int start, int end) {
        int count = end - start;
        int power = 1;
        int num = 0;
        for(int i=0;i<=count;i++) {
            num += (bitset.get(i + start)?1:0) * power;
            power *= 2;
        }
        return num;
    }

    private static boolean isValid(BitSet bitset) {
        int hour = toInt(bitset, 0, 3);
        int minute = toInt(bitset, 4, 9);
        return hour <= 11 && minute <=59;
    }

    public static void  main(String[] args) {
        List<String> strings = (new BinaryWatch()).readBinaryWatch(2);
        strings.sort(String::compareTo);
        for(String str: strings) System.out.printf("\"%s\",",str);

    }

}
