
public class Main {
    public static void main(String[] args) {
        System.out.println("Роботу виконав Гуменюк Богдан КН-21 Варіант №5\nЛабораторна робота №7 система шифрування RSA\n");
        RSA.generate(3, 11, 17, 5);
        RSA.generate(3, 11, 17, 9);
        RSA.generate(7, 11, 17, 8);
        RSA.generate(11, 13, 17, 7);
        RSA.generate(17, 31, 17, 2);

        RSA.KeysByNE(377, 17);
        RSA.KeysByNE(451, 17);

    }
}
