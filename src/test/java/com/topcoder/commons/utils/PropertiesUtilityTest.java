package com.topcoder.commons.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

import static org.junit.Assert.*;

public class PropertiesUtilityTest {

    private Properties properties;
    private boolean requiredTrue;
    private boolean requiredFalse;
    private String delimiter;

    public PropertiesUtilityTest() {
        // empty
    }

    private void loadProperties() {
        final String PROPERTIES_DIR = "src/main/resources/test.properties";
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(PROPERTIES_DIR));
            properties = new Properties();
            properties.load(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Before
    public void setUp() throws Exception {
        loadProperties();
        this.requiredTrue = true;
        this.requiredFalse = false;
        this.delimiter = ",";
    }

    @After
    public void tearDown() {
        // empty
    }

    @Test
    public void testGetStringProperty() throws Exception {
        final String TEST_VALUE = "abcd";
        String actualValue = PropertiesUtility.getStringProperty(properties, "stringProperty", requiredTrue,
                Exception.class);
        assertEquals(TEST_VALUE, actualValue);
        PropertiesUtility.getStringProperty(properties, "nullStringProperty", requiredFalse,
                NoSuchFieldException.class);

    }

    @Test(expected = NoSuchFieldException.class)
    public void testGetStringPropertyThrowsNoSuchFieldException() throws Exception {
        PropertiesUtility.getStringProperty(properties, "nullStringProperty", requiredTrue,
                NoSuchFieldException.class);

    }

    @Test
    public void testGetStringsProperty() throws Exception {
        final String[] TEST_VALUE = new String[]{"a", "b", "c", "d"};
        String[] actualValue = PropertiesUtility.getStringsProperty(properties, "stringsProperty", delimiter,
                requiredTrue,
                Exception.class);
        assertArrayEquals(TEST_VALUE, actualValue);
        PropertiesUtility.getStringsProperty(properties, "nullStringsProperty", delimiter, requiredFalse,
                NoSuchFieldException.class);
    }

    @Test(expected = NoSuchFieldException.class)
    public void testGetStringsPropertyThrowsNoSuchFieldException() throws Exception {
        PropertiesUtility.getStringsProperty(properties, "nullStringsProperty", delimiter, requiredTrue,
                NoSuchFieldException.class);

    }

    @Test
    public void testGetIntegerProperty() throws Exception {
        final int TEST_VALUE = 1234;
        int actualValue = PropertiesUtility.getIntegerProperty(properties, "integerProperty", requiredTrue,
                Exception.class);
        assertEquals(TEST_VALUE, actualValue);
        PropertiesUtility.getIntegerProperty(properties, "nullIntegerProperty", requiredFalse,
                NoSuchFieldException.class);

    }

    @Test(expected = NoSuchFieldException.class)
    public void testGetIntegerPropertyThrowsNoSuchFieldException() throws Exception {
        PropertiesUtility.getIntegerProperty(properties, "nullIntegerProperty", requiredTrue,
                NoSuchFieldException.class);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetIntegerPropertyThrowsIllegalArgumentException() throws Exception {
        PropertiesUtility.getIntegerProperty(properties, "integerProperty2", requiredTrue,
                IllegalArgumentException.class);
    }

    @Test
    public void testGetLongProperty() throws Exception {
        final long TEST_VALUE = 123456;
        long actualValue = PropertiesUtility.getLongProperty(properties, "longProperty", requiredTrue,
                Exception.class);
        assertEquals(TEST_VALUE, actualValue);
        PropertiesUtility.getLongProperty(properties, "nullLongProperty", requiredFalse,
                NoSuchFieldException.class);

    }

    @Test(expected = NoSuchFieldException.class)
    public void testGetLongPropertyThrowsNoSuchFieldException() throws Exception {
        PropertiesUtility.getLongProperty(properties, "nullLongProperty", requiredTrue,
                NoSuchFieldException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetLongPropertyThrowsIllegalArgumentException() throws Exception {
        PropertiesUtility.getLongProperty(properties, "longProperty2", requiredTrue,
                IllegalArgumentException.class);
    }

    @Test
    public void testGetDoubleProperty() throws Exception {
        final double TEST_VALUE = 1234.56;
        double actualValue = PropertiesUtility.getDoubleProperty(properties, "doubleProperty", requiredTrue,
                Exception.class);
        assertEquals(TEST_VALUE, actualValue);
        PropertiesUtility.getDoubleProperty(properties, "nullDoubleProperty", requiredFalse,
                NoSuchFieldException.class);
    }

    @Test(expected = NoSuchFieldException.class)
    public void testGetDoublePropertyThrowsNoSuchFieldException() throws Exception {
        PropertiesUtility.getDoubleProperty(properties, "nullDoubleProperty", requiredTrue,
                NoSuchFieldException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetDoublePropertyThrowsIllegalArgumentException() throws Exception {
        PropertiesUtility.getDoubleProperty(properties, "doubleProperty2", requiredTrue,
                IllegalArgumentException.class);
    }

    @Test
    public void testGetDateProperty() throws Exception {
        final String DATE_STRING = "2018-10-01";
        final String DATE_FORMAT = "yyyy-mm-dd";
        final Date TEST_VALUE = new SimpleDateFormat(DATE_FORMAT, Locale.US).parse(DATE_STRING,
                new ParsePosition(0));
        Date actualValue = PropertiesUtility.getDateProperty(properties, "dateProperty", DATE_FORMAT, requiredTrue,
                Exception.class);
        assertEquals(TEST_VALUE, actualValue);
        PropertiesUtility.getDateProperty(properties, "nullDateProperty", DATE_FORMAT, requiredFalse,
                NoSuchFieldException.class);
    }

    @Test(expected = NoSuchFieldException.class)
    public void testGetDatePropertyThrowsNoSuchFieldException() throws Exception {
        final String DATE_FORMAT = "yyyy-mm-dd";
        PropertiesUtility.getDateProperty(properties, "nullDateProperty", DATE_FORMAT, requiredTrue,
                NoSuchFieldException.class);
    }

    @Test(expected = Exception.class)
    public void testGetDatePropertyThrowsException() throws Exception {
        final String DATE_FORMAT = "yyyymmdd";
        PropertiesUtility.getDateProperty(properties, "dateProperty2", DATE_FORMAT, requiredTrue,
                Exception.class);
    }

    @Test(expected = Exception.class)
    public void testGetDatePropertyThrowsException2() throws Exception {
        final String DATE_FORMAT = "yyyy-mm-dd";
        PropertiesUtility.getDateProperty(properties, "dateProperty3", DATE_FORMAT, requiredTrue,
                Exception.class);
    }

    @Test
    public void testGetClassProperty() throws Exception {
        final Class TEST_VALUE = java.lang.System.class;
        Class actualValue = PropertiesUtility.getClassProperty(properties, "classProperty", requiredTrue,
                Exception.class);
        assertEquals(TEST_VALUE, actualValue);
        PropertiesUtility.getClassProperty(properties, "nullClassProperty", requiredFalse, Exception.class);
    }

    @Test(expected = NoSuchFieldException.class)
    public void testGetClassPropertyThrowsNoSuchFieldException() throws Exception {
        PropertiesUtility.getClassProperty(properties, "nullClassProperty", requiredTrue,
                NoSuchFieldException.class);
    }

    @Test(expected = Exception.class)
    public void testGetClassPropertyThrowsException() throws Exception {
        Class actualValue = PropertiesUtility.getClassProperty(properties, "classProperty2", requiredTrue,
                Exception.class);
    }

    @Test
    public void testGetSubConfiguration() {
        Properties testValue = new Properties();
        testValue.setProperty("property1", "conf1");
        testValue.setProperty("property2", "conf2");
        testValue.setProperty("property3", "conf3");
        Properties actualValue = PropertiesUtility.getSubConfiguration(properties, "conf");
        assertEquals(testValue, actualValue);
    }
}
