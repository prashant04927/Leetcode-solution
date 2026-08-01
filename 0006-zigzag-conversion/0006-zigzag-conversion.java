class Solution {
    public String convert(String s, int numRows) {
        if( numRows == 1 || s.length() <= numRows){
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for( int i = 0 ; i < numRows ; i ++ ){
            rows.add( new StringBuilder());
        }
        int currentRow = 0;
        boolean goingDown = false;
        // bhar characterr ko shi row me daalo
        
        for ( char c :s.toCharArray()){
            rows.get(currentRow).append(c);
          // first ya last row pey direction badlo
        if (currentRow == 0 || currentRow == numRows -1){
            goingDown = !goingDown;
        }
        // cuurent row ko update kro
        if ( goingDown){
            currentRow++ ;
        }else{
            currentRow--;
        }
    }
        

        //sare row s ko add kre ek final answer banao

        StringBuilder result = new StringBuilder();
        for(StringBuilder row : rows){
            result.append(row);
        }
        return result.toString();


 
    }
}