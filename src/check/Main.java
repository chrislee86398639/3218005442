package check;

import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {//io异常抛出

        File file1 = new File("src/test1/orig.txt");
        File file2 = new File("src/test1/orig_0.8_add.txt");
        File file3 = new File("src/test1/answer.txt");

        System.out.println("原文件文件的绝对路径：" + file1.getAbsolutePath());
        System.out.println("抄袭文件的绝对路径：" + file2.getAbsolutePath());
        System.out.println("答案文件的绝对路径：" + file3.getAbsolutePath());

        BufferedReader f1 = new BufferedReader(new InputStreamReader(new  FileInputStream(file1)));
        BufferedReader f2 = new BufferedReader(new InputStreamReader(new  FileInputStream(file2)));

        String  str = new String();
        String Str1 ="";
        String Str2 ="";

        while((str = f1.readLine()) != null){//将文本转化为String
            Str1 += str  ;
        }
        Str1 = Str1.replaceAll("[\\pP\\p{Space}]+", ""); //剔除所有标点符号和空格

        while ((str = f2.readLine())!=null){
            Str2 += str;
        }
        Str2 = Str2.replaceAll("[\\pP\\p{Space}]+", ""); //剔除所有标点符号和空格

        int Length1 = Str1.length();
        int Length2 = Str2.length();

        LevenshteinEdit editDistance = new LevenshteinEdit();

        int ed =editDistance.editDistanceCompute(Str1,Str2);
        System.out.println("最小编辑距离:"+ed);

        double similarity=(1-(1.0*ed/Math.max(Length1,Length2)))*100;//求得相似度

        String answer =String.format("%.2f",similarity);//保留4位小数输出
        System.out.println("the similartity is "+answer);

        try (FileWriter writer = new FileWriter(file3)) {//把结果写入答案文件

            writer.write(answer);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
