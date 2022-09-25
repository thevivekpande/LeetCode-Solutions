class Solution {
    public String frequencySort(String s) {
        int[] count=new int[256];
        for(char ch:s.toCharArray())
            count[ch]++;
        PriorityQueue<Character> pq=new PriorityQueue<>((a,b)->count[b]-count[a]);
        for(int i=0;i<256;i++)
            pq.add((char)i);
        StringBuilder res=new StringBuilder();
        while(!pq.isEmpty()){
            char ch=pq.poll();
            for(int i=0;i<count[ch];i++)
            res.append(ch);
        }
        return res.toString();
    }
}