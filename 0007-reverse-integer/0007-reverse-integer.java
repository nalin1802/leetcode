class Solution {
    public int reverse(int x) {
        int revNo=0;
        
        while(x!=0){ // If we keep x>0 condition, it will not work for -ve numbers
            int lastDigit=x%10;
            
            // Positive overflow
            // Integer.MAX_VALUE = 2147483647
            if (revNo > Integer.MAX_VALUE / 10 ||
                (revNo == Integer.MAX_VALUE / 10 && lastDigit > 7))
                return 0;

            // Negative overflow
            // Integer.MMIN_VALUE = -2147483648
            if (revNo < Integer.MIN_VALUE / 10 ||
                (revNo == Integer.MIN_VALUE / 10 && lastDigit < -8))
                return 0;
        
            revNo=revNo*10+lastDigit;
            x/=10;
        }

        return revNo;
    }
}