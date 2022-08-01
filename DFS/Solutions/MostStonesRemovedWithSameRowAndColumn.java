class Solution {
    public int removeStones(int[][] stones) {
        Set<int[]> isVis=new HashSet();
        int numOfIslands = 0;
        for(int[] i:stones){
            if(!isVis.contains(i)){
                numOfIslands++;
                dfs(i, stones, isVis);
            }
        }
        return stones.length-numOfIslands;
    }
    
    private void dfs(int[] s1, int[][] stones, Set<int[]> isVis){
        isVis.add(s1);
        for(int[] s2:stones){
            if(!isVis.contains(s2) && (s1[0]==s2[0] ||s1[1]==s2[1])){
                dfs(s2, stones, isVis);
            }
        }
    }
}
