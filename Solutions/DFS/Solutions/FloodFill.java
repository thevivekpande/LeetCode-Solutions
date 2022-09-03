class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int clr=image[sr][sc];
        if(clr!=color) helper(image, sr, sc, color, clr);
        return image;
    }
    public void helper(int[][] image, int sr, int sc, int newColor, int color){
        if(sr<0 || sr>=image.length || sc<0 || sc>=image[0].length || image[sr][sc]!=color) return;
        image[sr][sc]=newColor;
        helper(image, sr+1, sc, newColor, color);
        helper(image, sr, sc+1, newColor, color);
        helper(image, sr-1, sc, newColor, color);
        helper(image, sr, sc-1, newColor, color);
    }
}