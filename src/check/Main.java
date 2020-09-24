package check;

import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {//io异常抛出

        File originFile = new File(args[0]);
        File similarFile = new File(args[1]);
        File answerFile = new File(args[2]);

        System.out.println("原文件文件的绝对路径：" + originFile.getAbsolutePath());//输出绝对路径
        System.out.println("抄袭文件的绝对路径：" + similarFile.getAbsolutePath());
        System.out.println("答案文件的绝对路径：" + answerFile.getAbsolutePath());

        ConvertString cs1 =new ConvertString();//将文本转换为字符串
        ConvertString cs2 =new ConvertString();
        String Str1 = cs1.convert(originFile);
        String Str2 = cs2.convert(similarFile);

        int Length1 = Str1.length();
        int Length2 = Str2.length();

        LevenshteinEdit ld = new LevenshteinEdit();
        int minDistance =ld.minDistance(Str1,Str2);

        double similarity=(1-(1.0*minDistance/Math.max(Length1,Length2)))*100;//求得相似度
       Outcome out = new Outcome();
       out.outcome(similarity,answerFile);
       /*
       * 测试*/
       Test test = new Test();
       test.test();


    }
}
