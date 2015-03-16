package com.epam.aa.parser;

import com.epam.aa.parser.model.Composite;
import com.thedeanda.lorem.Lorem;

import java.util.regex.Pattern;

public class Runner {
    public static void main(String[] args) {
        String text = Lorem.getParagraphs(3,5);

        Composite textComposite = Composite.parse(text);
//        textComposite.print();
//        System.out.println(textComposite);
        System.out.println(textComposite.toString());
        System.out.printf("");
        System.out.println(textComposite.stringify());
        System.out.printf("");
        System.out.printf(text);
//        Pattern
    }
}
