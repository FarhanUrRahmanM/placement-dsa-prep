class Solution {
    public int compress(char[] chars) {
        int i=0,j=0,n=chars.length;
        while(i<n){
            char c=chars[i];
            int count=0;
            while(i<n&&chars[i]==c){
                i++;
                count++;
            }
            chars[j++]=c;
            if(count>1){
                for(char d:String.valueOf(count).toCharArray())
                    chars[j++]=d;
            }
        }
        return j;
    }
}