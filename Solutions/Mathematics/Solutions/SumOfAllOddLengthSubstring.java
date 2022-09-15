// Prefix Sum
class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n=arr.length;
        int[] prefix=new int[n];
        prefix[0]=arr[0];
        for(int i=1;i<n;i++)
            prefix[i]=prefix[i-1]+arr[i];
        int res=0;
        for (int i=0; i<n; i++)
            for (int j=0; j+i<n; j+=2) 
                res += sum(prefix, i, j + i);
        return res;
    }
    
    private int sum(int[] arr, int start, int last){
        return start==0?arr[last]:arr[last]-arr[start-1];
    }
}


// Mathematics
class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n=arr.length, res=0;
        for(int i=0;i<n;i++)
            res+=(((i+1)*(n-i))+1)/2 * arr[i];
        return res;
    }
}