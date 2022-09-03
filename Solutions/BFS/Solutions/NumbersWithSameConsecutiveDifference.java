class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> res=Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        for(int i=2;i<=n;i++){
            List<Integer> res2=new ArrayList();
            for(int x:res){
                int y=x%10;
                if(y+k<10){
                    res2.add(x*10+y+k);
                }
                if(k>0 && y-k>=0){
                    res2.add(x*10+y-k);
                }
            }
            res=res2;
        }
        return res.stream().mapToInt(i->i).toArray();
    }
}