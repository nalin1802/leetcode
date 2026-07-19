class Solution {
    public int reverse(int x) {
        int revNo = 0;
        int MAX_LIMIT = Integer.MAX_VALUE / 10;
        int MIN_LIMIT = Integer.MIN_VALUE / 10;

        while (x != 0) {
            int lastDigit = x % 10;

            if (revNo > MAX_LIMIT || (revNo == MAX_LIMIT && lastDigit >= 7))
                return 0;
            if (revNo < MIN_LIMIT || (revNo == MIN_LIMIT && lastDigit <= -8))
                return 0;

            revNo = revNo * 10 + lastDigit;

            x /= 10;
        }

        return revNo;
    }

    public boolean isPalindrome(int x) {
        // brute force approach 
        /*
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;
        
        return x == reverse(x);  
        */ 

        // optimal approach
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;

        int revHalfNo = 0;

        while (x > revHalfNo) {
            revHalfNo = revHalfNo * 10 + x % 10;
            x /= 10;
        }

        return x == revHalfNo || x == revHalfNo / 10;
    }
}