class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list=new ArrayList();
        int i=0;
        while(i<intervals.length && newInterval[0]>intervals[i][1])
            list.add(intervals[i++]);
        while(i<intervals.length && newInterval[1]>=intervals[i][0]){
            newInterval[0]=Math.min(newInterval[0], intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1], intervals[i++][1]);
        }
        list.add(newInterval);
        while(i<intervals.length)
            list.add(intervals[i++]);
        int[][] res=new int[list.size()][2];
        for(i=0;i<list.size();i++){
            res[i][1]=list.get(i)[1];
            res[i][0]=list.get(i)[0];
        }
        return res;
    }
}