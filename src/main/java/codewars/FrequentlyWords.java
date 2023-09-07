package codewars;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.groupingBy;

public class FrequentlyWords {
    public static void main(String[] args) {
        System.out.println(top3("  '''  "));
    }

    public static List<String> top3 (String s) {
        s = s.replaceAll("[./;:,@#$%^&*()_\\-+=1234567890!?]", " ")
                .toLowerCase();
        s = s.replaceAll(" ''' ", "");
        s = s.replaceAll(" '' ", " ");
        s = s.replaceAll(" ' ", " ");
        String[] strings = s.split(" ");
        HashMap<String, Integer> cntMap = new HashMap<>();
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (String str:
                strings) {
            if (cntMap.containsKey(str.trim()) && !str.trim().equals("")){
                cntMap.put(str,cntMap.get(str.trim()) + 1);
            } else if (!str.trim().equals("")) {
                cntMap.put(str.trim(),1);
            }
        }


        for (Map.Entry<String, Integer> entry : cntMap.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list);
        Collections.reverse(list);
        for (int num : list) {
            for (Map.Entry<String, Integer> entry : cntMap.entrySet()) {
                if (entry.getValue().equals(num)) {
                    sortedMap.put(entry.getKey(), num);
                }
            }
        }

        System.out.println(sortedMap);
        Iterator<Map.Entry<String, Integer>> iterator = sortedMap.entrySet().iterator();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < sortedMap.size(); i++){
            if (i == 3) {break;}
            result.add(iterator.next().getKey());
        }
        return result;
    }

    public static List<String> bestPractice(String s) {
        return Arrays.stream(s.toLowerCase().split("[^a-z*|']"))
                .filter(o -> !o.isEmpty() && !o.replace("'", "").isEmpty())
                .collect(groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(Map.Entry::getKey)
                .limit(3)
                .collect(Collectors.toList());
    }
}
