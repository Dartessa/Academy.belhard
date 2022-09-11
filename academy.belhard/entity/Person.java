package entity;

/* Доделать в ДЗ №5 (в том же репозитории)
    1. Создайте новый проект, загрузите в него файл .gitignore (не пользуйтесь автоматической
    генерацией файла .gitignore, который предлагает github - он недостаточный) и сделайте коммит
    2. Создайте корневой пэкедж (если он был сгенерирован автоматически, то переименуйте его
    в academy.belhard), перенесите в него класс Main (класс, в котором находится метод main)
    3. Внутри этого пэкеджа создайте пэкедж под названием entity
    (щелчок ПКМ по корневому пэкеджу -> New -> Packege)
    4. Внутри пэкеджа entity создайте класс Person
    5. Создайте 2 поля класса Person с названиями firstName и lastName типа String
    и модификаторами доступа protected
    6. Создайте в классе Person конструктор с 2-мя аргументами (для обоих полей класса)
    и модификатором доступа public*/

public class Person {
    protected final String firstName;
    protected final String lastName;

    public Person(String firstName,String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
