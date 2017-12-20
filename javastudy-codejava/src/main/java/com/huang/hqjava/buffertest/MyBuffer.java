package com.huang.hqjava.buffertest;

import java.nio.ByteBuffer;

/**
 * @author zhenqionghuang@creditease.cn
 * @version V1.0
 * @Package com.huang.hqjava.buffertest
 * @Description:
 * @date 2017/12/20 18:17
 * @Company: creditease.cn
 */
public class MyBuffer {

	public static void main(String[] args) {
		whatIsBuffer();
	}

	private static void whatIsBuffer() {

		ByteBuffer b = ByteBuffer.allocate(15);
		System.out.println("初始\tlimit="+b.limit()+"\tcapacity="+b.capacity()+"\tposition="+b.position());


	}

}
