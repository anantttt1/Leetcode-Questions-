import java.util.*;
class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n=servers.length;
        int m=tasks.length;
        int[] res=new int[m];
        PriorityQueue<int[]> free=new PriorityQueue<>((a, b) -> a[0] != b[0] ? Integer.compare(a[0],b[0]) : Integer.compare(a[1],b[1]));
        PriorityQueue<int[]> busy=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        for(int i=0;i<n;i++){
            free.offer(new int[]{servers[i],i});
        }
        int time=0;
        for(int i=0;i<m;i++){
            time=Math.max(time,i);
            if(free.isEmpty()&&busy.peek()[0]>time){
                time=busy.peek()[0];
            }
            while(!busy.isEmpty()&&busy.peek()[0]<=time){
                int[] server=busy.poll();
                free.offer(new int[]{server[1],server[2]});
            }
            int[] current=free.poll();
            res[i]=current[1];
            busy.offer(new int[]{time+tasks[i],current[0],current[1]});
        }
        return res;
    }
}
