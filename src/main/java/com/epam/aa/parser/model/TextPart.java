package com.epam.aa.parser.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public interface TextPart {
    public String stringify();

    public enum Type {
        TEXT, PARAGRAPH, SENTENCE, WORD, SYMBOL;

        private List<Type> children = new ArrayList<Type>();

        private String RegexForSplit;

        static {

            TEXT.children.add(PARAGRAPH);

            PARAGRAPH.children.add(SENTENCE);

            SENTENCE.children.add(WORD);
            SENTENCE.children.add(SYMBOL);

            WORD.children.add(SYMBOL);

            TEXT.RegexForSplit = "(?<=\\n)";
            PARAGRAPH.RegexForSplit = "(?<=\\.+\\s)(?=[A-Z])";
            SENTENCE.RegexForSplit = "(?<=[^\\w])(?=\\w)|(?<=\\w)(?=[^\\w])|(?<=[^\\w])(?=[^\\w])";
            Pattern.compile("\\.+\\s*");
            WORD.RegexForSplit = "(?<=\\w)";
        }

        public List<Type> getChildren() {
            return children;
        }

        public String getRegexForSplit() {
            return RegexForSplit;
        }
    }
}
