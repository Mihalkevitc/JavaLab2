package lab5;

public class SingletonStatic
{
    // Приватный конструктор
    private SingletonStatic()
    {
    }

    // Вложенный статический класс, который будет загружен только при вызове getInstance()
    private static class SingletonHolder
    {
        private static final SingletonStatic INSTANCE = new SingletonStatic();
    }

    // Метод возвращающий единственный экземпляр класса
    public static SingletonStatic getInstance()
    {
        return SingletonHolder.INSTANCE;
    }
}

