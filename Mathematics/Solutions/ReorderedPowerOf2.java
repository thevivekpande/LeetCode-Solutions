// using bit manipulation and array
class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] res=count(n);
        for(int i=0;i<=31;i++){
            if(Arrays.equals(res, count(1<<i)))
                return true;
        }
        return false;
    }
    private int[] count(int n){
        int[] arr=new int[10];
        while(n>0){
            arr[n%10]++;
            n/=10;
        }
        return arr;
    }
}


// using mathematics and long 
class Solution {
    public boolean reorderedPowerOf2(int n) {
        long res=count(n);
        for(int i=0;i<=31;i++){
            if(res == count(1<<i))
                return true;
        }
        return false;
    }
    private long count(int n){
        long arr=0l;
        while(n>0){
            arr+=Math.pow(10,n%10);
            n/=10;
        }
        return arr;
    }
}