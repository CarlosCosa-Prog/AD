package com.dam2;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;

//2) Programa NIO

public class NIO {
    // TE FALTA MAIN

    Random rand = new Random();
    int numeros [] = new int[]; // NO NECESITAS UN ARRAY

    Path f1 = Paths.get("loteria.dat");
    FileChannel fc = FileChannel.open(f1, StandardOpenOption.READ);
    ByteBuffer bb = ByteBuffer.allocate(400);

    for (int i = 0; i < 99; i++){
        numeros[i] = rand.nextInt(100);
        bb.putInt(numeros[i]);
    }
    bb.clear(); // AQUÍ FLIP()
    IntBuffer ib = bb.asIntBuffer();







}

