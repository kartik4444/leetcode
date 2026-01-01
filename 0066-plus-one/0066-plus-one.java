class Solution {
    public int[] plusOne(int[] digits) {
        int lastindex = digits.length-1;
        int carry=0;
        carry = (1+digits[lastindex])/10;
        digits[lastindex] = (1+digits[lastindex])%10;
        lastindex--;
       while(lastindex>=0){
        int num = digits[lastindex]+carry;
        if(num>=10){
           carry = num/10;
           digits[lastindex]=num%10;
        }
        else {
            digits[lastindex] = num;
            return digits;
        }
       lastindex--;
       }
       if(carry!=0){
          int[] res = new int[digits.length+1];
          res[0] = carry;
          int index=1;
         for(int digit:digits){
            res[index] = digit; index++;
         }
          return res;
       }
        return digits;
    }
}