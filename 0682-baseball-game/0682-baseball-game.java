class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> s = new Stack<>();
        String operators="+DC";
        for(String op : operations){

            if(!operators.contains(op)) {
          s.push(Integer.valueOf(op));
            }
            else{
                if(op.equals("C")) {
                    if(!s.isEmpty()) s.pop();
                }
                else if(op.equals("D")){
                    if(!s.isEmpty())
                      s.push(2*s.peek());
                }
                else if(op.equals("+") && !s.isEmpty()){
                    int top1 = s.pop();
                    int top2 =  s.pop();
                     s.push(top2);s.push(top1);
                    s.push(top1+top2);
                }
            }
        }
        int sum =0;
        while(!s.isEmpty())
        {
            System.out.print(s.peek()+ " ");
            sum+=s.pop();
        } 
           
        return sum;
    }
}