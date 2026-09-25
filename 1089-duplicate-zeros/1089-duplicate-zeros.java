class Solution {
    public void duplicateZeros(int[] arr) {
        int ans[]=new int[arr.length];
        int j=0;
        for(int i=0;i<arr.length && j<arr.length;i++){
            ans[j]=arr[i];
            if(arr[i]==0 && j<arr.length){
                ans[j++]=0;
            }
            j++;
        }
        for (int i=0;i<arr.length;i++){
            arr[i]=ans[i];
        }
    }
}