package com.epam.aa.parser.model;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import sun.jvm.hotspot.debugger.win32.coff.COMDATSelectionTypes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

public class Helper {
    public static List<TextPart> getParagraphs(Composite fullText) {
        return fullText.getTextParts();
    }

    public static List<TextPart> getSentences(Composite fullText) {
        List<TextPart> paragraphs = getParagraphs(fullText);
        List<TextPart> sentences = new ArrayList<TextPart>();
        for (TextPart p : paragraphs) {
            Composite paragraph = (Composite) p;
            sentences.addAll(paragraph.getTextParts());
        }
        return sentences;
    }

    public static List<TextPart> getSentenceParts(Composite fullText) {
        List<TextPart> sentences = getSentences(fullText);
        List<TextPart> sentenceParts = new ArrayList<TextPart>();
        for (TextPart s : sentences) {
            Composite sentence = (Composite) s;
            sentenceParts.addAll(sentence.getTextParts());
        }
        return sentenceParts;
    }

    public static List<TextPart> getWordsAndDeliminators(Composite fullText) {
        List<TextPart> sentenceParts = getSentenceParts(fullText);
        List<TextPart> wordsAndDeliminators = new ArrayList<TextPart>();
        for (TextPart sp : sentenceParts) {
            Composite sentencePart = (Composite) sp;
            wordsAndDeliminators.addAll(sentencePart.getTextParts());
        }
        return wordsAndDeliminators;
    }

    public static List<TextPart> getWords(Composite fullText) {
        List<TextPart> wordsAndDeliminators = getWordsAndDeliminators(fullText);
        List<TextPart> words = new ArrayList<TextPart>();
        for (TextPart wd : wordsAndDeliminators) {
            if (wd.stringify().matches("\\w+")) words.add(wd);
        }
        return words;
    }

    public static int getNumberOfParagraphs(Composite fullText) {
        return getParagraphs(fullText).size();
    }

    public static int getNumberOfSentences(Composite fullText) {
        return getSentences(fullText).size();
    }

    public static int getNumberOfSentenceParts(Composite fullText) {
        return getSentenceParts(fullText).size();
    }

    public static int getNumberOfWords(Composite fullText) {
        return getWords(fullText).size();
    }

    public static List<TextPart> getsortedWordsByNumberOfLetters(Composite fullText) {
        List<TextPart> words = getWords(fullText);
        words.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Composite && o2 instanceof Composite) {
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

    public static List<Text>
}
