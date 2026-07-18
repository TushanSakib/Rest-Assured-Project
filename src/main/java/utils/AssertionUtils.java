package utils;

public class AssertionUtils {
    private AssertionUtils(){

    }

    public static void verifyStatusCode(
            int actual,
            int expected
    ){
        if(actual != expected){
            throw new AssertionError(
                    String.format(
                            "Expected status code: %d but got: %d",
                            expected,
                            actual
                    )
            );
        }
    }
}
