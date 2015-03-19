package com.epam.aa.parser.model;

public interface TextPart {
    String stringify();

    Type getType();

    public enum Type {
        TEXT, PARAGRAPH, SENTENCE, WORD, SYMBOL;

        private static final Type[] values = values();

        private String RegexForSplit;

        static {
            TEXT.RegexForSplit = "(?<=\\n)";
            PARAGRAPH.RegexForSplit = "(?<=\\.+\\s)(?=[A-Z])";
            SENTENCE.RegexForSplit = "(?<=[^\\w])(?=\\w)|(?<=\\w)(?=[^\\w])|(?<=[^\\w])(?=[^\\w])";
            WORD.RegexForSplit = "(?<=\\w)";
        }

        public Type getChild() {
            if (ordinal() == values.length) {
                return null;
            }
            return values[ordinal() + 1]; // keep im mind symbol is child of sentence
        }

        public String getRegexForSplit() {
            return RegexForSplit;
        }
    }
}
