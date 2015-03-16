package com.epam.aa.parser.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Symbol implements TextPart {

//    public static final List<TextPart> PARAGRAPHS_DELIMINATOR = new ArrayList<TextPart>(Arrays.asList(new Symbol('\n')));
//    public static final List<TextPart> SENTENCES_DELIMINATOR = new ArrayList<TextPart>(Arrays.asList(new Symbol('.'), new Symbol(' ')));
//    public static final List<TextPart> WORDS_DELIMINATOR = new ArrayList<TextPart>(Arrays.asList(new Symbol(' ')));
    private char symbol;

    public Symbol(char symbol) {
        this.symbol = symbol;
    }

    public Symbol() {
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void print() {
        System.out.print(symbol);
    }

    @Override
    public String stringify() {
        return String.valueOf(symbol);
    }

    @Override
    public String toString() {
        return "Symbol{" +
                "symbol=" + symbol +
                '}';
    }
}
