import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        AffineCipher.encrypt("input.txt", "outputEncrypted.txt", "keyword.txt");
        AffineCipher.decrypt("outputEncrypted.txt", "outputDecrypted.txt", "keyword.txt");
    }
}
