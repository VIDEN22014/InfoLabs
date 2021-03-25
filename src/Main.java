import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        AffineCipher.encrypt("input.txt","output.txt","keyword.txt");
        AffineCipher.decrypt("output.txt","output2.txt","keyword.txt");
    }
}
