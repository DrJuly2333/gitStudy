package main.java.src.com.test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
    private static final int DOWN_THREAD_NUM = 10;

    // RandomAccessFile 合并文件分片
    public boolean merge(String fileName) throws IOException {
        byte[] bytes = new byte[1024 * 10];
        int len = -1;
        try(RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw")) {
            for (int i = 0; i < DOWN_THREAD_NUM; i++) {
                try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName + "_" + i))) {
                    // 读到文件末尾返回-1
                    while ((len = bis.read(bytes)) != -1) {
                        randomAccessFile.write(bytes, 0 , len);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
