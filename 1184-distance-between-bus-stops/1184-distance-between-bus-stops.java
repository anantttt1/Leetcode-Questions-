class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int t=0;
        int d=0;
        for(int num:distance){
            t+=num;
        }
        if(start>destination){
            int temp=start;
            start=destination;
            destination=temp;
        }
        for(int i=start;i<destination;i++){
            d+=distance[i];
        }
        return  Math.min(d,t-d);
    }
}