class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0)
            return 0;
        int max = 1;

        for (int i = 0; i < s.length(); i++) {

            for (int j=i+max+1;j<=s.length();j++){
                String s1=s.substring(i,j);
                System.out.println(s1);
                if (!isRepeat(s1)){//不含重复字符
                    if (max<s1.length()){
                        max=s1.length();
                    }
                }
                else {
                    break;
                }
            }

        }
//        System.out.println(max);
        return max;
    }
    public boolean isRepeat(String string){//是否含重复字符
        for (int i=0;i<string.length();i++){
            char ch=string.charAt(i);
            if (string.lastIndexOf(ch)!=i){
                return true;//含重复字符
            }
        }
        return false;
    }
}