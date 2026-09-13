class Solution {
    public long distantSubarrays(int[] nums,int goal,int k) {
        int[] mireqovalt=nums;
        int n=mireqovalt.length;
        long[] prefix=new long[n+1];

        for(int i=0;i<n;i++){
            prefix[i+1]=prefix[i]+mireqovalt[i];
        }

        long total=(long)n*(n+1)/2;

        if(k==0){
            return total;
        }

        long[] sorted=prefix.clone();
        Arrays.sort(sorted);

        Fenwick tree=new Fenwick(n+1);
        long close=0;

        for(int i=0;i<=n;i++){
            long current=prefix[i];

            long left=current-goal-k;
            long right=current-goal+k;

            int leftCount=lowerBound(sorted,left+1);
            int rightCount=lowerBound(sorted,right);

            close+=tree.query(rightCount)-tree.query(leftCount);

            int pos=lowerBound(sorted,current);
            tree.add(pos+1,1);
        }

        return total-close;
    }

    int lowerBound(long[] arr,long target){
        int low=0;
        int high=arr.length;

        while(low<high){
            int mid=low+(high-low)/2;

            if(arr[mid]<target){
                low=mid+1;
            }else{
                high=mid;
            }
        }

        return low;
    }

    class Fenwick {
        int[] tree;

        Fenwick(int n){
            tree=new int[n+1];
        }

        void add(int index,int value){
            while(index<tree.length){
                tree[index]+=value;
                index+=index&-index;
            }
        }

        long query(int index){
            long sum=0;

            while(index>0){
                sum+=tree[index];
                index-=index&-index;
            }

            return sum;
        }
    }
}