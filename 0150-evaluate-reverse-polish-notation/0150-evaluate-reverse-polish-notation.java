class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();

        for(String token : tokens){

            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"))
            {
                 //evaluate operations and push back in stack
                   int num2 = s.pop();
                   int num1 = s.pop();
                   if(token.equals("+")) s.push(num1+num2);
                   else if(token.equals("-")) s.push(num1-num2);
                   else if(token.equals("*")) s.push(num1*num2);
                   else if(token.equals("/")) s.push(num1/num2);
            }
            else{
                s.push(Integer.parseInt(token));
            }
        }
        return s.pop();
    }
}