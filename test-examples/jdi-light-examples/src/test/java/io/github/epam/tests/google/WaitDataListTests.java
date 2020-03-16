package io.github.epam.tests.google;

import io.github.epam.StaticTestsInit;
import org.testng.Assert;
import org.testng.annotations.*;

import static io.github.com.StaticSite.*;
import static io.github.com.pages.Header.*;
import static io.github.com.pages.SearchPage.*;
import static io.github.epam.tests.recommended.steps.Preconditions.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

/**
 * Created by Roman_Iovlev on 3/2/2018.
 */
public class WaitDataListTests extends StaticTestsInit {
    @BeforeMethod
    public void before() {
        homePage.shouldBeOpened();
        shouldBeLoggedIn();
        search("jdi");
    }

    @Test
    public void notEmptyTest() {
        searchS.is().notEmpty();
    }
    @Test
    public void notEmpty2Test() {
        searchS.assertThat(not(empty()));
    }
    @Test
    public void emptyTest() {

        try {
            searchS.is().empty();
            Assert.fail("List should not be empty");
        } catch (Throwable ignored) { }
        searchS.is().notEmpty();
    }
    @Test
    public void sizeTest() {
        assertEquals(searchS.size(), 6);
        searchS.is().size(equalTo(8));
    }
    @Test
    public void sizeGreaterTest() {
        searchS.is().size(greaterThan(7));
    }

}