class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits .length () == 0){
            return ans ;
        }
        String [] map = {
            "", "" , "abc" , "def" , "ghi" , "jkl" , "mno" , "pqrs" , "tuv" , "wxyz"
        };
        backtrack(0 , digits , "" , map ,ans );
        return ans ;
    }
        private void backtrack(int index , String digits , String current , String[] map ,List<String> ans ){

            if (index == digits.length()){
            ans.add(current);
            return;
        }
            int digit = digits.charAt(index) - '0';
            String letters = map [digit];
            for  (char ch : letters.toCharArray()){
                backtrack(index + 1 , digits , current + ch , map , ans );
            }
        }

        
    }
