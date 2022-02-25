
// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import javax.swing.plaf.ColorUIResource;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        int x = markdown.length();
        while (currentIndex < x) {
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            if (nextOpenBracket == -1 || nextCloseBracket == -1) {
                break;
            }
            if (markdown.charAt(nextCloseBracket + 1) == '(') {
                int openParen = markdown.indexOf("(", nextCloseBracket);
                int closeParen = markdown.indexOf(")", openParen);
                if (closeParen + 1 != x) {
                    if (markdown.charAt(closeParen + 1) == ')') {
                        x -= 1;
                    }
                }
                if (markdown.substring(openParen + 1, closeParen).contains(".com")
                        || markdown.substring(openParen + 1, closeParen).contains(".html")) {
                    toReturn.add(markdown.substring(openParen + 1, closeParen));
                    currentIndex = closeParen + 1;
                } else {
                    break;
                }

            } else {
                break;
            }
        }
        return toReturn;
    }

    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}

/**
 * 
 * if (nextOpenBracket == -1 || nextCloseBracket == -1) {
 * break;
 * }
 * System.out.println(markdown.indexOf("]", nextOpenBracket));
 * System.out.println(markdown.charAt(nextCloseBracket + 1));
 * System.out.println(markdown.indexOf("(", -1));
 * System.out.println(markdown.indexOf(")", markdown.indexOf("(", -1)));
 * System.out.println(markdown.charAt(nextCloseBracket + 1) == '(');
 */