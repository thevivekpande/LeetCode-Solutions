/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start=1, last=n;
        while(start<last){
            int mid=start+((last-start)>>1);
            if(!isBadVersion(mid))
                start=mid+1;
            else last=mid;
        }
        return start;
    }
}