import java.util.*;

/*
    1.Создайте новый проект, залинкуйте его с удаленным репозиторием на GitHub,
    добавьте файл .gitignore и сделайте коммит
    2. Создайте перечисление Gender со значениями MALE и FEMALE
    3. Создайте класс Person с тремя полями: firstName (String, private),
    lastName (String, private) и gender(тип Gender, private)
    4. Переопределите методы equals, hashCode и toString для класса Person
    5. Сделайте класс Person неизменяемым (см. подсказку внизу документа)
    6. Демонстрация работы с коллекциями типа List. Создайте 5 разных объектов типа Person.
    Создайте коллекцию типа List (ArrayList или LinkedList неважно), добавьте в нее все созданные объекты.
    Выведите все элементы коллекции в консоль с указанием общего количества элементов в коллекции
    7. Демонстрация работы с коллекциями типа Set. Создайте 5 объектов (2 пары из них должны
    быть идентичными) типа Person. Создайте коллекцию типа Set, добавьте в нее все созданные объекты.
    Выведите все элементы коллекции в консоль с указанием общего количества элементов в коллекции
    (всего элементов в коллекции должно оказаться 3)
    8. Демонстрация работы с коллекциями типа Map. Создайте 5 разных объектов типа Person.
    Создайте коллекцию типа Map (в качестве ключа возьмите целые числа,
    значение должно быть типа Person), добавьте в нее все созданные объекты
    (числа-ключи произвольные). Выведите все элементы ассоциативного массива в консоль с указанием
    общего количества элементов (выводить и ключ, и значение)
    9. Залить код в репозиторий и отправить ссылку на репозиторий преподавателю

    Для того чтобы сделать класс неизменяемым, необходимо выполнить следующие условия:
    1. Не предоставляйте сеттеры или методы, которые изменяют поля или объекты, ссылающиеся на поля.
    Сеттеры подразумевают изменение состояния объекта а это то, чего мы хотим тут избежать.
    2. Сделайте все поля final и private. Поля, обозначенные private, будут недоступными снаружи класса,
    а обозначение их final гарантирует, что вы не измените их даже случайно.
    3. Не разрешайте субклассам переопределять методы. Самый простой способ это сделать –
    объявить класс как final. Финализированные классы в Java не могут быть переопределены.
    4. Всегда помните, что ваши экземпляры переменных могут быть либо изменяемыми, либо неизменяемыми.
    Определите их и возвращайте новые объекты со скопированным содержимым для всех изменяемых объектов
    (ссылочные типы). Неизменяемые переменные (примитивные типы) могут быть безопасно
    возвращены без дополнительных усилий.
    */
public class Main {
    public static void main(String[] args) {
        // task (8.1) "Enum"
        enum Gender { MALE, FEMALE }

        // task (8.2) "Класс Person"
        final class Person {
            private final String firstName;
            private final String lastName;
            private final Gender gender;

            Person (String firstName, String lastName, Gender gender){
                this.firstName = firstName;
                this.lastName = lastName;
                this.gender = gender;
            } // 8.3 constructor Person

            @Override
            public boolean equals(Object obj) {
                if (this == obj)
                    return true;
                if (obj == null)
                    return false;
                if (getClass() != obj.getClass())
                    return false;
                Person other = (Person) obj;
                if (firstName != other.firstName)
                    return false;
                if (lastName != other.lastName)
                    return false;
                if (gender != other.gender)
                    return false;
                return true;
            } // 8.4 equals

            @Override
            public int hashCode() {
                int result = firstName == null ? 0 : firstName.hashCode();
                result = result + (lastName == null ? 0 : lastName.hashCode());
                result = result + (lastName == null ? 0 : gender.hashCode());
                return result;
            } // 8.4 hashCode

            @Override
            public String toString() {
                return "Person {firstName = " + firstName + ", " + "lastName = " + lastName + ", " +
                        "gender = " + gender + "}";
            }// 8.4 toString

        } //class Person

        // task (8.6) "List"
        Person pers1 = new Person("Ivan", "Ivanov", Gender.MALE);
        Person pers2 = new Person("Olga", "Olgina", Gender.FEMALE);
        Person pers3 = new Person("Irina", "Irskaya", Gender.FEMALE);
        Person pers4 = new Person("Petr", "Petrov", Gender.MALE);
        Person pers5 = new Person("Evgenij", "Zhenkov", Gender.MALE);

        ArrayList<Person> arrList = new ArrayList<>(5);
        arrList.add(pers1);
        arrList.add(pers2);
        arrList.add(pers3);
        arrList.add(pers4);
        arrList.add(pers5);

        Iterator<Person> it = arrList.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("В коллекции ArrayList - " + arrList.size() + " элементов");



        // task (8.7) "Set"
        Person pers11 = new Person("Ivan", "Ivanov", Gender.MALE);
        Person pers22 = new Person("Olga", "Olgina", Gender.FEMALE);
        Set<Person> setPer = new HashSet<>(arrList);
        setPer.remove(pers4);
        setPer.remove(pers5);
        setPer.add(pers11);
        setPer.add(pers22);

        Iterator<Person> it2 = setPer.iterator();
        while (it2.hasNext()){
            System.out.println(it2.next());
        }
        System.out.println("В коллекции Set" + " - " + setPer.size() + " элементов");

        // task (8.8) "Map"
        HashMap<Integer, Person> mapPer = new HashMap<>(5);
        mapPer.put(1,pers1);
        mapPer.put(2,pers2);
        mapPer.put(3,pers3);
        mapPer.put(4,pers4);
        mapPer.put(5,pers5);

        for (Integer it3: mapPer.keySet()) {
            System.out.println(it3 + ": " + mapPer.get(it3));
        }
        System.out.println("В коллекции Map" + " - " + mapPer.size() + " элементов");




    }
}