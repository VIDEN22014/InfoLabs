public class MyChar {
    public static int intByChar(char ch){
        return ch-65;
    }
    public static char charByInt(int charNum){
        if (charNum>=0&&charNum<=25){
            return (char)(charNum+65);
        }
        return 'A';
    }
}
