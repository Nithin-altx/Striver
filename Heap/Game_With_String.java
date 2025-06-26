class Solution {
        static class Pair {
        char ch;
        int freq;

        Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }
    public int minValue(String s, int k) {
        // code here
        
            Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
    
        int res=0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
    if (b.freq != a.freq)
        return b.freq - a.freq;     // Higher frequency first
    else
        return b.ch - a.ch;         // Higher ASCII first if tie
});

  for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
        }
        while(!pq.isEmpty()&&k>0)
        {
            Pair p=pq.poll();
            char h=p.ch;
            int f=p.freq;
            f--;
            k--;
            pq.offer(new Pair(h,f));
        }
        while(!pq.isEmpty())
        {
            Pair p=pq.poll();
            res+=p.freq*p.freq;
        }

    
        return res;
    }
}
