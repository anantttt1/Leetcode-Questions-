class Solution {
    public int findKthPositive(int[] arr, int k) {
        int count=0;
        int num=1;

        for(int i=0;i<arr.length;i++){
            if(arr[i]==num){
                num++;
            }else{
                count++;
                if(count==k){
                    return num;
                }
                num++;
                i--;
            }
        }

        return num+(k-count)-1;
    }
}