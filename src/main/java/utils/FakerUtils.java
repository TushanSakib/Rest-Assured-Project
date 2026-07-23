package utils;
import net.datafaker.Faker;
public class FakerUtils {

    private static final Faker faker = new Faker();

    private FakerUtils(){

    }

    public static String getFullName(){
        return faker.name().fullName();
    }

    public static String getFirstName(){
        return faker.name().firstName();
    }

    public static String getLastName(){
        return faker.name().lastName();
    }

    public static String getJobTitle(){
        return faker.name().title();
    }

    public static String getEmail(){
        return faker.internet().emailAddress();
    }
    public static String getPassword(){
        return faker.internet().password(
                8,
                16,
                true,
                true,
                true
        );
    }

    public static String getPhoneNumber(){
        return faker.phoneNumber().cellPhone();
    }

    public static String getCity(){
        return faker.address().city();
    }

    public static String getCountry(){
        return faker.address().country();
    }

    public static int getRandomNumber(int min,int max){
        return faker.number().numberBetween(min,max);
    }
}
