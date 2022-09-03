class Solution {
    private void dfs(int i, int[][] graph, List<List<Integer>> res, List<Integer> list){
        list.add(i);
        if(i==graph.length - 1){
            res.add(new ArrayList(list));
        }else{
            for(int it:graph[i])
                dfs(it, graph, res, list);
        }
        list.remove(list.size()-1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res=new ArrayList();
        dfs(0, graph, res, new ArrayList());
        return res;
    }
}