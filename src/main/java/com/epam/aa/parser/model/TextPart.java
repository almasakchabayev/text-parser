package com.epam.aa.parser.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public interface TextPart {
    public String stringify();

    public enum Type {
        TEXT, PARAGRAPH, SENTENCE, WORD, SYMBOL;

            private static final Type[] values = values();

        private String RegexForSplit;

        static {
            TEXT.RegexForSplit = "(?<=\\n)";
            PARAGRAPH.RegexForSplit = "(?<=\\.+\\s)(?=[A-Z])";
            SENTENCE.RegexForSplit = "(?<=[^\\w])(?=\\w)|(?<=\\w)(?=[^\\w])|(?<=[^\\w])(?=[^\\w])";
            Pattern.compile("\\.+\\s*");
            WORD.RegexForSplit = "(?<=\\w)";
        }

        public Type getChild() {
            if (ordinal() == values.length) {
                return null;
            }
            return values[ordinal() +1];
        }

        public String getRegexForSplit() {
            return RegexForSplit;
        }
    }
}
