package semanticprocessing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Contains methods that read from files and URLs and writes to files.
 * @author Hussam
 * added one function by Vera Rizvi
 */
public class FileOps {

    /** Denotes an HTML link. */
    private static final int IS_HTML_LINK = 0;
    /** Denotes a non-HTML link. */
    private static final int NOT_HTML_LINK = 1;
    /** Denotes a Content-Type header of value null. */
    private static final int NULL_TYPE = 2;
    /** Program directory. */
    public static final String CURRENT_DIRECTORY = System.getProperty(
            "user.dir") + "\\";

    /**
     * Constructor is not used.
     */
    private FileOps() {
    }

    /**
     * Reads the content of a local file.
     * @param f The file to read.
     * @return A string containing the content of the given file
     * @throws FileNotFoundException Thrown if the file does not exist.
     */
    public static String readFile(final File f) throws FileNotFoundException {
        String str = "";
        Scanner scanner = new Scanner(f);
        if (scanner.hasNextLine()) {
            str = scanner.nextLine() + "\n";
        }
        while (scanner.hasNextLine()) {
            str += scanner.nextLine() + "\n";
        }
        //scanner.close();???
        return str;
    }

    /**
     * Writes the given text to the given file.
     * @param text The text to write in the given file.
     * @param f The file to write.
     * @param appendValue Whether or not to append to the file, or start from
     * the beginning.
     * @param retValue Whether or not to return a new line at the end of the
     * write.
     * @throws IOException When an error occurs while writing, such as the
     * user not having write permissions
     */
    public static void writeToFile(final String text, final File f,
            final boolean appendValue, final boolean retValue)
            throws IOException {
        FileWriter writer = new FileWriter(f, appendValue);
        BufferedWriter bw = new BufferedWriter(writer);

        if (retValue) {
            bw.write(text);
            bw.newLine();
        } else {
            bw.write(text);
        }
        bw.close();
    }

    /**
     * Reads URLs from a text file, where each line represents a URL. Invalid
     * URLs are ignored
     * @param f The file to read
     * @return An ArrayList of the valid URLs in the text file
     * @throws IOException If an error occurs while reading the file
     */
    public static ArrayList<String> readURLsFromFile(final File f)
            throws IOException {
        String fileContent = readFile(f);
        // Split the string into lines
        String[] lines = fileContent.split("\\n");
        ArrayList<String> results = new ArrayList<String>();
        results.addAll(Arrays.asList(lines));
        return results;
    }

    /**
     * Reads the content of the given URL if it points to an HTML resource.
     * @param url A URL pointing to an HTML resource.
     * @return An array list of size 2. Index 0 is the URL as shown on the
     * server and index 1 is a string containing the content of the page if
     * the URL points to an HTML resource.
     * @throws NotAnHtmlUrlException If the URL doesn't point to an HTML page.
     * @throws IOException If an error occurs while trying to fetch the content,
     * or if the http header reports content type as null.
     */
    public static ArrayList readOnlineFile(final URL url)
            throws IOException, NotAnHtmlUrlException {
        URLConnection urlConnection = url.openConnection();
        ArrayList result = new ArrayList();

        switch (getStreamType(urlConnection)) {
            case IS_HTML_LINK:
                // If it is an HTML url, read it
                String content = readContent(urlConnection);
                result.add(urlConnection.getURL());
                result.add(content);
                return result;
            case NOT_HTML_LINK:
                throw new NotAnHtmlUrlException("The given URL points to "
                        + "non-HTML content");
            case NULL_TYPE:
                // If content type is null, there was an error connecting
                throw new IOException("Error connecting to resource");
            default:
                // Should never happen. Returns an empty array list.
                return result;
        }
    }

    /**
     * Checks whether the given URL connection is for an HTML object.
     * @param urlConnection A URLConnection for some URL.
     * @return <code>FileOps.IS_HTML_LINK</code> if the connection's content
     * type is HTML, <code>FileOps.NOT_HTML_LINK</code> if its not HTML,
     * and <code> FileOps.NULL_TYPE</code> if its null.
     */
    private static int getStreamType(URLConnection urlConnection) {
        String contentType = urlConnection.getContentType();

        if (contentType != null) {
            if (contentType.toLowerCase().contains("html")) {
                return IS_HTML_LINK;
            } else {
                return NOT_HTML_LINK;
            }
        } else {
            return NULL_TYPE;
        }
    }

