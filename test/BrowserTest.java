import org.junit.Test;
import play.Application;
import play.test.Helpers;
import play.test.TestBrowser;
import play.test.WithBrowser;

import static org.junit.Assert.assertTrue;
import static play.test.Helpers.*;

public class BrowserTest extends WithBrowser {

    protected Application provideApplication() {
        return fakeApplication(inMemoryDatabase());
    }

    protected TestBrowser provideBrowser(int port) {
        return Helpers.testBrowser(port);
    }

    /**
     * add your integration test here
     * in this example we just check if the welcome page is being shown
     */
    @Test
    public void test() {
        browser.goTo("http://localhost:" + play.api.test.Helpers.testServerPort());
        assertTrue(browser.pageSource().contains("1"));
        assertTrue(browser.pageSource().contains("2"));
        assertTrue(browser.pageSource().contains("3"));
        assertTrue(browser.pageSource().contains("4"));
        assertTrue(browser.pageSource().contains("5"));
        assertTrue(browser.pageSource().contains("6"));
        assertTrue(browser.pageSource().contains("7"));
        assertTrue(browser.pageSource().contains("8"));
        assertTrue(browser.pageSource().contains("9"));
        assertTrue(browser.pageSource().contains("10"));
        assertTrue(browser.pageSource().contains("11"));
        assertTrue(browser.pageSource().contains("12"));
        assertTrue(browser.pageSource().contains("A"));
        assertTrue(browser.pageSource().contains("AA"));
        assertTrue(browser.pageSource().contains("AA1"));
        assertTrue(browser.pageSource().contains("AA2"));
        assertTrue(browser.pageSource().contains("B"));
        assertTrue(browser.pageSource().contains("C"));
        assertTrue(browser.pageSource().contains("CA"));
        assertTrue(browser.pageSource().contains("CA1"));
        assertTrue(browser.pageSource().contains("CA2"));
        assertTrue(browser.pageSource().contains("D"));
        assertTrue(browser.pageSource().contains("DA"));
    }

}
