class Solution {
    public String longestPalindrome(String s) {
        if (s.length()<=1)
            return s;
        int max = 1;
        String str=s.substring(0,1);
        for (int i = 0; i < s.length(); i++) {

            for (int j=i+max+1;j<=s.length();j++){
                String s1=s.substring(i,j);

                if (isHuiwen(s1)){//是回文子串
                    if (max<s1.length()){
                        max=s1.length();
                        str=s1;
//                        System.out.println(s1);
                    }
                }
            }

        }
//        System.out.println(max);
        return str;
    }
    public boolean isHuiwen(String string){
        for (int i=0;i<string.length()/2;i++){
            if (string.charAt(i)!=string.charAt(string.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}