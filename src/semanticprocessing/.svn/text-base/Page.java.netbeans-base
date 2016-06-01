package semanticprocessing;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

/**
 * Creates an instance of a Page, which contains the URL location and the
 * pageContent of the page, excluding the HTML.
 * @author Moody, Frank and Hussam
 */
public class Page {

    /** The URL of this page.*/
    private URL urlLocation;
    /** The content of this page. */
    private String pageContent;
    /** The number of times to attempt to connect to a web site that returns
     * an error.  */
    private static final int NUMBER_OF_TRYS_PER_LINK = 3;

    /**
     * Creates a Page, containing its <code>URL</code> instance, and the content
     * of the URL (excluding HTML tags).
     * @param url The <code>URL</code> of the <code>Page</code> that is to be
     * created.
     * @throws IOException If the FileOps instance cannot read the file.
     */
    public Page(final URL url) throws NotAnHtmlUrlException, IOException {
        // Attempt to read given URL. If unreachable, try up to
        // NUMBER_OF_TRYS_PER_LINK. If not HTML, throw exception
        ArrayList result = null;
        boolean success = false;
        int i = 0;
        while (!success) {
            try {
                result = FileOps.readOnlineFile(url);
                success = true;
            } catch (IOException ex) {
                i++;
                if (i > NUMBER_OF_TRYS_PER_LINK) {
                    throw ex;
                }
            }
        }
        // Result contains the proper URL at 0 and its content at 1
        urlLocation = removeFragment((URL) result.get(0));
        pageContent = result.get(1).toString();
    }

    /**
     * Second constructor used only for testing. Does not read the pageContent
     * of the page directly; rather, it accepts it as a parameter.
     * @param url The URL of the page
     * @param content The content of the page
     */
    public Page(final URL url, final String content) {
        this.urlLocation = url;
        this.pageContent = content;
    }

    /**
     * Retrieves the pageContent of the Page, excluding HTML tags.
     * @return <code>this.pageContent</code> - The pageContent of the Page's
     * URL,
     * excluding HTML.
     */
    public final String getContent() {
        return removeHTML(pageContent);
    }

    /**
     * Retrieve the URL of the Page instance.
     * @return <code>URL</code> instance of the Page's URL.
     */
    public final URL getURL() {
        return urlLocation;
    }

    /**
     * Returns true if the current Page instances URL is equal to the
     * parameter.
     * @param other A Page instance, to test against the current instance.
     * @return <code>true</code> If the two Page instances are equal.
     */
    public boolean equals(Page other) {
        return this.getURL() == other.getURL();
    }

    /**
     * Gets the URLs that appear on this page without their fragments. The URLs
     * are those that appear in href attribute of a tags, in src attribute
     * of iframe tags, and the URL that this page redirects to, if any.
     * Removes fragments (#something) from the returned URLs.
     * An example of a fragment is "#today" in
     *                          http://www.hostname.com/weather#today
     * @return The URLs that appear on this page. The same URL may be repeated.
     */
    public final ArrayList<URL> getUrls() {
        // Get root tag
        TagNode root = getRootTag(pageContent);
        ArrayList<String> links = getAttributeValue(root, "a", "href");
        // Add frame content.
        links.addAll(this.getAttributeValue(root, "iframe", "src"));
        links.addAll(this.getAttributeValue(root, "frame", "src"));
        // Add redirect URL.
        String redirectUrl = redirectUrl(root);
        if (redirectUrl != null) {
            links.add(redirectUrl);
        }
        // Convert to URLs and add to list.
        ArrayList<URL> urls = new ArrayList<URL>();
        for (String link : links) {
            URL url = toAbsoluteUrl(removeFragment(link));
            if (url != null) {
                urls.add(url);
            }
        }
        return urls;
    }

    /**
     * Removes fragments (#something) from the returned URLs.
     * An example of a fragment is "#today" in
     *                          http://www.hostname.com/weather#today
     * @param url A URL that may or may not contain a fragment.
     * @return The given URL without its fragment.
     */
    private URL removeFragment(final URL url) {
        String urlString = url.toString();
        urlString = removeFragment(urlString);
        URL result = null;
        try {
            result = new URL(urlString);
        } catch (MalformedURLException ex) {
            // Never occurs since we are starting with a String from a URL.
        }
        return result;
    }

    /**
     * Removes HTML tags and formatting from the indicated String.
     * @param html A String that contains the pageContent of the URL including
     * all HTML tags.
     * @return A String that contains the pageContent of the URL EXCLUDING all
     * HTML tags.
     */
    private String removeHTML(final String html) {
        String str = html;
        //This ignores character-abbreviations '&nbsp'
        str = html.replaceAll("&[\\w\\d#]*;", " ");
        //This ignores HTML comments in form <!-- -->
        str = str.replaceAll("(?s)<!--.*?-->", " ");
        //This ignores tag and everything inbetween. Handles '<>'
        str = str.replaceAll("<[^>]*>", " ");
        //This handles unorganized HTML, and random tag endings/openings.
        str = str.replaceAll("[(/>)<]", " ");
        return str;
    }

