package nixchallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * У вас немає часу дотримуватися цієї інструкції, проходячи весь шлях ногами. Тому ви вирішуєте обчислити вашу точку призначення. Виходячи з того, що ви можете рухатися тільки «*коридорною сіткою лабораторії», яка довжина найкоротшого шляху до щитової?
 *
 * Для прикладу:
 *  - рухаючись R2, L3 переміщає вас на 2 блоки на схід і 3 блоки на північ, або на 5 блоків далі
 *  - R2, R2, R2 переміщає вас на 2 блоки на південь від стартової позиції, що на 2 блоки далі
 *  - R5, L5, R5, R3 переміщає вас на 12 блоків далі
 */

public class Task3 {
    public static int getPath(String s){
        List<String> arrayList = new ArrayList<>();
        arrayList = Arrays.stream(s.split(", ")).toList();
        int startX = 0;
        int startY = 0;
        String face = "north";
        for (int i =0; i < arrayList.size(); i++){
            switch (face) {
                case "north":
                    if (arrayList.get(i).charAt(0) == 'L') {
                        face = "west";
                        startX = startX -  (arrayList.get(i).charAt(1)  - 48) ;
                    } else if (arrayList.get(i).charAt(0) == 'R') {
                        face = "east";
                        startX = startX +  Integer.parseInt(arrayList.get(i).substring(1)) ;
                    }
                    break;
                case "west":
                    if (arrayList.get(i).charAt(0) == 'L') {
                        face = "south";
                        startY = startY -  Integer.parseInt(arrayList.get(i).substring(1)) ;
                    } else if (arrayList.get(i).charAt(0) == 'R') {
                        face = "north";
                        startY = startY +  Integer.parseInt(arrayList.get(i).substring(1)) ;
                    }
                    break;
                case "south":
                    if (arrayList.get(i).charAt(0) == 'L') {
                        face = "east";
                        startX = startX +  Integer.parseInt(arrayList.get(i).substring(1)) ;
                    } else if (arrayList.get(i).charAt(0) == 'R') {
                        face = "west";
                        startX = startX -  Integer.parseInt(arrayList.get(i).substring(1)) ;
                    }
                    break;
                case "east":
                    if (arrayList.get(i).charAt(0) == 'L') {
                        face = "north";
                        startY = startY +  Integer.parseInt(arrayList.get(i).substring(1)) ;
                    } else if (arrayList.get(i).charAt(0) == 'R') {
                        face = "south";
                        startY = startY -  Integer.parseInt(arrayList.get(i).substring(1)) ;
                    }
                    break;
            }
        }
        System.out.println("startX = " + startX + " startY = " + startY);
        return startX + startY;
    }

    public static void main(String[] args) {
        String path1 = "R5, L5, R5, R3";
String path = "L2, L3, L3, L4, R1, R2, L3, R3, R3, L1, L3, R2, R3, L3, R4, R3, R3, L1, L4, R4, L2, R5, R1, L5, R1, R3, L5, R2, L2, R2, R1, L1, L3, L3, R4, R5, R4, L1, L189, L2, R2, L5, R5, R45, L3, R4, R77, L1, R1, R194, R2, L5, L3, L2, L1, R5, L3, L3, L5, L5, L5, R2, L1, L2, L3, R2, R5, R4, L2, R3, R5, L2, L2, R3, L3, L2, L1, L3, R5, R4, R3, R2, L1, R2, L5, R4, L5, L4, R4, L2, R5, L3, L2, R4, L1, L2, R2, R3, L2, L5, R1, R1, R3, R4, R1, R2, R4, R5, L3, L5, L3, L3, R5, R4, R1, L3, R1, L3, R3, R3, R3, L1, R3, R4, L5, L3, L1, L5, L4, R4, R1, L4, R3, R3, R5, R4, R3, R3, L1, L2, R1, L4, L4, L3, L4, L3, L5, R2, R4, L2";
        System.out.println(getPath(path));
    }
}
