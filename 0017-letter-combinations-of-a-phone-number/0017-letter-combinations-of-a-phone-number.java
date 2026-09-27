import java.util.ArrayList;
import java.util.List;
class Solution {
    public List<String> letterCombinations(String digits){
        List<String> result=new ArrayList<>();
        if(digits==null || digits.isEmpty()){
            return result;
        }
        String[] mapping ={
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        result.add("");
        for(char digitChar : digits.toCharArray()){
            int digit=digitChar-'0';
            String letters=mapping[digit];
            List<String> temp=new ArrayList<>();
            for(String savedString:result){
                for(char letter:letters.toCharArray()){
                    temp.add(savedString+letter);
                }
            }
            result=temp;
        }

        return result;
    }
}
