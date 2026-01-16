package com.dam2.ut1.ejemplos.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.ScatteringByteChannel;

public class ScatterExample {
	private static String FILENAME = "nums.dat";
	public static void main(String[] args) {
		ByteBuffer bLen1 = ByteBuffer.allocate(4096);
		ByteBuffer bLen2 = ByteBuffer.allocate(4096);
		FileInputStream in;
		try {
			in = new FileInputStream(FILENAME);
			ScatteringByteChannel scatter = in.getChannel();
			scatter.read(new ByteBuffer[] {bLen1, bLen2});
			bLen1.flip(); bLen2.flip();
			bLen1.position(0);
			IntBuffer ib = bLen2.asIntBuffer();
			ib.position(3);
			//bLen2.position(12);
			int valor1 = bLen1.asIntBuffer().get();
			int valor2 = ib.get();
			System.out.println("Scattering : Valor1 = " + valor1);
			System.out.println("Scattering : Valor2 = " + valor2);
		}
		catch (FileNotFoundException exObj) {
			exObj.printStackTrace();
		}
		catch (IOException ioObj) {
			ioObj.printStackTrace();
		}
	}
}
