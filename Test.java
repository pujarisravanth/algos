import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        String s = "  This   is a sample string";
        System.out.println(Arrays.toString(s.split("\\s+")));
    }

}
