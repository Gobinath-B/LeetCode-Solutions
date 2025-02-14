class Solution {
    public String reverseOnlyLetters(String s) {
        int l=0;
        int r= s.length()-1;
        char[] res = new char[s.length()];
        while(l<=r){
        if(Character.isAlphabetic(s.charAt(l)) && Character.isAlphabetic(s.charAt(r))){
            res[l] = s.charAt(r);
            res[r] = s.charAt(l);
            l++;
            r--;
        }
        else if(!Character.isAlphabetic(s.charAt(l))){
            res[l]= s.charAt(l);
            l++;
        }else if(!Character.isAlphabetic(s.charAt(r))){
            res[r]= s.charAt(r);
            r--;
        }
        }
       
        return new String(res);
    }
}