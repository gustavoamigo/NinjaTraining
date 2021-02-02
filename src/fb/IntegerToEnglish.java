package fb;

/*
https://leetcode.com/problems/integer-to-english-words/
 */
public class IntegerToEnglish {
    public String numberToWords(int num) {
        if(num < 10 ) return tens(num);
        if(num < 100) return belowHundred(num);
        if(num < 1000) return belowThousand(num);
        if(num < 1000000) return belowMillian(num);
        if(num < 1000000000) return belowBillian(num);
        return aboveBillian(num);
    }

    private String aboveBillian(int num) {
        int belowMillianPart = num % 1000000000;
        if(belowMillianPart == 0) {
            return numberToWords(num / 1000000000) + " Billion";
        } else {
            return numberToWords(num / 1000000000) + " Billion " + numberToWords(belowMillianPart);
        }
    }

    private String belowBillian(int num) {
        int belowMillianPart = num % 1000000;
        if(belowMillianPart == 0) {
            return numberToWords(num / 1000000) + " Million";
        } else {
            return numberToWords(num / 1000000) + " Million " + numberToWords(belowMillianPart);
        }
    }

    private String belowMillian(int num) {
        int belowThousantPart = num % 1000;
        if(belowThousantPart == 0) {
            return numberToWords(num / 1000) + " Thousand";
        } else {
            return numberToWords(num / 1000) + " Thousand " + numberToWords(belowThousantPart);
        }
    }

    private String belowThousand(int num) {
        if(num < 100) return belowHundred(num);
        if(num % 100 == 0) return tens(num / 100 % 10) + " Hundred";
        return belowHundred(num / 100) + " Hundred " +  belowHundred(num % 100);
    }

    private String belowHundred(int num) {
        if(num < 10) return tens(num);
        String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        if(num <= 19) return teens[num];
        String[] tyies = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        return num % 10 == 0 ? tyies[ num / 10 -1]: tyies[num/ 10 - 1] + " " + tens(num%10);
    }

    private String tens(int num) {
        String[] tens = {"Zero", "One", "Two", "Three","Four", "Five", "Six", "Seven", "Eight", "Nine"};
        return tens[num];
    }
}
