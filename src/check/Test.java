package check;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;

public class Test {
    public static void test() throws IOException {
        String[] pathArray = new String[]{

                "C:/Users/2046/Desktop/test1/orig_0.8_add.txt",
                "C:/Users/2046/Desktop/test1/orig_0.8_del.txt",
                "C:/Users/2046/Desktop/test1/orig_0.8_dis_1.txt",
                "C:/Users/2046/Desktop/test1/orig_0.8_dis_10.txt",
                "C:/Users/2046/Desktop/test1/orig_0.8_dis_10.txt"
        };
        System.out.println("测试开始");

        File origin = new File("C:/Users/2046/Desktop/test1/orig.txt");
        File answer = new  File("C:/Users/2046/Desktop/test1/answer.txt");
        ConvertString cs1 =new ConvertString();//将文本转换为字符串
        ConvertString cs2 =new ConvertString();
        String Str1 = cs1.convert(origin);
        int Length1 = Str1.length();


        for(int i = 0 ;i<pathArray.length; i++){

            System.out.println(pathArray[i]+"\ttesting...");
            String Str2 = cs2.convert(new File(pathArray[i]));
            int Length2 = Str2.length();

            LevenshteinEdit ld = new LevenshteinEdit();
            int minDistance =ld.minDistance(Str1,Str2);

            double similarity=(1-(1.0*minDistance/Math.max(Length1,Length2)))*100;//求得相似度
            Outcome out = new Outcome();
            out.outcome(similarity,answer);
        }
        System.out.println("测试结束");
    }
}
