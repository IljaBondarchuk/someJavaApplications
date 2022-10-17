package nixchallenge;

/**
 *  - у розрахунок беремо лише 6-значні комбінації
 *  - комбінації входять до діапазону чисел, які будуть дані у вихідних даних для завдання
 *  - дві сусідні цифри в комбінації можуть бути однаковими (наприклад 22 в 122345)
 *  - ліворуч цифри ніколи не зменшуються, вони або збільшуються, або залишаються тими ж (наприклад 11123 або 135679)
 *
 * Враховуючи правила, зазначені вище, наступне є вірним:
 *
 * - 111111 задовольняє вимогам (подвоєння 11, ніколи не зменшується)
 * - 223450 не відповідає вимогам (зменшується пара цифр 50)
 * - 123789 не відповідає вимогам (немає подвійних цифр)
 *
 * Паролем є кількість комбінацій чисел, що задовольняють правилам в діапазоні 123117-733395.
 */
public class Task1 {
    public static boolean isPassword(int pass) {
        char[] charNums = String.valueOf(pass).toCharArray();
        int[] digits = new int[charNums.length];
        for(int i=0; i<charNums.length; i++){
            digits[i] = charNums[i]-48;//convert char to int
        }
        boolean result = false;
        for (int i = 0; i < digits.length -1 ; i++){
            if (digits[i] > digits[i+1]) return false;
            if (digits[i] == digits[i+1]) {
                result = true;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int result = 0;
        for (int i = 123117; i <= 733395; i++){
            if(isPassword(i)){
                result++;
            }
        }
        System.out.println(result);
    }
}
