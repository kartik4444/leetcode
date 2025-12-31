class Solution {
    public int[] asteroidCollision(int[] asteroids) {
            Stack<Integer> s = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            int curritem = asteroids[i];
            boolean alive = true;

            // collision only when stack top > 0 and current < 0
            while (alive && !s.isEmpty() && s.peek() > 0 && curritem < 0) {

                if (Math.abs(curritem) > Math.abs(s.peek())) {
                    s.pop();                 // stack asteroid destroyed
                } 
                else if (Math.abs(curritem) == Math.abs(s.peek())) {
                    s.pop();                 // both destroyed
                    alive = false;
                } 
                else {
                    alive = false;           // current asteroid destroyed
                }
            }

            if (alive) {
                s.push(curritem);             // only survivors go to stack
            }
        }

        // convert stack to array
        int[] res = new int[s.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = s.pop();
        }
        return res;
    }
}