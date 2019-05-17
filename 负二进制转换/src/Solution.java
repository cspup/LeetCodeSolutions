public class Solution {
    public String baseNeg2(int N) {
        String s;

        while(N!=0){
            System.out.println(N%(-2));
//            if (N%(-2)==0){
//                System.out.println("0");
//
//            }
//            else if (N%(-2)==-1){
//                System.out.println("1");
//                N=N*2;
//            }
            if (N>0){
                N=N/(2);
            }
            else
            N=N/(-2);

        }
        return "sss";
    }
}