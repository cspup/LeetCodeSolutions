import java.util.ArrayList;

class Solution{
    public String[] findOcurrences(String text, String first, String second) {
        String[] strings=text.split(" ");
        ArrayList<String> str = new ArrayList<String>();
        int index=0;
        for (int i=0;i<strings.length-2;i++){
            if (strings[i].equals(first)&&strings[i+1].equals(second)){
                str.add(strings[i+2]);
            }
        }
        return str.toArray(new String[str.size()]);
    }
}