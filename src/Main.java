public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();

        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();

        System.out.println("У " + mom + " есть сын, " + son);
        mom.happyBirthday();
        System.out.println();

        Person father = new PersonBuilder()
                .setName("Дмитрий")
                .setSurname("Минин")
                .setAge(45)
                .setAddress("Москва")
                .build();

        Person daughter = father.newChildBuilder()
                .setName("Светлана")
                .setAge(15)
                .setAddress("Самара")
                .build();

        System.out.println("У " + father + " есть дочь, " + daughter);
        father.happyBirthday();

        try {
            // Не хватает обязательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}