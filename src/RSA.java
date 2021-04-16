public class RSA {
    public static void generate(int p, int q, int e, int input) {
        if (!isVzayemnoProsti(p, q)) {
            System.out.println("Помилка, числа p i q не є взаємно прості");
            return;
        }
        int n = p * q;
        int lambdaN = NOK((p - 1), (q - 1));
        if (!isVzayemnoProsti(e, e) || lambdaN % e == 0) {
            System.out.println("Помилка, число e неправильне");
            return;
        }
        int d = modInverse(e, lambdaN);
        int x = d - lambdaN;
        int y = p - q;
        int encrypted = powMod(input, e, n);
        int decrypted = powMod(encrypted, d, n);
        System.out.println("Відкриті коефіцієнти : p = " + p + " q = " + q);
        System.out.println("Відкрита частина ключа n = " + n);
        System.out.println("lambdaN = " + lambdaN);
        System.out.println("Відкрита частина e = " + e);
        System.out.println("Відкрита частина d = " + d);
        System.out.println("Коефіцієнти Безу x = " + x + " y = " + y);
        System.out.println("Публічний ключ n = " + n + " e = " + e);
        System.out.println("Приватний ключ n = " + n + " d = " + d);
        System.out.println("Вхідне повідомлення = " + input);
        System.out.println("Зашифроване повідомлення = " + encrypted);
        System.out.println("Розшифроване повідомлення = " + decrypted + "\n");
    }

    static int modInverse(int a, int m) {
        for (int i = 1; i < m; i++) {
            if (((a % m) * (i % m)) % m == 1) {
                return i;
            }
        }
        return 1;
    }

    static int powMod(int base, int exponent, int modulus) {
        int result = base;
        for (int i = 1; i < exponent; i++)
            result = result * base % modulus;
        return result;
    }

    static int NOD(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b) a = a % b; //для збільшення швидкості робимо через остачу від ділення
            else b = b % a;
        }
        a = a + b;
        return a;
    }

    static int NOK(int a, int b) {
        //згідно означення НСК=a*b/НОД(a,b)
        return a * b / NOD(a, b);
    }

    static boolean isVzayemnoProsti(int a, int b) {
        int max = Math.max(a, b);
        for (int i = 2; i < max; i++) {
            if (a % i == 0 && b % i == 0) {
                return false;
            }
        }
        return true;
    }

    static void KeysByNE(int n, int e) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i * j == n && isVzayemnoProsti(i, j)) {
                    int lambdaN = NOK(i, j);
                    int d = modInverse(e, lambdaN);
                    System.out.println("Публічний ключ n = " + n + " e = " + e);
                    System.out.println("Приватний ключ n = " + n + " d = " + d + "\n");
                    return;
                }
            }
        }
    }
}
