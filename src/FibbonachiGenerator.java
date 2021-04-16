public class FibbonachiGenerator {
    public void generate(int p, int q) {
        System.out.println("Роботу виконав Гуменюк Богдан КН-21 Варіант №5\nМетод Фібоначчі з запізнюваннями (спрощений Аддитивний метод).\n");
        int n = p * q;
        int phiN = eilerFunction((p - 1) * (q - 1));
        int e = 17;
        int d = modReverse(e, phiN);
        System.out.println("Відкриті коефіцієнти : p = " + p + " q = " + q);
        System.out.println("Відкрита частина ключа n = " + n);
        System.out.println("Функція Ейлера phiN = " + phiN);
        System.out.println("Відкрита частина e = " + e);

    }

    int eilerFunction(int n) {
        int result = n;
        for (int i = 2; i * i <= n; ++i)
            if (n % i == 0) {
                while (n % i == 0)
                    n /= i;
                result -= result / i;
            }
        if (n > 1)
            result -= result / n;
        return result;
    }

    int modReverse(int x, int m) {

        return 0;

    }

}
