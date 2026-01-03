class Solution {
    public int minOperations(String[] logs) {
        Stack<String> s = new Stack<>();
        for(String log: logs){

           if(log.equals("./")) continue;
           else if(log.equals("../")){
               if(!s.isEmpty())
                 s.pop();
           }
           else s.push(log);
        }
         int count=0;
        while(!s.isEmpty()) {
            count++;
            s.pop();
        }
        return count;
    }
}