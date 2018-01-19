package com.huang.hqjava.iodesign;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author zhenqionghuang@a
 * @version V1.0
 * @Package com.huang.hqjava.iodesign
 * @Description:
 * @date 2016/8/21 21:41
 * @Company: a
 */
public class ReaderInputFromFile {

    public static void main(String[] args) {

        Path file = Paths.get("D:/huang.txt");

        if (Files.exists(file)) {

           try (BufferedReader fileIn = new BufferedReader(Files.newBufferedReader(file, Charset.forName("UTF-8")))) {

               String saying = null;
               int totalRead = 0;
               while ((saying = fileIn.readLine()) != null ) {
                   System.out.println(saying);
                   ++totalRead;
               }
               System.out.println(totalRead);
           } catch (IOException e) {
               e.printStackTrace();
           }

        } else {
            try {
                Files.createFile(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
