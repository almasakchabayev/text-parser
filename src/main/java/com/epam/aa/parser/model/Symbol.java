package com.epam.aa.parser.model;

import java.util.HashMap;
import java.util.Map;

public class Symbol implements TextPart {
    private static Type type = Type.SYMBOL;
    private static Map<Character, Symbol> symbolsMap;
    private char symbol;

    private Symbol(char symbol) {
        this.symbol = symbol;
    }

    private Symbol() {
    }

    public static Symbol valueOf(char c) {
        if (symbolsMap == null) {
            symbolsMap = new HashMap<Character, Symbol>();
        }
        Symbol s = symbolsMap.get(c);
        if (s == null) {
            s = new Symbol(c);
            symbolsMap.put(c, s);
        }
        return s;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public String stringify() {
        return String.valueOf(symbol);
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Symbol{" +
                "symbol=" + symbol +
                '}';
    }
}
