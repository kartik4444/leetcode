class Solution {
    class Pair {
        int count;
        int nextAvailableTime;

        public Pair(int count, int nextAvailableTime) {
            this.count = count;
            this.nextAvailableTime = nextAvailableTime;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        // Max-Heap comparator
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Pair> q = new LinkedList<>();
        
        int[] freq = new int[26];
        for (char task : tasks) freq[task - 'A']++;
        for (int f : freq) if (f > 0) maxheap.offer(f);

        int time = 0;
        while (!maxheap.isEmpty() || !q.isEmpty()) {
            time++;

            if (!maxheap.isEmpty()) {
                int remaining = maxheap.poll() - 1;
                if (remaining > 0) {
                    // Task is available again after 'n' cooling intervals
                    q.offer(new Pair(remaining, time + n));
                }
            }

            // Check if any task is done with its cooling period
            if (!q.isEmpty() && q.peek().nextAvailableTime == time) {
                maxheap.offer(q.poll().count);
            }
        }
        return time;
    }
}