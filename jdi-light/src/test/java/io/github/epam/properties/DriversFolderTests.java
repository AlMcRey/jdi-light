package io.github.epam.properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.security.InvalidParameterException;
import java.util.Properties;

import static com.epam.jdi.light.common.Property.DRIVERS_FOLDER_PATH;
import static com.epam.jdi.light.common.PropertyValidationUtils.LINK_TO_EXAMPLES;
import static com.epam.jdi.light.common.PropertyValidationUtils.validateProperties;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class DriversFolderTests {

    @DataProvider
    public static Object[] negativeData() {
        return new Object[]{
                "../../folder",
                "..\\..\\folder",
                "",
                "c folder",
                "c:folder",
                "FOLDER//"};
    }

    @DataProvider
    public static Object[] positiveData() {
        return new Object[]{
                "A:/unixfolder",
                "C:/unix/Folder",
                "c:/unixfolder/SUBFOLDER",
                "/unix/folder",
                "/unix/folder/slashattheend/",
                "C:\\win\\subfolder",
                "C:\\winfolder",
                "C:\\win\\folder\\slashattheend\\"};
    }

    @Test(dataProvider = "negativeData")
    public void negativeTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(DRIVERS_FOLDER_PATH.getName(), value);
        try {
            validateProperties(properties);
            fail("Value '" + value + "' should not be valid for this test.");
        } catch (InvalidParameterException exp) {
            String expMessage = exp.getMessage();
            assertEquals(expMessage, DRIVERS_FOLDER_PATH.getExMsg() + LINK_TO_EXAMPLES);
        }
    }

    @Test(dataProvider = "positiveData")
    public void positiveTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(DRIVERS_FOLDER_PATH.getName(), value);
        validateProperties(properties);
    }
}