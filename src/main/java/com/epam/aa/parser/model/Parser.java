package com.epam.aa.parser.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Parser {

    public static TextPart parse(String string, TextPart.Type type) {
        if (string.length() == 0) return null;
        if (string.length() == 1) {
            Symbol symbol = Symbol.valueOf(string.charAt(0));
            return symbol;
        }

        Composite composite = new Composite(type);
        String[] split = string.split(type.getRegexForSplit());
        for (String s : split) {
            TextPart childComposite = parse(s, type.getChild());
            composite.addTextPart(childComposite);
        }
        return composite;
    }

    public static List<TextPart> getParagraphs(Composite composite) {
        if (composite.getType().ordinal() > TextPart.Type.PARAGRAPH.ordinal())
            return null;

        if (composite.getType().equals(TextPart.Type.TEXT))
            return composite.getTextParts();

        ArrayList<TextPart> textParts = new ArrayList<>();
        textParts.add(composite);
        return textParts;
    }

    public static List<TextPart> getSentences(Composite composite) {
        TextPart.Type sentenceType = TextPart.Type.SENTENCE;
        if (composite.getType().ordinal() > sentenceType.ordinal())
            return null;

        if (composite.getType().equals(sentenceType)) {
            ArrayList<TextPart> textParts = new ArrayList<>();
            textParts.add(composite);
            return textParts;
        }

        List<TextPart> paragraphs = getParagraphs(composite);
        List<TextPart> sentences = new ArrayList<>();
        for (TextPart p : paragraphs) {
            Composite paragraph = (Composite) p;
            sentences.addAll(paragraph.getTextParts());
        }
        return sentences;
    }

    public static List<TextPart> getWords(Composite composite) {
        TextPart.Type wordType = TextPart.Type.WORD;
        if (composite.getType().ordinal() > wordType.ordinal())
            return null;

        if (composite.getType().equals(wordType)) {
            ArrayList<TextPart> textParts = new ArrayList<>();
            textParts.add(composite);
            return textParts;
        }

        List<TextPart> sentences = getSentences(composite);
        List<TextPart> words = new ArrayList<>();
        for (TextPart sentence : sentences) {
            Composite s = (Composite) sentence;
            for (TextPart wordOrSymbol : s.getTextParts()) {
                if (wordOrSymbol.getType().equals(wordType)) words.add(wordOrSymbol);
            }
        }
        return words;
    }

    public static int getNumberOfParagraphs(Composite composite) {
        return getParagraphs(composite).size();
    }

    public static int getNumberOfSentences(Composite composite) {
        return getSentences(composite).size();
    }

    public static int getNumberOfWords(Composite composite) {
        return getWords(composite).size();
    }

    public static List<TextPart> getsortedWordsByNumberOfLetters(Composite composite) {
        List<TextPart> words = getWords(composite);
        words.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Composite && o2 instanceof Composite) {
                    Composite c1 = (Composite) o1;
                    Composite c2 = (Composite) o2;
                    Integer i1 = c1.getTextParts().size();
                    Integer i2 = c2.getTextParts().size();
                    return i1.compareTo(i2);
                }
                return 0;
            }
        });
        return words;
    }
}