    /**
     * Gets the root tag of the given html content.
     * @param html The HTML content from which to extract root tag.
     * @return The root tag of the given content.
     */
    private TagNode getRootTag(String html) {
        HtmlCleaner cleaner = new HtmlCleaner();
        TagNode root;
        try {
            root = cleaner.clean(html);
        } catch (IOException ex) {
            // This should never happen. Reading a string should never trigger
            // an IOException.
            return null;
        }
        return root;
    }

    /**
     * Returns the first URL that the given page redirects to.
     * @param pageContent The content of an HTML page.
     * @return A string with a URL that this page redirects to, or "" if the
     * page does not redirect to any other page.
     */
    private String redirectUrl(TagNode root) {
        // Get meta tags
        ArrayList<String> metaContent = getAttributeValue(root, "meta",
                "content", "http-equiv", "refresh");
        if (metaContent.isEmpty()) {
            return null;
        }
        // There cannot be more than 1 redirect URL. If there are more, take
        // the first only.
        String redirectURL = metaContent.get(0);
        redirectURL = redirectURL.replaceAll("^.*;", "");
        redirectURL = redirectURL.replaceAll(
                "^\\s*(u|U)(r|R)(l|L)\\s*=\\s*", "");
        return redirectURL;
    }

    /**
     * Gets the value of the given attribute in all of the given tags that
     * contain the given attribute.
     * @param tags The tags to search for the given attribute.
     * @param attributeName The name of attribute to look for.
     * @return The values of the given attribute in the given tags.
     */
    private ArrayList<String> getAttributeValue(TagNode[] tags,
            String attributeName) {
        ArrayList<String> values = new ArrayList<String>();
        for (TagNode tag : tags) {
            if (tag.hasAttribute(attributeName)) {
                // For some reason the library seems to be repeating relative
                // links. This gets around it.
                String hrefValue = tag.getAttributeByName(attributeName);
                if (!values.contains(hrefValue)) {
                    values.add(hrefValue);
                }
            }
        }
        return values;
    }

    /**
     * Gets the values of the given attribute from the tags with the given
     * tag name.
     * @param root The root tag that contains all other tags.
     * @param tagName The name of the tag in which the given attribute appears.
     * @param attributeName The name of the attribute whose value is to be
     * extracted.
     * @return An ArrayList containing the values of the given attributes in the
     * given string.
     */
    private ArrayList<String> getAttributeValue(TagNode root, String tagName,
            String attributeName) {
        TagNode[] tags = root.getElementsByName(tagName, true);
        ArrayList<String> values = getAttributeValue(tags, attributeName);
        return values;
    }

    /**
     * Returns the values of the given attribute from tags with the given name
     * that have the given mustHaveAttribute and the given
     * mustHaveAttributeValue.
     * @param root The root tag that contains all other tags.
     * @param tagName The name of the tag in which the given attribute appears.
     * @param attributeName The name of the attribute whose value is to be
     * extracted.
     * @param mustHaveAttribute Tags that don't have this attribute are ignored.
     * @param mustHaveAttributeValue Tags whose mustHaveAttribute's don't
     * contain this value are ignored.
     * @return The values of the given attribute from tags with the given
     * name that have the given attribute with the given attribute value.
     */
    private ArrayList<String> getAttributeValue(final TagNode root,
            String tagName, String attributeName, String mustHaveAttribute,
            String mustHaveAttributeValue) {
        // Get all tags in html
        TagNode[] tags = root.getElementsByName(tagName, true);
        ArrayList<TagNode> acceptedTags = new ArrayList<TagNode>();
        mustHaveAttributeValue = mustHaveAttributeValue.toLowerCase();
        for (TagNode tag : tags) {
            if (tag.hasAttribute(mustHaveAttribute)) {
                if (tag.getAttributeByName(mustHaveAttribute).toLowerCase().
                        equals(mustHaveAttributeValue)) {
                    acceptedTags.add(tag);
                }
            }
        }
        return getAttributeValue(acceptedTags.toArray(new TagNode[0]),
                attributeName);
    }

    /**
     * Accepts a relative and absolute paths and converts the relative
     * ones to absolute in the context of the URL of this page. null is returned
     * if the given URL is malformed and raises a MalformedURLException.
     * @param links A URL that may be relative or absolute.
     * @return The given URL converted too absolute in the context of this Page
     * if the given URL is relative, or the URL itself unchanged if it is
     * absolute, or null if the link given is malformed..
     */
    private URL toAbsoluteUrl(final String link) {
        URL url;
        try {
            // Create a URL object in the context of this Page's URL
            url = new URL(urlLocation, link);

        } catch (MalformedURLException ex) {
            // If a URL is invalid ignore it
            return null;
        }

        return url;
    }

    /**
     * Removes fragments (#something) from the returned URLs.
     * An example of a fragment is "#today" in
     *                          http://www.hostname.com/weather#today
     * @param link A string representing a link that may or may not contain
     * a fragment.
     * @return A string representing the given link with its fragment removed
     * (if there was one)
     */
    private String removeFragment(final String link) {
        Pattern fragmentPattern = Pattern.compile("(#\\w*$)");
        Matcher matcher = fragmentPattern.matcher(link);

        String result = link;

        if (matcher.find()) {
            result = link.substring(0, matcher.start());
        }
        return result;
    }
}
