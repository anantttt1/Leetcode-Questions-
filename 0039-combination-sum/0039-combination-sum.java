class Solution { 
    public List<List<Integer>> combinationSum(int[] candidates, int target) { 
        List<List<Integer>> result=new ArrayList<>(); 
        combinations(0, candidates, target, new ArrayList<>(), result); 
        return result; 
    } 
    private void combinations(int i, int[] candidates, int target, List<Integer> list, List<List<Integer>> result){
        if(target==0){
            result.add(new ArrayList<>(list));
            return;
        }
        if(i==candidates.length || target<0){
            return;
        }
        if(candidates[i]<=target){
            list.add(candidates[i]);
            combinations(i, candidates, target - candidates[i], list, result); 
            list.remove(list.size() - 1);
        } 
        combinations(i+1,candidates, target, list, result); 
    } 
}
