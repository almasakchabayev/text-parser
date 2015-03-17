package com.epam.aa.parser.model;

import java.util.ArrayList;
import java.util.List;

public class Composite implements TextPart {
    private List<TextPart> textParts;

    public List<TextPart> getTextParts() {
        return textParts;
    }

    public void addTextPart(TextPart textPart) {
        if (textParts == null) textParts = new ArrayList<TextPart>();
        textParts.add(textPart);
    }
    public void remove(TextPart textPart) {
        if (textParts != null) textParts.remove(textPart);
    }

    public void parseToSymbols(String text) {
        String[] paragraphs = text.split("(?<=\\n)");
        for (String paragraph : paragraphs) {
            Composite paragraphComposite = new Composite();
            String[] sentences = paragraph.split("(?<=\\.+\\s)");
            for (String sentence : sentences) {
                Composite sentenceComposite = new Composite();
                String[] sentenceParts = sentence.split("(?<=[,;:\\s])");
                for (String sentencePart : sentenceParts) {
                    Composite sentencePartComposite = new Composite();
                    String[] wordsOrDeliminators = sentencePart.split("(?=[,;:\\s])");
                    for (String wordOrDeliminator : wordsOrDeliminators) {
                        Composite wordOrDeliminatorComposite = new Composite();
                        char[] symbols = wordOrDeliminator.toCharArray();
                        for (char symbol : symbols) {
                            Symbol symbolObject = new Symbol(symbol);
                            wordOrDeliminatorComposite.addTextPart(symbolObject);
                        }
                        sentencePartComposite.addTextPart(wordOrDeliminatorComposite);
                    }
                    sentenceComposite.addTextPart(sentencePartComposite);
                }
                paragraphComposite.addTextPart(sentenceComposite);
            }
            this.addTextPart(paragraphComposite);
        }
    }

    public String compose(Composite textComposite) {
        return stringify();
    }

    @Override
    public void print() {
        for (TextPart textPart : textParts) {
            textPart.print();
        }
    }

    @Override
    public String stringify() {
        StringBuffer sb = new StringBuffer();
        for (TextPart textPart : textParts) {
            sb.append(textPart.stringify());
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Composite{" +
                "textParts=" + textParts +
                '}';
    }
}
