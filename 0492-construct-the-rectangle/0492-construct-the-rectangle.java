class Solution { 
    public int[] constructRectangle(int area) { 
        int arr[]=new int[2]; 
        for(int i=(int)Math.sqrt(area);i>=1; i--) { 
            if(area%i== 0) { 
                arr[0]= area/i; 
                arr[1]=i; 
                break; 
            } 
        } 
        return arr; 
    } 
}