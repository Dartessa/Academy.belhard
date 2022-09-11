public class Main {
    public static void main(String[] args) {
        /*
    1.Создайте новый проект, залинкуйте его с удаленным репозиторием на GitHub, добавьте файл .gitignore
    и сделайте коммит
    2.Создайте класс абстрактный класс Vehicle (средство передвижения)
    3. У класса Vehicle создайте поле wheelCount типа int и модификатором доступа protected
    4. Создайте конструктор с аргументом wheelCount
    5. Создайте абстрактный метод printInfo() (protected void), который будет реализован
    в классах-наследниках и будет выводить информацию о конкретном средстве передвижения
    6. Создайте класс Car (наследник класса Vehicle)
    7. Добавьте в класс Car поле doorsCount (private int) и создайте конструктор с 2-мя
    аргументами (wheelCount и doorsCount)
    8. Реализуйте в классе Car метод printInfo() - должен выводить на экран информацию о машине
    (Пример вывода: “Транспортное средство: Машина - Количество дверей: 5 - Количество колес: 4”)
    9. Создайте класс Motorcycle (наследник класса Vehicle)
    10. Добавьте в класс Motorcycle поле maxSpeed (private int) и создайте конструктор
    с 2-мя аргументами (wheelCount и maxSpeed)
    11. Реализуйте в классе Motorcycle метод printInfo() - должен выводить на экран
    информацию о мотоцикле (Пример вывода: “Транспортное средство:
    Мотоцикл- Количество колес: 2 - Максимальная скорость: 170 км/ч”)
    12. Создайте интерфейс Costable и в него добавьте метод getCost() с возвращаемым типом int
    13. Реализуйте интерфейс Costable для класса Car (реализация на ваше усмотрение).
    Добавить информацию о цене в метод printInfo()
    14. Для реализации работы программы создайте по 2 экземпляра классов Car и Motorcycle.
    Продемонстрировать работу каждого из методов классов и вывести результат на консоль
    15. Залить код в репозиторий и отправить ссылку на репозиторий преподавателю
    */


            // task (7.1 - 7.5) "абстрактный класс Vehicle"
            abstract class Vehicle {
                protected final int wheelCount; //7.3

                Vehicle ( int wheelCount) {
                    this.wheelCount = wheelCount;
                } // 7.4 "Конструктор"
                abstract protected void printInfo(); //7.5 "Абстрактный метод"
            } // abstract Class Vehicle

            // task (7.12) "Интерфейс Costable"
            interface Costable {
                int getCost();
            } //Costable


            // task (7.6 - 7.8) "Класс Car (наследник класса Vehicle)"
            class Car extends Vehicle implements Costable {
                private final int doorsCount;
                int cost;
                //7.7

                public Car (int wheelCount, int doorsCount) {
                    super(wheelCount);
                    this.doorsCount = doorsCount;
                } // 7.7 Конструктор Car

                @Override
                protected void printInfo() {
                    if (cost != 0)
                        System.out.println("Транспортное средство: Машина - Количество дверей: " + doorsCount + " - " +
                                "Количество колес: " + wheelCount + " - Цена: " + cost);
                    else System.out.println("Транспортное средство: Машина - Количество дверей: " + doorsCount + " - " +
                            "Количество колес: " + wheelCount);
                }  //7.8 Переопределение Метода

                public void setCost(int cost) {
                    this.cost = cost;
                }
                @Override
                public int getCost() {
                    return cost;
                } //7.13 Переопределение Метода интерфейса
            }//Car

            // task (7.9 - 7.11) "Класс Motorcycle (наследник класса Vehicle)"
            class Motorcycle extends Vehicle {
                private final int maxSpeed; // 7.10

                public Motorcycle (int wheelCount, int maxSpeed){
                    super(wheelCount);
                    this.maxSpeed = maxSpeed;
                } //7.10 Конструктор Motorcycle

                @Override
                protected void printInfo() {
                    System.out.println("Транспортное средство: Мотоцикл - Количество колес: "+ wheelCount + " - " +
                            "Максимальная скорость: " + maxSpeed + " км/ч");
                } //7.11 Переопределение Метода
            } //Motorcycle

            //Демонстрация

            Car coupeCar = new Car(4,2);
            Car sedanCar = new Car(4,4);
            Motorcycle motoWithSidecar = new Motorcycle(3,170);
            Motorcycle  motoOrdinary = new Motorcycle(2,250);

            coupeCar.printInfo();
            coupeCar.setCost(4242);
            System.out.println("Цена: " + coupeCar.getCost());
            coupeCar.printInfo();

            sedanCar.setCost(42);
            System.out.println("Цена: " + sedanCar.getCost());
            sedanCar.printInfo();

            motoOrdinary.printInfo();
            motoWithSidecar.printInfo();
    }
}