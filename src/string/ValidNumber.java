package string;
/** 
 * https://oj.leetcode.com/problems/valid-number/
 */
public class ValidNumber {
	enum State {
		START, SIGNAL, NUMBER_INTEGER, DOT_START, DOT, EXPONENT, NUMBER_DECIMAL, SIGNAL_EXPONENT, NUMBER_EXPONENT,  END
	}

	public boolean isNumber(String s) {
		State state = State.START;
		int i = 0;
		while (i < s.length()) {
			char c = s.charAt(i);
			switch (state) {
			case START:
				if (isNumber(c))
					state = State.NUMBER_INTEGER;
				else if( c == '-' || c == '+' )
					state = State.SIGNAL;
				else if (c == '.')
					state = State.DOT_START;
				else if (c == ' ')
					state = State.START;
				else
					return false;
				break;
			case SIGNAL:
				if (c == '.')
					state = State.DOT_START;
				else if (isNumber(c))
					state = State.NUMBER_INTEGER;
				else
					return false;
				break; 
			case NUMBER_INTEGER:
				if (isNumber(c))
					break;
				else if (c == '.')
					state = State.DOT;
				else if (c == 'e')
					state = State.EXPONENT;
				else if (c == ' ')
					state = State.END;
				else
					return false;
				break;
			case DOT_START:
				if (isNumber(c))
					state = State.NUMBER_DECIMAL;
				else 
					return false;
				break;
			case DOT:
				if (isNumber(c))
					state = State.NUMBER_DECIMAL;
				else if (c == ' ')
					state = State.END;
				else if (c == 'e')
					state = State.EXPONENT;
				else
					return false;
				break;
			case EXPONENT:
				if (isNumber(c) )
					state = State.NUMBER_EXPONENT;
				else if ( c == '-' || c == '+')
					state = State.SIGNAL_EXPONENT;
				else 
					return false;
				break;
			case SIGNAL_EXPONENT:
				if((isNumber(c)))
					state = State.NUMBER_EXPONENT;
				else 
					return false;
				break;
			case NUMBER_DECIMAL:
				if (isNumber(c))
					break;
				else if (c == 'e')
					state = State.EXPONENT;
				else if (c == ' ')
					state = State.END;
				else
					return false;
				break;
			case NUMBER_EXPONENT:
				if (isNumber(c))
					break;
				else if (c == ' ')
					state = State.END;
				else
					return false;
				break;
			case END:
				if (c == ' ')
					break;
				else
					return false;
			default:
				break;
			}
			i++;
		}
		return state == State.DOT || state == State.NUMBER_INTEGER || state == State.NUMBER_DECIMAL
				|| state == State.NUMBER_EXPONENT || state == State.END;
	}

	private boolean isNumber(char c) {
		return c >= 48 && c <= 57;
	}

	public static void main(String[] args) {
		assertEquals(". ", false);
		assertEquals("3. ", true);
		assertEquals("3.", true);
		assertEquals(".", false);
		assertEquals("a", false);
		assertEquals("1", true);
		assertEquals("1.", true);
		assertEquals("1.0", true);
		assertEquals("1.0a", false);
		assertEquals("1e10", true);
		assertEquals("1 b", false);
		assertEquals("-1e10", true);
		assertEquals("1e-10", true);
		assertEquals("1.1e-10", true);
		assertEquals("a", false);
		assertEquals(" 1", true);
		assertEquals("1.", true);
		assertEquals(" 1.0 ", true);
		assertEquals("1.0a", false);
		assertEquals("1e10 ", true);
		assertEquals("1 b", false);
		assertEquals(" -1e10", true);
		assertEquals("1e-10 ", true);
		assertEquals(" 1.1e-10", true);
		assertEquals(" .1 ", true);
		assertEquals("+.8", true);
		assertEquals(" -.", false);
		assertEquals(" +0e-", false);
		assertEquals("10e-", false);
		assertEquals("46.e3", true);
		assertEquals(".e1", false);
		assertEquals("6ee69", false);
		assertEquals("005047e+6", true);
	}

	private static void assertEquals(String a, boolean expected) {
		ValidNumber validNumber = new ValidNumber();
		boolean actual = validNumber.isNumber(a);
		String result = actual == expected ? "OK" : "NOK";
		System.out.println(result + ": Testing '" + a + "' actual: " + actual
				+ " expected: " + expected);
	}
}
