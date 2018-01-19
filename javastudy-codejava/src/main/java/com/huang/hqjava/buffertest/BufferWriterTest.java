package com.huang.hqjava.buffertest;

import java.io.*;

/**
 * @author zhenqionghuang@a
 * @version V1.0
 * @Package com.huang.hqjava.buffertest
 * @Description: test buffer
 * @date 2017/11/17 18:11
 * @Company: a
 */
public class BufferWriterTest {

	public static void main(String[] args) throws IOException {
		bufferTest();
	}

	private static void bufferTest() throws IOException {

		Writer writer = new FileWriter(new File("file.txt"));

		long begin = System.currentTimeMillis();

		for (int i = 0; i < 100000; i++) {
			writer.write(i);
		}

		writer.close();
		//129ms
		System.out.println("testFileWriter spend:"+(System.currentTimeMillis() - begin));

		//使用缓冲

		Writer bufferWriter = new BufferedWriter(new FileWriter(new File("file.txt")));

		begin = System.currentTimeMillis();

		for (int i = 0; i < 100000; i++) {
			bufferWriter.write(i);
		}

		writer.close();
		//24ms
		System.out.println("testBufferFileWriter spend:"+(System.currentTimeMillis() - begin));

	}
}
