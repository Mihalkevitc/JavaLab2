package lab7.Most;

// Абстрактный класс Abstraction
abstract class Abstraction
{
    protected Implementor implementor;

    public Abstraction(Implementor implementor)
    {
        this.implementor = implementor;
    }

    public abstract void operation();
}