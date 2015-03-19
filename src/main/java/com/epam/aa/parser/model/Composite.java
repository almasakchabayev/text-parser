package com.epam.aa.parser.model;

import java.util.ArrayList;
import java.util.List;

public class Composite implements TextPart {
    private List<TextPart> textParts;
    private Type type;

    public Composite(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<TextPart> getTextParts() {
        return textParts;
    }

    public void addTextPart(TextPart textPart) {
        if (textParts == null) textParts = new ArrayList<>();
        textParts.add(textPart);
    }

    public void removeTextPart(TextPart textPart) {
        if (textParts != null) textParts.remove(textPart);
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
                "type=" + type +
                ", textParts=" + textParts +
                '}';
    }
}
