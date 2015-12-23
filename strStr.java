class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        
        if( source == null && target != null ){
            return -1;
        }
        if( source != null && target == null ){
            return -1;
        }
        if( source == null && target == null ){
            return -1;
        }
        int sLength = source.length();
        int tLength = target.length();
        int i = 0;
        for(i = 0; i <= sLength - tLength; i++){
            
            int j = 0;
            for( j = 0; j < tLength; j++){
                if( source.charAt(i+j) != target.charAt(j) ){
                    break;
                }
            }
            if( j == tLength ){
                return i;
            }
        }
        return -1;
    }
}
