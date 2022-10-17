package nixchallenge;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Фактично у вас є одна спроба провести ручку від лівого верхнього кута в правий нижній. Щоб не зайти в глухий кут вам потрібно заздалегідь прорахувати шлях, який має пройти ручка. На щастя, вам відомий алгоритм, згідно з яким замок блокує та розблокує перегородки між комірками.
 *
 * Цей алгоритм заснований на застосуванні функції MD5 до секретного ключа історії переміщення ручки. Це працює таким чином:
 *
 * 1. У вас є ключ (припустимо, iddqd).
 * 2. Ви застосовуєте до нього функцію MD5, отримуючи хеш (в даному випадку 73bcaaa458bff0d27989ed331b68b64d).
 * 3. Далі ви повинні взяти чотири перші символи хешу (у прикладі це 73bc), які будуть відповідати, по порядку, верхній, нижній, лівій та правій перегородці.
 * 4. Символи b, c, d, e, f означають, що дана стінка відкрита, всі інші значення (тобто 0-9, a) означають, що рух в даному напрямку заблоковано (таким чином 73bc відповідає стану закрито-закрито-відкрито-відкрито для верхньої, нижньої, лівої та правої межі відповідно, тобто можна рухати ручку тільки вліво та вправо), а також не можна виходити за межі поля (у нашому випадку рух вліво заблокований рамками самого замку, тому можна рухатись лише вправо);
 * 5. Тепер потрібно зробити вибір, куди рухати ручку. Рух вгору відповідає символу U (обов'язково верхній регістр), вниз D, вліво L, вправо R. Звісно пересунути ручку можна тільки в дозволених напрямках (у нашому прикладі у нас є тільки варіант руху вправо з вихідної позиції).
 * 6. Після того, як ручка переміщена, потрібно додати до поточного коду знак сторони, куди була зсунута ручка (вийде iddqdR);
 * 7. Далі беремо отриманий код і повторюємо все, починаючи з пункту 2, доки ми не доведемо ручку до правого нижнього кута. Як тільки вона опиниться там, замок відкриється.
 *
 * Якщо продовжити наш приклад, то хеш від iddqdR буде 9b423a7ea61769284d0ce77cfe406a0c, перші чотири символи 9b42, де тільки другий символ відповідає відкритому стану - напрямок вниз (D). Рухаємось туди. Новий код – iddqdRD. Хеш від нього - 2a424a40bce71947f49e55f87c67862e. О-о-у, здається, всі перегородки заблоковані (символи 2a42), і ми більше не можемо нікуди рухати ручку. На щастя, це тільки приклад, і iddqd не ваш пароль. Реальний секретний код дозволяє згенерувати успішну комбінацію для відкриття замку. З іншого боку, правильних комбінацій може бути кілька.
 *
 * Ваше завдання реалізувати описаний алгоритм, застосувати його до секретного коду та знайти найкоротший із можливих шляхів. Ця послідовність і вважатиметься правильною відповіддю.
 *
 * Приклад паролiв та вiдповiдним їм послiдовностям наведенi у прикрiпленому файлi
 *
 * Отже, алгоритм ви вже знаєте. А ось ваш код доступу: ysrmzgjo. Успіхів!
 */
public class Task4 {
    public static String getHash (String s ) throws NoSuchAlgorithmException {
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(s.getBytes());
            BigInteger no = new BigInteger(1,messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length()<32){
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e){
            throw new RuntimeException();
        }
    }

    public static String findPath(String s) throws NoSuchAlgorithmException{
        int x = 0;
        int y = 0;

        String loop = s;
        String wrongWay = "";
        try {
            do {
                String hash = getHash(loop);
                String turn = "E";
                char[] hashArray = hash.toCharArray();
                if ((hashArray[0] == 'b' || hashArray[0] == 'c' || hashArray[0] == 'd' || hashArray[0] == 'e' || hashArray[0] == 'f') && (y - 1) >= 0 && !wrongWay.equals("U")) {
                    turn = "U";
                    y--;
                } else if ((hashArray[1] == 'b' || hashArray[1] == 'c' || hashArray[1] == 'd' || hashArray[1] == 'e' || hashArray[1] == 'f') && (y + 1) < 5 && !wrongWay.equals("D")) {
                    turn = "D";
                    y++;
                } else if ((hashArray[2] == 'b' || hashArray[2] == 'c' || hashArray[2] == 'd' || hashArray[2] == 'e' || hashArray[2] == 'f') && (x - 1) >= 0 && !wrongWay.equals("L")) {
                    turn = "L";
                    x--;
                } else if ((hashArray[3] == 'b' || hashArray[3] == 'c' || hashArray[3] == 'd' || hashArray[3] == 'e' || hashArray[3] == 'f') && (x + 1) < 5 && !wrongWay.equals("R")) {
                    turn = "R";
                    x++;
                }
                loop = loop + turn;
                if (turn.equals("E")) {
                    wrongWay = loop.substring(loop.length()-3,loop.length()-2);
                    switch (wrongWay){
                        case "U":
                            y++;
                            break;
                        case "D":
                            y--;
                            break;
                        case "L":
                            x++;
                            break;
                        case "R":
                            x--;
                            break;
                    }
                    loop = loop.substring(0,loop.length()-3);
                    continue;
                }
                wrongWay = "";
            } while ((x != 4) && (y != 4));
        }
        catch (NoSuchAlgorithmException e){
            throw new RuntimeException();
        }
        return loop;
    }


    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(findPath("ysrmzgjo"));
    }
}
