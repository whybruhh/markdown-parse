import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;

public class MarkdownParseTest {

    @Test
    public void testSnippet1() throws IOException {
        String contents = Files.readString(Path.of("./Snippet1.md"));
        List<String> expectLink = List.of("`google.com", "google.com", "ucsd.edu");
        assertEquals(expectLink, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testSnippet2() throws IOException {
        String contents = Files.readString(Path.of("./Snippet2.md"));
        List<String> expectLink = List.of("a.com", "a.com(())", "example.com");
        assertEquals(expectLink, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testSnippet3() throws IOException {
        String contents = Files.readString(Path.of("./Snippet3.md"));
        List<String> expectLink = List.of("https://www.twitter.com", "https://ucsd-cse15l-w22.github.io/",
                "https://cse.ucsd.edu/");
        assertEquals(expectLink, MarkdownParse.getLinks(contents));
    }

}

/**
 * @Test
 *       public void addition() {
 *       assertEquals(2, 1 + 1);
 *       }
 * @Test
 *       public void getLinks() throws IOException {
 *       String contents = Files.readString(Path.of("./test-file.md"));
 *       List<String> expectLink = List.of("https://something.com",
 *       "some-page.html");
 *       assertEquals(MarkdownParse.getLinks(contents), expectLink);
 *       }
 * 
 * @Test
 *       public void testbreakFile() throws IOException {
 *       String contents = Files.readString(Path.of("./break-file.md"));
 *       List<String> expectLink = List.of("https://something.com",
 *       "some-page.html");
 *       assertEquals(MarkdownParse.getLinks(contents), expectLink);
 *       }
 * 
 * @Test
 *       public void testbreakFileTwo() throws IOException {
 *       String contents = Files.readString(Path.of("./break-file2.md"));
 *       List<String> expectLink = List.of("https://something.com",
 *       "some-page.html");
 *       assertEquals(MarkdownParse.getLinks(contents), expectLink);
 *       }
 */