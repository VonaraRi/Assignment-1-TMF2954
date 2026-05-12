public class EncodedTester {

    private static int testsPassed = 0;
    private static int testsFailed = 0;

    public static void main(String[] args) {

        testDefaultConstructor();
        testParameterizedConstructor();
        testSetInputText();

        testValidString();
        testInvalidUppercaseString();
        testInvalidSymbolString();
        testInvalidEmptyString();

        testCountCharactersWithoutSpaces();
        testCountCharactersWithSpaces();
        testCountCharactersOnlySpaces();

        testGenerateShift();

        testApplyCipherLettersOnly();
        testApplyCipherDigitsOnly();
        testApplyCipherLettersDigitsSpaces();
        testApplyCipherZeroShift();
        testApplyCipherWrapAround();

        System.out.println();
        System.out.println("===== TEST SUMMARY =====");
        System.out.println("Passed: " + testsPassed);
        System.out.println("Failed: " + testsFailed);

        if (testsFailed == 0) {
            System.out.println("All tests passed.");
        } else {
            System.out.println("Some tests failed.");
        }
    }

    // Simple manual assert methods

    public static void assertEquals(String expected, String actual, String testName) {
        if (expected.equals(actual)) {
            pass(testName);
        } else {
            fail(testName, "Expected: " + expected + ", Actual: " + actual);
        }
    }

    public static void assertEquals(int expected, int actual, String testName) {
        if (expected == actual) {
            pass(testName);
        } else {
            fail(testName, "Expected: " + expected + ", Actual: " + actual);
        }
    }

    public static void assertTrue(boolean condition, String testName) {
        if (condition) {
            pass(testName);
        } else {
            fail(testName, "Expected true but got false");
        }
    }

    public static void assertFalse(boolean condition, String testName) {
        if (!condition) {
            pass(testName);
        } else {
            fail(testName, "Expected false but got true");
        }
    }

    public static void pass(String testName) {
        testsPassed++;
        System.out.println("[PASS] " + testName);
    }

    public static void fail(String testName, String message) {
        testsFailed++;
        System.out.println("[FAIL] " + testName + " - " + message);
    }

    // ===== Constructor Tests =====

    public static void testDefaultConstructor() {
        Encoded encoded = new Encoded();

        assertEquals("", encoded.getInputText(), "Default constructor inputText");
        assertEquals(0, encoded.getCharCount(), "Default constructor charCount");
        assertEquals("", encoded.getResultText(), "Default constructor resultText");
    }

    public static void testParameterizedConstructor() {
        Encoded encoded = new Encoded("hello123");

        assertEquals("hello123", encoded.getInputText(), "Parameterized constructor inputText");
        assertEquals(0, encoded.getCharCount(), "Parameterized constructor charCount");
        assertEquals("", encoded.getResultText(), "Parameterized constructor resultText");
    }

    // ===== Getter and Setter Test =====

    public static void testSetInputText() {
        Encoded encoded = new Encoded();

        encoded.setInputText("abc 123");

        assertEquals("abc 123", encoded.getInputText(), "setInputText method");
    }

    // ===== String Validation Tests =====

    public static void testValidString() {
        Encoded encoded = new Encoded();

        assertTrue(encoded.checkStringValidity("abc 123 xyz"), "Valid lowercase letters, digits, and spaces");
    }

    public static void testInvalidUppercaseString() {
        Encoded encoded = new Encoded();

        assertFalse(encoded.checkStringValidity("Hello123"), "Invalid uppercase letters");
    }

    public static void testInvalidSymbolString() {
        Encoded encoded = new Encoded();

        assertFalse(encoded.checkStringValidity("hello@123"), "Invalid symbols");
    }

    public static void testInvalidEmptyString() {
        Encoded encoded = new Encoded();

        assertFalse(encoded.checkStringValidity(""), "Invalid empty string");
    }

    // ===== Character Count Tests =====

    public static void testCountCharactersWithoutSpaces() {
        Encoded encoded = new Encoded();

        int count = encoded.countCharacters("hello123");

        assertEquals(8, count, "Count characters without spaces");
        assertEquals(8, encoded.getCharCount(), "charCount updated after counting without spaces");
    }

    public static void testCountCharactersWithSpaces() {
        Encoded encoded = new Encoded();

        int count = encoded.countCharacters("ab c 12 3");

        assertEquals(6, count, "Count characters with spaces");
        assertEquals(6, encoded.getCharCount(), "charCount updated after counting with spaces");
    }

    public static void testCountCharactersOnlySpaces() {
        Encoded encoded = new Encoded();

        int count = encoded.countCharacters("   ");

        assertEquals(0, count, "Count characters only spaces");
        assertEquals(0, encoded.getCharCount(), "charCount updated after only spaces");
    }

    // ===== Shift Test =====

    public static void testGenerateShift() {
        Encoded encoded = new Encoded();

        /*
         * groupID = "G04/SE-G04"
         * Java hashCode result causes final shift to become 3.
         */
        assertEquals(3, encoded.generateShift(), "Generate shift from groupID");
    }

    // ===== Cipher Tests =====

    public static void testApplyCipherLettersOnly() {
        Encoded encoded = new Encoded();

        String result = encoded.applyCipher("abcxyz", 3);

        assertEquals("defabc", result, "Apply cipher to letters only");
        assertEquals("defabc", encoded.getResultText(), "resultText updated after letters cipher");
    }

    public static void testApplyCipherDigitsOnly() {
        Encoded encoded = new Encoded();

        String result = encoded.applyCipher("789", 3);

        assertEquals("012", result, "Apply cipher to digits only");
        assertEquals("012", encoded.getResultText(), "resultText updated after digits cipher");
    }

    public static void testApplyCipherLettersDigitsSpaces() {
        Encoded encoded = new Encoded();

        String result = encoded.applyCipher("abc 789 xyz", 3);

        assertEquals("def 012 abc", result, "Apply cipher to letters, digits, and spaces");
        assertEquals("def 012 abc", encoded.getResultText(), "resultText updated after mixed cipher");
    }

    public static void testApplyCipherZeroShift() {
        Encoded encoded = new Encoded();

        String result = encoded.applyCipher("abc 123", 0);

        assertEquals("abc 123", result, "Apply cipher with zero shift");
    }

    public static void testApplyCipherWrapAround() {
        Encoded encoded = new Encoded();

        String result = encoded.applyCipher("xyz 890", 4);

        assertEquals("bcd 234", result, "Apply cipher with wrap around");
    }
}