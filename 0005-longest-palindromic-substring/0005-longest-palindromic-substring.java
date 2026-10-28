class Solution {
    public String longestPalindrome(String s) {
        int maxlen=0,st=0;
        int n=s.length();

        for(int i=0;i<n;i++){
            int h=i,l=i;
            while(h<n && l>=0){
                if(s.charAt(h)==s.charAt(l)){
                    h++;
                    l--;
                }else{
                    break;
                }
            }
            int oddlen=h-l-1;
            if(oddlen>maxlen){
                maxlen=oddlen;
                st=l+1;
            }
            h=i+1;
            l=i;
             while(h<n && l>=0){
                if(s.charAt(h)==s.charAt(l)){
                    h++;
                    l--;
                }else{
                    break;
                }
            }
            int evenlen=h-l-1;
            if(evenlen>maxlen){
                maxlen=evenlen;
                st=l+1;
            }
            
        }
        return s.substring(st,st+maxlen);
    }
}