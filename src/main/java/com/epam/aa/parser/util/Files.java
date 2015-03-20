package com.epam.aa.parser.util;

import java.io.*;

/**
 * Created by almas on 20/03/2015.
 */
public class Files {
    public static String inputReaderAsString(Reader reader) {
        String textFromFile = null;
        try {
            Reader bufferedreader = new BufferedReader(reader);
            StringBuffer sb = new StringBuffer();
            int i;
            while ((i = bufferedreader.read()) != -1) {
                sb.append((char) i);
            }
            textFromFile = sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return textFromFile;
    }
}
