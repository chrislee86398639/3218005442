package check;

import java.io.IOException;

public class checkTest {
    public static void checktest(String Str1,String Str2,String Str3) throws IOException {
        String [] strings =new String[]{Str1,Str2,Str3};
        Main m = new Main();
        m.main(strings);
    }
}
