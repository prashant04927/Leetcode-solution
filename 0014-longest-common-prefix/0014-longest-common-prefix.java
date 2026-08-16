class Solution {
    public String longestCommonPrefix(String[] strs) {
        String Prefix = strs[0];
        for (int i =1 ; i < strs.length ; i++){
            while(!strs[i].startsWith(Prefix)){
            Prefix = Prefix.substring(0, Prefix.length() - 1);
            if( Prefix.isEmpty()){
                return"";
            }
            }

        }
        return Prefix;
    }
}