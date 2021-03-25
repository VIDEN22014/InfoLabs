import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AffineCipher {
    public static void encrypt(String inputFileName, String outputFileName, String keywordFileName) throws IOException {
        FileReader keywordReader = new FileReader(keywordFileName);
        Scanner keywordScanner = new Scanner(keywordReader);
        FileReader inputReader = new FileReader(inputFileName);
        Scanner inputScanner = new Scanner(inputReader);
        FileWriter outputWriter = new FileWriter(outputFileName);
        int keyA = keywordScanner.nextInt() % 26;
        if (!checkForMutuallySimple(keyA, 26)) {
            return;
        }
        int keyB = keywordScanner.nextInt() % 26;
        int X;
        char[] inputString = inputScanner.nextLine().toUpperCase().toCharArray();
        String ouputString = "";
        for (char i : inputString) {
            System.out.print(i);
        }
        System.out.println();
        for (int i = 0; i < inputString.length; i++) {
            X = (keyA * intByChar(inputString[i]) + keyB) % 26;
            inputString[i] = charByInt(X);
            System.out.print(inputString[i]);
            ouputString += inputString[i];
        }
        System.out.println();
        outputWriter.write(inputString);

        keywordReader.close();
        inputReader.close();
        outputWriter.close();
    }

    public static void decrypt(String inputFileName, String outputFileName, String keywordFileName) throws IOException {
        {
            FileReader keywordReader = new FileReader(keywordFileName);
            Scanner keywordScanner = new Scanner(keywordReader);
            FileReader inputReader = new FileReader(inputFileName);
            Scanner inputScanner = new Scanner(inputReader);
            FileWriter outputWriter = new FileWriter(outputFileName);
            int keyA = keywordScanner.nextInt() % 26;
            if (!checkForMutuallySimple(keyA, 26)) {
                return;
            }
            int keyB = keywordScanner.nextInt() % 26;
            int inverseA = modInverse(keyA, 26);
            int X;
            char[] inputString = inputScanner.nextLine().toUpperCase().toCharArray();
            String ouputString = "";
            for (char i : inputString) {
                System.out.print(i);
            }
            System.out.println();
            for (int i = 0; i < inputString.length; i++) {
                X = (inverseA * (intByChar(inputString[i]) + 26 - keyB)) % 26;
                inputString[i] = charByInt(X);
                System.out.print(inputString[i]);
                ouputString += inputString[i];
            }
            System.out.println();
            outputWriter.write(inputString);

            keywordReader.close();
            inputReader.close();
            outputWriter.close();
        }
    }

    public static int intByChar(char ch) {
        return ch - 65;
    }

    public static char charByInt(int charNum) {
        if (charNum >= 0 && charNum <= 25) {
            return (char) (charNum + 65);
        }
        return 'A';
    }

    public static boolean checkForMutuallySimple(int keyA, int M) {
        if (keyA == 1) {
            return true;
        }
        for (int i = 2; i <= keyA; i++) {
            if (M % i == 0 && keyA % i == 0) {
                System.out.println("Числа A і M не є взаємно прості");
                return false;
            }
        }
        return true;
    }

    public static int modInverse(int a, int m) {
        for (int x = 1; x < m; x++) {
            if (((a % m) * (x % m)) % m == 1) {
                return x;
            }
        }
        return 1;
    }
}
