class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int max=0;
        int count=0;
        for(int i=0;i<rectangles.length;i++){
            int side=Math.min(rectangles[i][0],rectangles[i][1]);
            if(side>max){
                max=side;
                count=1;
            }else if(side==max){
                count++;
            }
        }
        return count;
    }
}