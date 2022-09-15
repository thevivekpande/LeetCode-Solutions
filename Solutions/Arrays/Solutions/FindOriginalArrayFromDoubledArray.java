class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n=changed.length;
        if(n%2==1) return new int[0];
        int[] res=new int[n/2];
        
        Map<Integer, Integer> map=new TreeMap<>();
        for(int i:changed)
            map.put(i, map.getOrDefault(i, 0)+1);
        int c=0;
        
        for(int i:map.keySet()){
            if(map.get(i)>map.getOrDefault(2*i, 0))
                return new int[0];
            
            for(int ii=0;ii<map.get(i);ii++){
                res[c++]=i;
                map.put(2*i, map.get(2*i)-1);
            }
        }
        return res;
    }
}