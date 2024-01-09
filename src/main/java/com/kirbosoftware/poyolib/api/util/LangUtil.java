package com.kirbosoftware.poyolib.api.util;

import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public class LangUtil {
    /**
     * A method to capitalize a string and remove anything what's between it.
     * <a href="https://stackoverflow.com/questions/1892765/how-to-capitalize-the-first-character-of-each-word-in-a-string">Source</a>
     * @param string the string you want to capitalize.
     * @return a capitalised string.
     */
    public static @NotNull String capitalizeString(@NotNull String string) {
        char[] chars = string.toLowerCase().toCharArray();
        boolean found = false;
        for (int i = 0; i < chars.length; i++) {
            if (!found && Character.isLetter(chars[i])) {
                chars[i] = Character.toUpperCase(chars[i]);
                found = true;
            } else if (Character.isWhitespace(chars[i]) || chars[i] == '.' || chars[i] == '_') {
                found = false;
            }
        }
        return String.valueOf(chars);
    }
}
