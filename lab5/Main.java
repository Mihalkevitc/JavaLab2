package lab5;

public class Main {
    public static void main(String[] args)
    {
        Singleton singleton11 = Singleton.getInstance();
        Singleton singleton12 = Singleton.getInstance();
        System.out.println((singleton11 == singleton12) + " => Успешно создан один объект Singleton");

        SingletonEnum singleton21 = SingletonEnum.getInstance();
        SingletonEnum singleton22 = SingletonEnum.getInstance();
        System.out.println((singleton21 == singleton22) + " => Успешно создан один объект SingletonEnum");

        SingletonStatic singleton31 = SingletonStatic.getInstance();
        SingletonStatic singleton32 = SingletonStatic.getInstance();
        System.out.println((singleton31 == singleton32) + " => Успешно создан один объект SingletonStatic");
    }
}
