package leetcode.easy;

public class EquivalentString {
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder1 = new StringBuilder();
        for (String word : word1){
             stringBuilder.append(word);
        }
        for(String word : word2){
           stringBuilder1.append(word);
        }
        return stringBuilder.toString().equals(stringBuilder1.toString());
    }

    public static void main(String[] args) {
        String [] word1 = {"abc", "c"};
        String [] word2 = {"abc"};
        System.out.println(arrayStringsAreEqual(word1,word2));
    }
}
