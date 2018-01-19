package com.huang.hqjava.buffertest;

import java.nio.ByteBuffer;

/**
 * @author zhenqionghuang@a
 * @version V1.0
 * @Package com.huang.hqjava.buffertest
 * @Description:
 * @date 2017/12/20 18:17
 * @Company: a
 */
public class MyBuffer {

	public static void main(String[] args) {
		whatIsBuffer();
	}

	private static void whatIsBuffer() {

		ByteBuffer b = ByteBuffer.allocate(15);
		System.out.println("初始值\tlimit="+b.limit()+"\tcapacity="+b.capacity()+"\tposition="+b.position());

		//存入10个字节数据
		for (int i = 0; i < 10; i++) {
			b.put((byte)i);
		}

		System.out.println("存入10个字节数据之后\tlimit="+b.limit()+"\tcapacity="+b.capacity()+"\tposition="+b.position());

		//重置position
		b.flip();

		System.out.println("Buffer重置之后\tlimit="+b.limit()+"\tcapacity="+b.capacity()+"\tposition="+b.position());

		for (int i = 0; i < 5; i++) {
			System.out.print(b.get());
		}

		System.out.println();

		System.out.println("Buffer取5个值之后\tlimit="+b.limit()+"\tcapacity="+b.capacity()+"\tposition="+b.position());

		b.flip();

		System.out.println("Buffer再次重置之后\tlimit="+b.limit()+"\tcapacity="+b.capacity()+"\tposition="+b.position());

//		for (int i = 0; i < 5; i++) {
//			System.out.print(b.get());
//		}
//
//		System.out.println("Buffer再次读之后\tlimit="+b.limit()+"\tcapacity="+b.capacity()+"\tposition="+b.position());
//		b.flip();
//		for (int i = 0; i < 4; i++) {
//			b.put((byte)i);
//		}
//
//		System.out.println("Buffer再次设值之后\tlimit="+b.limit()+"\tcapacity="+b.capacity()+"\tposition="+b.position());
	}

}
