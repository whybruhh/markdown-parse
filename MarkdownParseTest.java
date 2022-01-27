import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void getLinks() throws IOException {
        String contents = Files.readString(Path.of("./test-file.md"));
        List<String> expectLink = List.of("https://something.com", "some-page.html");
        assertEquals(MarkdownParse.getLinks(contents), expectLink);
    }

    @Test
    public void testbreakFile() throws IOException {
        String contents = Files.readString(Path.of("./break-file.md"));
        List<String> expectLink = List.of("https://something.com", "some-page.html");
        assertEquals(MarkdownParse.getLinks(contents), expectLink);
    }

    @Test
    public void testbreakFileTwo() throws IOException {
        String contents = Files.readString(Path.of("./break-file2.md"));
        List<String> expectLink = List.of("https://something.com", "some-page.html");
        assertEquals(MarkdownParse.getLinks(contents), expectLink);
    }

    @Test
    public void testbreakFileThree() throws IOException {
        String contents = Files.readString(Path.of("./break-file3.md"));
        List<String> expectLink = List.of("hello.com");
        assertEquals(MarkdownParse.getLinks(contents), expectLink);
    }

    @Test
    public void testbreakFileFour() throws IOException {
        String contents = Files.readString(Path.of("./break-file4.md"));
        ArrayList<String> emptyList = new ArrayList<String>();
        assertEquals(MarkdownParse.getLinks(contents), emptyList);
    }

}
