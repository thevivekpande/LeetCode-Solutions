class Solution {
    private int countBit(int n){
        int res=0;
        while(n>0){
            n=n&(n-1);
            res++;
        }
        return res;
    }
    public int[] sortByBits(int[] arr) {
        int n=arr.length;
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            res[i]=countBit(arr[i])*10001 + arr[i];
        }
        
        Arrays.sort(res);
        for(int i=0;i<n;i++)
            res[i]%=10001;
        
        return res;
    }
}