package bit;

public class BitMan {

	static public void printBits(int a) {
		for(int i=0; i < 31; i++) {
			boolean isOne =  ( (1 << (30-i)) & a) > 0;
			System.out.print( isOne ?"1":"0");
		}
		System.out.print("\n");
	}
	public static void main(String[] args) {
		
		printBits(1);
		printBits(1 << 1);
		printBits(1 << 3);
		printBits(1 << 4);
		printBits(1 << 30);
		printBits(-2 ^ Integer.parseInt("1000100000000000000000000000000",2)  >> 5);
		printBits(Integer.parseInt("1000100000000000000000000000000",2) * -1);
	}
}
