package tests;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class TestData {
    static Faker faker = new Faker(new Locale("en-GB"));
    static Random random = new Random();

    static String[] gender = {"Male", "Female", "Other"};
    static String[] hobbies = {"Sports", "Reading", "Music"};
    static String[] subject = {"English", "Maths", "Biology","Computer Science","Economics"};
    static String[] state = {"NCR", "Uttar Pradesh", "Haryana","Rajasthan"};
    static String[] months = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};


    public static String firstName = faker.name().firstName();
    public static String lastName = faker.name().lastName();
    public static String userEmail = faker.internet().emailAddress();
    public static String userGender = gender[random.nextInt(gender.length)];
    public static String userPhone = faker.numerify("77########");
    public static String userHobbies = hobbies[random.nextInt(hobbies.length)];
    public static String streetAddress = faker.address().streetAddress();
    public static String userSubject = subject[random.nextInt(subject.length)];
    public static String userFile = "dude.png";
    public static String userState = state[random.nextInt(state.length)];
    public static String userCity = chooseRandomCity(userState);
    public static String userMonthBday = months[random.nextInt(months.length)];
    public static int userYearBday = faker.number().numberBetween(1940,2010);
    public static int userDayBday = chooseRandomDay(userMonthBday);

    public static int chooseRandomDay(String month){
        if (!month.equals("February")){
            return faker.number().numberBetween(1,31);
        }else
            return faker.number().numberBetween(1,29);
    };

    public static String chooseRandomCity(String state){
        switch (state){
            case ("NCR") -> {
                return faker.options().option("Delhi","Gurgaon","Noida");
            }
            case ("Uttar Pradesh") -> {return faker.options().option("Agra","Lucknow","Merrut");
            }
            case ("Haryana") -> {
                return faker.options().option("Karnal","Panipat");
            }
            case ("Rajasthan") -> {
                return faker.options().option("Jaipur","Jaiselmer");
            }
            default ->
                    throw new IllegalStateException("В списке нет указанного города!");
        }
    }
}
