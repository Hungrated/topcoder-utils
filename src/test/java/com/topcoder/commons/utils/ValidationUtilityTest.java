package com.topcoder.commons.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ValidationUtilityTest {

    private String VARIABLE_NAME;

    private Object NULL_OBJECT;
    private String NULL_STRING;
    private File NULL_FILE;
    private Collection NULL_COLLECTION;
    private Map NULL_MAP;

    private String EMPTY_STRING;
    private String LEGAL_STRING;

    private File LEGAL_FILE;
    private File ILLEGAL_FILE;
    private File LEGAL_DIR;

    private Collection EMPTY_COLLECTION;
    private Collection<String> LEGAL_COLLECTION;
    private Collection<String> ILLEGAL_COLLECTION1;
    private Collection<String> ILLEGAL_COLLECTION2;
    private Collection<Collection> ILLEGAL_COLLECTION3;
    private Collection<Map> ILLEGAL_COLLECTION4;

    private Map EMPTY_MAP;
    private Map<String, String> LEGAL_MAP;
    private Map<String, String> ILLEGAL_MAP1;
    private Map<String, String> ILLEGAL_MAP2;
    private Map<String, String> ILLEGAL_MAP3;
    private Map<String, String> ILLEGAL_MAP4;
    private Map<Collection, Collection> ILLEGAL_MAP5;
    private Map<Map, Map> ILLEGAL_MAP6;

    private Class<String> EXPECTED_TYPE;
    private Class UNEXPECTED_TYPE;

    private double POSITIVE_DOUBLE_VALUE;
    private double NEGATIVE_DOUBLE_VALUE;
    private double ZERO_DOUBLE_VALUE;

    private long POSITIVE_LONG_VALUE;
    private long NEGATIVE_LONG_VALUE;
    private long ZERO_LONG_VALUE;

    @Before
    public void setUp() {
        VARIABLE_NAME = "variableName";

        NULL_OBJECT = null;
        NULL_STRING = null;
        NULL_FILE = null;
        NULL_COLLECTION = null;
        NULL_MAP = null;

        EMPTY_STRING = "";
        LEGAL_STRING = "testValidation";
        LEGAL_FILE = new File("src/main/resources/testValidation");
        ILLEGAL_FILE = new File("src/main/resources/testValidation2");
        LEGAL_DIR = new File("src/main/resources/");
        EMPTY_COLLECTION = new ArrayList();
        LEGAL_COLLECTION = new ArrayList<String>(Arrays.asList("a", "b", "c"));
        ILLEGAL_COLLECTION1 = new ArrayList<String>(Arrays.asList(null, null, "c"));
        ILLEGAL_COLLECTION2 = new ArrayList<String>(Arrays.asList("", "", ""));
        ILLEGAL_COLLECTION3 = new ArrayList<Collection>(Arrays.asList(new ArrayList(), new ArrayList(),
                new ArrayList()));
        ILLEGAL_COLLECTION4 = new ArrayList<Map>(Arrays.asList(new HashMap(), new HashMap(), new HashMap()));
        EMPTY_MAP = new HashMap();
        LEGAL_MAP = new HashMap<String, String>();
        LEGAL_MAP.put("a", "1");
        LEGAL_MAP.put("b", "2");
        LEGAL_MAP.put("c", "3");
        ILLEGAL_MAP1 = new HashMap<String, String>();
        ILLEGAL_MAP1.put(null, null);
        ILLEGAL_MAP2 = new HashMap<String, String>();
        ILLEGAL_MAP2.put("a", null);
        ILLEGAL_MAP3 = new HashMap<String, String>();
        ILLEGAL_MAP3.put("", "a");
        ILLEGAL_MAP4 = new HashMap<String, String>();
        ILLEGAL_MAP4.put("a", "");
        ILLEGAL_MAP5 = new HashMap<Collection, Collection>();
        ILLEGAL_MAP5.put(new ArrayList(), new ArrayList());
        ILLEGAL_MAP6 = new HashMap<Map, Map>();
        ILLEGAL_MAP6.put(new HashMap(), new HashMap());

        EXPECTED_TYPE = String.class;
        UNEXPECTED_TYPE = Exception.class;

        POSITIVE_DOUBLE_VALUE = 1.0;
        NEGATIVE_DOUBLE_VALUE = -1.0;
        ZERO_DOUBLE_VALUE = 0.0;
        POSITIVE_LONG_VALUE = 1;
        NEGATIVE_LONG_VALUE = -1;
        ZERO_LONG_VALUE = 0;
    }

    @After
    public void tearDown() {
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotNull() throws Exception {
        ValidationUtility.checkNotNull(LEGAL_STRING, VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkNotNull(NULL_OBJECT, VARIABLE_NAME, IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotEmpty() throws Exception {
        ValidationUtility.checkNotEmpty(LEGAL_STRING, VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkNotEmpty(NULL_STRING, VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkNotEmpty(EMPTY_STRING, VARIABLE_NAME, IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotEmptyAfterTrimming() throws Exception {
        ValidationUtility.checkNotEmptyAfterTrimming(LEGAL_STRING, VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkNotEmptyAfterTrimming(NULL_STRING, VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkNotEmptyAfterTrimming(EMPTY_STRING, VARIABLE_NAME, IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotNullNorEmpty() throws Exception {
        ValidationUtility.checkNotNullNorEmpty(LEGAL_STRING, VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkNotNullNorEmpty(EMPTY_STRING, VARIABLE_NAME, IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotNullNorEmptyAfterTrimming() throws Exception {
        ValidationUtility.checkNotNullNorEmptyAfterTrimming(LEGAL_STRING, VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkNotNullNorEmptyAfterTrimming(EMPTY_STRING, VARIABLE_NAME, IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckInstance() throws Exception {
        ValidationUtility.checkInstance(LEGAL_STRING, EXPECTED_TYPE, VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkInstance(LEGAL_STRING, UNEXPECTED_TYPE, VARIABLE_NAME, IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNullOrInstance() throws Exception {
        ValidationUtility.checkNullOrInstance(LEGAL_STRING, EXPECTED_TYPE, VARIABLE_NAME,
                IllegalArgumentException.class);
        ValidationUtility.checkNullOrInstance(NULL_OBJECT, UNEXPECTED_TYPE, VARIABLE_NAME,
                IllegalArgumentException.class);
        ValidationUtility.checkNullOrInstance(LEGAL_STRING, UNEXPECTED_TYPE, VARIABLE_NAME,
                IllegalArgumentException.class);
    }

    @Test(expected = FileNotFoundException.class)
    public void testCheckExists() throws Exception {
        ValidationUtility.checkExists(LEGAL_FILE, VARIABLE_NAME, FileNotFoundException.class);
        ValidationUtility.checkExists(NULL_FILE, VARIABLE_NAME, FileNotFoundException.class);
        ValidationUtility.checkExists(ILLEGAL_FILE, VARIABLE_NAME, FileNotFoundException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckIsFile() throws Exception {
        ValidationUtility.checkIsFile(LEGAL_FILE, VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkIsFile(NULL_FILE, VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkIsFile(LEGAL_DIR, VARIABLE_NAME, IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckIsDirectory() throws Exception {
        ValidationUtility.checkIsDirectory(LEGAL_DIR, VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkIsDirectory(NULL_FILE, VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkIsDirectory(LEGAL_FILE, VARIABLE_NAME, IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotEmpty1() throws Exception {
        ValidationUtility.checkNotEmpty(LEGAL_COLLECTION, VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkNotEmpty(NULL_COLLECTION, VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkNotEmpty(EMPTY_COLLECTION, VARIABLE_NAME, IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotNullNorEmpty1() throws Exception {
        ValidationUtility.checkNotNullNorEmpty(LEGAL_COLLECTION, VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkNotNullNorEmpty(EMPTY_COLLECTION, VARIABLE_NAME, IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotEmpty2() throws Exception {

        ValidationUtility.checkNotEmpty(LEGAL_MAP, VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkNotEmpty(EMPTY_MAP, VARIABLE_NAME, IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotNullNorEmpty2() throws Exception {
        ValidationUtility.checkNotNullNorEmpty(LEGAL_MAP, VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkNotNullNorEmpty(NULL_MAP, VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkNotNullNorEmpty(EMPTY_MAP, VARIABLE_NAME, IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotNullElements() throws Exception {
        ValidationUtility.checkNotNullElements(LEGAL_COLLECTION, VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkNotNullElements(NULL_COLLECTION, VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkNotNullElements(ILLEGAL_COLLECTION1, VARIABLE_NAME, IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotEmptyElements() throws Exception {
        ValidationUtility.checkNotEmptyElements(LEGAL_COLLECTION, false, VARIABLE_NAME,
                IllegalArgumentException.class);
        ValidationUtility.checkNotEmptyElements(LEGAL_COLLECTION, true, VARIABLE_NAME,
                IllegalArgumentException.class);
        ValidationUtility.checkNotEmptyElements(NULL_COLLECTION, true, VARIABLE_NAME,
                IllegalArgumentException.class);
        ValidationUtility.checkNotEmptyElements(ILLEGAL_COLLECTION2, true, VARIABLE_NAME,
                IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotEmptyElements2() throws Exception {
        ValidationUtility.checkNotEmptyElements(ILLEGAL_COLLECTION3, true, VARIABLE_NAME,
                IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotEmptyElements3() throws Exception {
        ValidationUtility.checkNotEmptyElements(ILLEGAL_COLLECTION4, true, VARIABLE_NAME,
                IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotNullKeys() throws Exception {
        ValidationUtility.checkNotNullKeys(NULL_MAP, VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkNotNullKeys(LEGAL_MAP, VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkNotNullKeys(ILLEGAL_MAP1, VARIABLE_NAME, IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotNullValues() throws Exception {
        ValidationUtility.checkNotNullValues(NULL_MAP, VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkNotNullValues(LEGAL_MAP, VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkNotNullValues(ILLEGAL_MAP2, VARIABLE_NAME, IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotEmptyKeys() throws Exception {
        ValidationUtility.checkNotEmptyKeys(LEGAL_MAP, true, VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkNotEmptyKeys(LEGAL_MAP, false, VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkNotEmptyKeys(NULL_MAP, false, VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkNotEmptyKeys(ILLEGAL_MAP3, true, VARIABLE_NAME,
                IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotEmptyKeys2() throws Exception {
        ValidationUtility.checkNotEmptyKeys(NULL_MAP, false, VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkNotEmptyKeys(ILLEGAL_MAP5, true, VARIABLE_NAME,
                IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotEmptyKeys3() throws Exception {
        ValidationUtility.checkNotEmptyKeys(NULL_MAP, false, VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkNotEmptyKeys(ILLEGAL_MAP6, true, VARIABLE_NAME,
                IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotEmptyValues() throws Exception {
        ValidationUtility.checkNotEmptyValues(LEGAL_MAP, false, VARIABLE_NAME,
                IllegalArgumentException.class);
        ValidationUtility.checkNotEmptyValues(LEGAL_MAP, true, VARIABLE_NAME,
                IllegalArgumentException.class);
        ValidationUtility.checkNotEmptyValues(NULL_MAP, false, VARIABLE_NAME,
                IllegalArgumentException.class);
        ValidationUtility.checkNotEmptyValues(ILLEGAL_MAP4, true, VARIABLE_NAME,
                IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotEmptyValues2() throws Exception {
        ValidationUtility.checkNotEmptyValues(NULL_MAP, false, VARIABLE_NAME,
                IllegalArgumentException.class);
        ValidationUtility.checkNotEmptyValues(ILLEGAL_MAP5, true, VARIABLE_NAME,
                IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotEmptyValues3() throws Exception {
        ValidationUtility.checkNotEmptyValues(NULL_MAP, false, VARIABLE_NAME,
                IllegalArgumentException.class);
        ValidationUtility.checkNotEmptyValues(ILLEGAL_MAP6, true, VARIABLE_NAME,
                IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNegative() throws Exception {
        ValidationUtility.checkNegative(NEGATIVE_DOUBLE_VALUE, VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkNegative(POSITIVE_DOUBLE_VALUE, VARIABLE_NAME, IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckPositive() throws Exception {
        ValidationUtility.checkPositive(POSITIVE_DOUBLE_VALUE, VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkPositive(NEGATIVE_DOUBLE_VALUE, VARIABLE_NAME, IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotNegative() throws Exception {
        ValidationUtility.checkNotNegative(ZERO_DOUBLE_VALUE, VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkNotNegative(NEGATIVE_DOUBLE_VALUE, VARIABLE_NAME, IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotPositive() throws Exception {
        ValidationUtility.checkNotPositive(ZERO_DOUBLE_VALUE, VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkNotPositive(POSITIVE_DOUBLE_VALUE, VARIABLE_NAME, IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotZero() throws Exception {
        ValidationUtility.checkNotZero(POSITIVE_DOUBLE_VALUE, VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkNotZero(ZERO_DOUBLE_VALUE, VARIABLE_NAME, IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckGreaterThan() throws Exception {
        ValidationUtility.checkGreaterThan(POSITIVE_DOUBLE_VALUE, 0.0, false, VARIABLE_NAME,
                IllegalArgumentException.class);
        ValidationUtility.checkGreaterThan(POSITIVE_DOUBLE_VALUE, 0.0, true, VARIABLE_NAME,
                IllegalArgumentException.class);
        ValidationUtility.checkGreaterThan(NEGATIVE_DOUBLE_VALUE, 0.0, true, VARIABLE_NAME,
                IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckGreaterThan2() throws Exception {
        ValidationUtility.checkGreaterThan(NEGATIVE_DOUBLE_VALUE, 0.0, false, VARIABLE_NAME,
                IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckLessThan() throws Exception {
        ValidationUtility.checkLessThan(NEGATIVE_DOUBLE_VALUE, 0.0, false, VARIABLE_NAME,
                IllegalArgumentException.class);
        ValidationUtility.checkLessThan(NEGATIVE_DOUBLE_VALUE, 0.0, true, VARIABLE_NAME,
                IllegalArgumentException.class);
        ValidationUtility.checkLessThan(POSITIVE_DOUBLE_VALUE, 0.0, true, VARIABLE_NAME,
                IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckLessThan2() throws Exception {
        ValidationUtility.checkLessThan(POSITIVE_DOUBLE_VALUE, 0.0, false, VARIABLE_NAME,
                IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckInRange() throws Exception {
        ValidationUtility.checkInRange(POSITIVE_DOUBLE_VALUE, 0.0, 2.0, false, false,
                VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkInRange(POSITIVE_DOUBLE_VALUE, 0.0, 2.0, true, true,
                VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkInRange(NEGATIVE_DOUBLE_VALUE, 0.0, 2.0, false, false,
                VARIABLE_NAME, IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNegative2() throws Exception {
        ValidationUtility.checkNegative(NEGATIVE_LONG_VALUE, VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkNegative(POSITIVE_LONG_VALUE, VARIABLE_NAME, IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckPositive2() throws Exception {
        ValidationUtility.checkPositive(POSITIVE_LONG_VALUE, VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkPositive(NEGATIVE_LONG_VALUE, VARIABLE_NAME, IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotNegative2() throws Exception {
        ValidationUtility.checkNotNegative(ZERO_LONG_VALUE, VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkNotNegative(NEGATIVE_LONG_VALUE, VARIABLE_NAME, IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotPositive2() throws Exception {
        ValidationUtility.checkNotPositive(ZERO_LONG_VALUE, VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkNotPositive(POSITIVE_LONG_VALUE, VARIABLE_NAME, IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckNotZero2() throws Exception {
        ValidationUtility.checkNotZero(POSITIVE_LONG_VALUE, VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkNotZero(ZERO_LONG_VALUE, VARIABLE_NAME, IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckGreaterThan3() throws Exception {
        ValidationUtility.checkGreaterThan(POSITIVE_LONG_VALUE, 0, false, VARIABLE_NAME,
                IllegalArgumentException.class);
        ValidationUtility.checkGreaterThan(POSITIVE_LONG_VALUE, 0, true, VARIABLE_NAME,
                IllegalArgumentException.class);
        ValidationUtility.checkGreaterThan(NEGATIVE_LONG_VALUE, 0, true, VARIABLE_NAME,
                IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckGreaterThan4() throws Exception {
        ValidationUtility.checkGreaterThan(NEGATIVE_LONG_VALUE, 0, false, VARIABLE_NAME,
                IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckLessThan3() throws Exception {
        ValidationUtility.checkLessThan(NEGATIVE_LONG_VALUE, 0, false, VARIABLE_NAME,
                IllegalArgumentException.class);
        ValidationUtility.checkLessThan(NEGATIVE_LONG_VALUE, 0, true, VARIABLE_NAME,
                IllegalArgumentException.class);
        ValidationUtility.checkLessThan(POSITIVE_LONG_VALUE, 0, true, VARIABLE_NAME,
                IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckLessThan4() throws Exception {
        ValidationUtility.checkLessThan(POSITIVE_LONG_VALUE, 0, false, VARIABLE_NAME,
                IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckInRange2() throws Exception {
        ValidationUtility.checkInRange(POSITIVE_LONG_VALUE, 0, 2, false, false,
                VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkInRange(POSITIVE_LONG_VALUE, 0, 2, true, true,
                VARIABLE_NAME, IllegalArgumentException.class);
        ValidationUtility.checkInRange(NEGATIVE_LONG_VALUE, 0, 2, false, false,
                VARIABLE_NAME, IllegalArgumentException.class);
    }
}
