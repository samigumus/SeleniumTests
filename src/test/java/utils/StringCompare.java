package utils;

public class StringCompare {

        public static String verifyEquals(String actual, String expected) {

            String result = "";
            if (actual.equals(expected))
                result = "TEST PASS";
            else
                result = "TEST FAIL";

            return result;
        }
}
