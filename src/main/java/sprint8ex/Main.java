package sprint8ex;

import com.github.javafaker.Faker;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        Faker faker = new Faker();  // Объект Faker с дефолтной локалью (US)
        Faker fakerRu = new Faker(Locale.forLanguageTag("ru")); // Объект Faker c русской локалью (кириллица поддерживается частично)

        System.out.println("== US Faker ==\n");
        fakerExamples(faker);
        System.out.println("\n== RU Faker ==\n");
        fakerExamples(fakerRu);

        System.out.println("\n== Курьер использует Lombok ==\n");
        lombokExamples(faker);
    }

    private static void lombokExamples(Faker faker) {
        Courier courier = Courier.builder()
                .login(faker.name().username())
                .password(faker.internet().password(3, 20))
                .build();

        System.out.println("-- Геттеры курьера --");
        System.out.println(courier.getLogin());
        System.out.println(courier.getPassword());
        System.out.println(courier.getFirstName());

        System.out.println("\n-- Объект курьера --");
        System.out.println(courier);
    }

    private static void fakerExamples(Faker faker) {
        System.out.println("-- Имена --");
        System.out.println(faker.name().firstName());
        System.out.println(faker.name().lastName());
        System.out.println(faker.name().fullName());
        System.out.println(faker.name().suffix());

        System.out.println("\n-- Числа --");
        System.out.println(faker.number().digit());
        System.out.println(faker.number().numberBetween(20, 100));

        System.out.println("\n-- Телефоны --");
        System.out.println(faker.phoneNumber().phoneNumber());
        System.out.println(faker.phoneNumber().cellPhone());
        System.out.println(faker.phoneNumber().extension());
        System.out.println(faker.address().fullAddress());

        System.out.println("\n-- E-mail --");
        System.out.println(faker.internet().emailAddress());
        System.out.println(faker.internet().safeEmailAddress());

        System.out.println("\n-- Шаблоны --");
        System.out.println(faker.letterify("???????@ya.ru"));
        System.out.println(faker.numerify("+7 (###) ###-##-##"));
        System.out.println(faker.bothify("email: ???????@ya.ru, phone: +7 (###) ###-##-##"));

        System.out.println("\n-- Приколы) --");
        System.out.println(faker.lebowski().quote());
        System.out.println(faker.chuckNorris().fact());
    }
}
