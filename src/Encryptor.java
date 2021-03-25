import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Encryptor {
    public static void encrypt(String inputFileName, String outputFileName, String keywordFileName) throws IOException {
        FileReader keywordReader = new FileReader(keywordFileName);
        Scanner keywordScanner = new Scanner(keywordReader);
        FileReader inputReader = new FileReader(inputFileName);
        Scanner inputScanner = new Scanner(inputReader);
        FileWriter outputWriter = new FileWriter(outputFileName);
        int keyA = keywordScanner.nextInt();
        int keyB = keywordScanner.nextInt();
        int X = 0;
        char[] inputString = inputScanner.nextLine().toUpperCase().toCharArray();
        String ouputString="";
        for (char i : inputString) {
            System.out.print(i);
        }
        System.out.println();
        for (int i = 0; i < inputString.length; i++) {
            X = (keyA * (MyChar.intByChar(inputString[i]) + keyB)) % 26;
            inputString[i]=MyChar.charByInt(X);
            System.out.print(inputString[i]);
            ouputString+=inputString[i];
        }
        outputWriter.write(inputString);

        keywordReader.close();
        inputReader.close();
        outputWriter.close();
    }
}
