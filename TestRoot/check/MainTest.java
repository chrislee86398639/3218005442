package check;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

import static org.junit.Assert.*;
public class MainTest {
    checkTest t = new checkTest();

    @Before
    public void setUp() {
        System.out.println("Start!");
    }

    @After
    public void tearDown() {
        System.out.println("Finish!");
    }


    /*
     * 实际存在的路径*/
    @Test
    public void existPath() throws IOException {
         
        try {
            t.checktest("src/test1/orig.txt", "src/test1/orig_0.8_add.txt", "src/test1/answer.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * 空路径*/
    @Test
    public void nullPath() throws IOException {
        
        try {
            t.checktest("", "src/test1/orig_0.8_add.txt", "src/test1/answer.txt");
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }

    /*
     * 不存在的路径*/
    @Test
    public void nonExistPath() throws IOException {
         
        try {
            t.checktest("src/orig.txt", "src/test1/orig_0.8_add.txt", "src/test1/answer.txt");
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }

    /*
     * 相同的路径*/
    @Test
    public void samePath() throws IOException {
         
        try {
            t.checktest("src/test1/orig.txt", "src/test1/orig.txt", "src/test1/answer.txt");
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }

    /*
     * 原始文本与增加字数的文本对比*/
    @Test
    public void addtext() throws IOException {
         
        try {
            t.checktest("src/test1/orig.txt", "src/test1/orig_0.8_add.txt", "src/test1/answer.txt");
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }

    /*
     * 原始文本与减少字数的文本对比*/
    @Test
    public void deltext() throws IOException {
         
        try {
            t.checktest("src/test1/orig.txt", "src/test1/orig_0.8_del.txt", "src/test1/answer.txt");
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }

    /*
     * 原始文本与减少字数的文本对比*/
    @Test
    public void addcompdeltext() throws IOException {
         
        try {
            t.checktest("src/test1/orig_0.8_del.txt", "src/test1/orig_0.8_add.txt", "src/test1/answer.txt");
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }

    /*
     * 原文与orig_0.8_1文本对比*/
    @Test
    public void dis1text() throws IOException {
         
        try {
            t.checktest("src/test1/orig.txt", "src/test1/orig_0.8_dis_1.txt", "src/test1/answer.txt");
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }

    /*
     * 原文与orig_0.8_10文本对比*/
    @Test
    public void dis10text() throws IOException {
        check.checkTest t = new check.checkTest();
        try {
            t.checktest("src/test1/orig.txt", "src/test1/orig_0.8_dis_10.txt", "src/test1/answer.txt");
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }


    /*
     * 原文与orig_0.8_15文本对比*/
    @Test
    public void dis15text() throws IOException {
         
        try {
            t.checktest("src/test1/orig.txt", "src/test1/orig_0.8_dis_15.txt", "src/test1/answer.txt");
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }

    /*
     * 超时监测,运行时间超过5s,不能通过测试*/
    @Test
    public void time() throws IOException {
         
        try {
            t.checktest("src/test1/orig.txt", "src/test1/orig_0.8_dis_15.txt", "src/test1/answer.txt");
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }

}