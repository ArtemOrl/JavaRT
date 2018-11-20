package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {

    private AmigoOutputStream component;

    @Override
    public String toString() {
        return super.toString();
    }

    public QuestionFileOutputStream(AmigoOutputStream amigoOutputStream) {
        this.component = amigoOutputStream;
    }

    @Override
    public void close() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        if (br.readLine().equals("Д")){
            component.close();
        }
        br.close();
    }

    @Override
    public void flush() throws IOException {
        component.flush();
    }

    @Override
    public void write(int b) throws IOException {

        component.write(b);

    }

    @Override
    public void write(byte[] b) throws IOException {

        component.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {

        component.write(b, off, len);
    }
}

