package check;

import java.io.*;

public class ConvertString {
    public static String convert(File file) throws IOException {

        String str0 = "";
        String Str1 ="";
        BufferedReader file1 = null;
        try {
            file1 = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while((str0 = file1.readLine()) != null){//将文本转化为String
            Str1 += str0 ;
        }
        Str1 = Str1.replaceAll("[\\pP\\p{Space}]+", ""); //剔除所有标点符号和空格
        return Str1;
    }
}
