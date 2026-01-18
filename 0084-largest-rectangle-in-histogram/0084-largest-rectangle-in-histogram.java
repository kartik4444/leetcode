class Solution {
    class pair {
        int index;
        int height;

       public pair(int index,int height){
            this.index=index;
            this.height=height;
        }
    }

    public int largestRectangleArea(int[] heights) {
        Stack<pair> s = new Stack<>();
        int start = 0;
        int n = heights.length;
        int maxarea = -1;

        for (int i = 0; i < n; i++) {
            //assume current bar can be extended to left till current bar index i hence start = i
            start = i;
            //while popping greater height bar keep updating start = popped index 
            //meaning we are extending current bar width as big as possible
            while (!s.isEmpty() && s.peek().height > heights[i]) {
                int height = s.peek().height;
                int index = s.peek().index;
                int width = i - index;
                //calculate area for each stack top bar popped coz it cant be extended to right more and its             left index is already present in current stack pair
                maxarea = Math.max(maxarea, height * width); 
                s.pop();
                start=index; // extending current bar width to left as much as possible
            }
            s.push(new pair(start, heights[i]));
        }
         
         //remaining height in stack can be extended till last n = height.length
         // and its index means it can be extended till that index hence width = n-index
        while (!s.isEmpty()) {
            int height = s.peek().height;
            int index = s.peek().index;
            int width = n-index;
            maxarea = Math.max(maxarea,height*width);
            s.pop();
        }
        return maxarea;
    }
}