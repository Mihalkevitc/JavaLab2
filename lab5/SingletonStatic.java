package lab5;

public class SingletonStatic
{
    //Приватное поле класса хранит единственный экземпляр класса и инициализируется при объявлении
    private static final SingletonStatic instance;

    static
    {
        instance = new SingletonStatic();
    }
    //Конструктор приватный, чтобы предотвратить создание экземпляров извне
    private SingletonStatic()
    {
    }
    //Метод getInstance() возвращает этот единственный экземпляр
    public static SingletonStatic getInstance()
    {
        return instance;
    }
}