    /**
     * Reads the content of the given URL connection.
     * @param urlConnection The connection whose content to read.
     * @return A string representing the content.
     * @throws IOException If the content is unreachable.
     */
    private static String readContent(URLConnection urlConnection)
            throws IOException {
        // Create a buffered reader object for the given connection
        InputStream is = urlConnection.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(isr);
        // Read the content line by line
        String nextLine = reader.readLine();
        String res = "";
        while (nextLine != null) {
            res += "\n";
            res += nextLine;
            nextLine = reader.readLine();
        }
        reader.close();
        isr.close();
        is.close();
        return res;
    }

    /**
     * Saves the data in cache into a given file name.
     * @param cache The instance of cache to save.
     * @param file The file where the given cache is to be saved.
     * @throws IOException If an error occurring while writing to file.
     */
    public static void saveCache(Cache cache, File file) throws IOException {
        saveObject(cache, file);
    }

    /**
     * Loads the cache from a given file.
     * @param file The file that contains the cache.
     * @return cache Returns the cache that is stored in the given file.
     * @throws IOException If the file is unreadable.
     * @throws FileNotFoundException If the file does not exist.
     * @throws InvalidCacheFileException If the file is readable but cannot
     * be parsed into an instance of Cache.
     */
    public static Cache loadCache(File file) throws FileNotFoundException,
            IOException, InvalidFileException {
        Object data = loadObject(file);
        if (data instanceof Cache) {
            return (Cache) data;
        } else {
            throw new InvalidFileException("Invalid file: " + file.getPath());
        }

    }

    /**
     * Saves the object into a given file name.
     * @param o The object to save.
     * @param file The file where the given object is to be saved.
     * @throws IOException If an error occurring while writing to file.
     */
    private static void saveObject(Object object, File file)
            throws IOException {
        file.createNewFile();
        FileOutputStream bytetOut = new FileOutputStream(file);
        ObjectOutputStream outer = new ObjectOutputStream(bytetOut);
        outer.writeObject(object);
        outer.flush();
        outer.close();
    }

    /**
     * Saves the data in cache into a given file name.
     * @param cache The instance of cache to save.
     * @param file The file where the given cache is to be saved.
     * @throws IOException If an error occurring while writing to file.
     */
    public static void saveSearch(Search search, File file) throws IOException {
        saveObject(search, file);
    }

    /**
     * Loads the cache from a given file.
     * @param file The file that contains the cache.
     * @return cache Returns the cache that is stored in the given file.
     * @throws IOException If the file is unreadable.
     * @throws FileNotFoundException If the file does not exist.
     * @throws InvalidCacheFileException If the file is readable but cannot
     * be parsed into an instance of Cache.
     */
    public static Search loadSearch(File file) throws FileNotFoundException,
            IOException, InvalidFileException {
        Object data = loadObject(file);
        if (data instanceof Search) {
            return (Search) data;
        } else {
            throw new InvalidFileException("Invalid file: " + file.getPath());
        }
    }

    /**
     * Opens the object stored in the given file.
     * @param file The file to read from.
     * @return The object stored in the file.
     * @throws FileNotFoundException If the file does not exist.
     * @throws IOException If an error occurs while reading from file.
     * @throws InvalidFileException If the file is not a valid Object file.
     */
    private static Object loadObject(File file)
            throws FileNotFoundException, IOException, InvalidFileException {
        FileInputStream byteOut = new FileInputStream(file);
        ObjectInputStream out = new ObjectInputStream(byteOut);
        Object data;
        try {
            data = out.readObject();
        } catch (OptionalDataException ex) {
            throw new InvalidFileException("Corrupt file: " + file.getPath());
        } catch (ClassNotFoundException ex) {
            throw new InvalidFileException("Corrupt file: " + file.getPath());
        }
        out.close();
        byteOut.close();
        return data;
    }
}
