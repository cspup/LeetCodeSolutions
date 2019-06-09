public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        String text="jkypmsxd jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa kcyxdfnoa jkypmsxd kcyxdfnoa";
        String first="kcyxdfnoa";
        String second="jkypmsxd";
        String string[]=new Solution().findOcurrences(text,first,second);
        for (int i=0;i<string.length;i++){
            System.out.println(string[i]);
        }
    }
}
