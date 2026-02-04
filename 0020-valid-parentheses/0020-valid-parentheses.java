class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(Character ch : s.toCharArray())
        {
           Character peekch= null;
           if(ch == ')' && !stack.isEmpty())
           {
              if(stack.peek()=='(') stack.pop();
              else return false;
           }
           else if(ch == '}' && !stack.isEmpty())
           {
             if(stack.peek()=='{') stack.pop();
              else return false;
           }
           else if(ch == ']' && !stack.isEmpty())
           {
              if(stack.peek()=='[') stack.pop();
              else return false;
           }
            else
             stack.push(ch);
        }
        if(stack.isEmpty())return true;
        return false;
    }
}