package utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class FileReader {

    public static int getUniqueWordCountInFile(String file) throws IOException {
        File inputFile = new File(file);
        LineIterator lineIterator = FileUtils.lineIterator(inputFile);
        Set<String> uniqueWords = new HashSet<>();
        while (lineIterator.hasNext()) {
            String line = lineIterator.nextLine();
            String[] words = StringUtils.split(line);
            for (String word : words) {
                if (StringUtils.isAlphanumeric(word)) {
                    uniqueWords.add(word);
                }
            }

        }
        return uniqueWords.size();
    }
}