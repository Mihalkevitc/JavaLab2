package lab5;

public class Singleton
{
    //статическое поле instance, которое хранит единственный экземпляр класса
    private static Singleton instance;
    //Конструктор приватный, чтобы предотвратить создание экземпляров извне
    private Singleton()
    {
    }
    //getInstance() возвращает единственный экземпляр класса,
    // создавая его при первом вызове и возвращая уже созданный объект при последующих вызовах
    public static synchronized Singleton getInstance()
    {
        if (instance == null)
        {
            instance = new Singleton();
        }
        return instance;
    }
}
