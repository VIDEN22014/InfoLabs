import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class FibbonachiGenerator {
    public static void generate(String keywordFileName, String outputFileName) throws IOException {
        FileReader keywordReader = new FileReader(keywordFileName);
        Scanner keywordScanner = new Scanner(keywordReader);
        FileWriter outputWriter = new FileWriter(outputFileName);
        String str = "";
        //Вивід даних про автора
        System.out.println("Роботу виконав Гуменюк Богдан КН-21 Варіант №5\nМетод Фібоначчі з запізнюваннями (спрощений Аддитивний метод).\n");
        outputWriter.write("Роботу виконав Гуменюк Богдан КН-21 Варіант №5\nМетод Фібоначчі з запізнюваннями (спрощений Аддитивний метод).\n");
        HashMap<Long, Long> hashMap = new HashMap<>();
        int a;
        int b;
        a = keywordScanner.nextInt();
        b = keywordScanner.nextInt();
        if (a>=b||a<=0||b<=0){
            System.out.println("Введений ключ не вірний");
            return;
        }
        //Початкове заповнення
        for (long i = 0; i < b; i++) {
            hashMap.put(i, fibbonachi(i));
        }
        //Генерація випадкових чисел
        long fileLenght = (long) Math.pow(2, 16) + b;
        long pow2_32 = (long) Math.pow(2, 32);
        for (long i = b; i < fileLenght; i++) {
            hashMap.put(i, (hashMap.get(i - a) + hashMap.get(i - b)) % pow2_32);
            outputWriter.write(hashMap.get(i) + "\n");
        }

        outputWriter.write(str);

        keywordReader.close();
        outputWriter.close();
    }

    public static long fibbonachi(long depth) {
        long prev = 0;
        long next = 1;
        long temp;
        for (int i = 0; i < depth; i++) {
            temp = prev;
            prev = next;
            next = (next + temp) % (long) Math.pow(2, 32);
        }
        return prev;
    }
}
