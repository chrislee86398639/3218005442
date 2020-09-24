package check;

import java.io.File;
import java.io.FileWriter;

public class Outcome {
    public static void outcome(double similarity, File file){

        String answer =String.format("%.2f",similarity);//保留2位小数输出
        System.out.println("the similartity is "+answer);
        try (FileWriter writer = new FileWriter(file)) {//把结果写入答案文件
            writer.write(answer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
