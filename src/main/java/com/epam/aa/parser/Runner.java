package com.epam.aa.parser;

import com.epam.aa.parser.model.Composite;
import com.thedeanda.lorem.Lorem;

import java.io.*;
import java.net.URL;
import java.nio.file.Path;
import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        String text = Lorem.getParagraphs(3, 5);
        byte[] bytes = text.getBytes();

        OutputStream out;
        try {
            out = new BufferedOutputStream(new FileOutputStream("src/main/resources/output.txt"));
            out.write(bytes);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Reader reader;
        String textFromFile = null;
        try {
            reader = new BufferedReader(new FileReader("src/main/resources/input.txt"));
            StringBuffer sb = new StringBuffer();
            int i;
            while ((i = reader.read()) != -1) {
                sb.append((char) i);
            }
            textFromFile = sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(textFromFile);
        System.out.println("");
        System.out.println("");


        Composite textComposite = Composite.parse(textFromFile);
        System.out.println(textComposite.toString());
        System.out.println("");
        System.out.println("");
        System.out.println(textComposite.stringify());
        System.out.println("");
        System.out.println("");
        System.out.println(text);
    }
}
