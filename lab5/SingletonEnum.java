package lab5;

//Класс SingletonEnum реализован как перечисление,
// что гарантирует единственное существование экземпляра класса
public enum SingletonEnum
{
    //INSTANCE является единственным экземпляром класса SingletonEnum,
    // который создается автоматически при загрузке класса
    INSTANCE;
    //Сам метод возвращает единственный созданный экземпляр класса
    public static SingletonEnum getInstance()
    {
        return INSTANCE;
    }
}
