package lc68_TextJustification;
/*
Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.
 */
public class Solution {
    private List<List<String>> splitToLines(String[] words, int maxWidth) {
        List<List<String>> result = new ArrayList<>();
        List<String> line = null;
        int len = maxWidth;
        for (String word : words) {
            if (len + word.length() > maxWidth) {
                if (line != null) {
                    result.add(line);
                }
                line = new ArrayList<>();
                len = 0;
            }
            line.add(word);
            len = len + word.length() + 1;
        }
        result.add(line);
        return result;
    }

    private String justifyLine(List<String> line, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        sb.append(line.get(0));

        if (line.size() == 1) {
            for (int i = line.get(0).length(); i < maxWidth; i++) {
                sb.append(' ');
            }
        } else {
            int length = 0;
            for (String word : line) {
                length += word.length();
            }
            int spacesToPutTotal = maxWidth - length;
            int spacesToPutEach = spacesToPutTotal / (line.size() - 1);
            int wordsWithExtraSpace = spacesToPutTotal % (line.size() - 1);

            for (int i = 1; i < line.size(); i++) {
                if (wordsWithExtraSpace > 0) {
                    wordsWithExtraSpace--;
                    sb.append(' ');
                }
                for (int j = 0; j < spacesToPutEach; j++) {
                    sb.append(' ');
                }
                sb.append(line.get(i));
            }
        }
        return sb.toString();
    }

    private String justifyLastLine(List<String> line, int maxWidth) {
        StringBuilder last = new StringBuilder();
        last.append(line.get(0));
        int len = line.get(0).length();
        for (int i = 1; i < line.size(); i++) {
            last.append(' ');
            last.append(line.get(i));
            len = len + line.get(i).length() + 1;
        }
        for (; len < maxWidth; len++) {
            last.append(' ');
        }

        return last.toString();
    }


    public List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> lines = splitToLines(words, maxWidth);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < lines.size() - 1; i++) {
            result.add(justifyLine(lines.get(i), maxWidth));
        }
        result.add(justifyLastLine(lines.get(lines.size() - 1), maxWidth));
        return result;
    }
}