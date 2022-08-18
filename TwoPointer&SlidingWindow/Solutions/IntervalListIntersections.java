class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res=new ArrayList();
        int i=0, j=0;
        
        while(i<firstList.length && j<secondList.length){
            int low=Math.max(firstList[i][0], secondList[j][0]);
            int high=Math.min(firstList[i][1], secondList[j][1]);
            
            if(low<=high)
                res.add(new int[]{low, high});
            
            if(firstList[i][1]<secondList[j][1])
                i++;
            else 
                j++;
        }
        
        int[][] ans=new int[res.size()][2];
        i=0;
        for(int[] a : res){
            ans[i][0]=a[0];
            ans[i++][1]=a[1];
        }
        
        return ans;
    }
}