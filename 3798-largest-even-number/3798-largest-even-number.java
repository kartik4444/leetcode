class Solution {
    public String largestEven(String s) {
        //loop from end of string , wherever s.chatAt(i)%2==0 return substring from 0 till i+1
        //when loop ends, number not possible return empty
        for(int i=s.length()-1;i>=0;i--){
           if(Integer.valueOf(s.charAt(i))%2==0) return s.substring(0,i+1);
        }
        return s.substring(0,0);
        
    }
}