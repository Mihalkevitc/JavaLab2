package lab6.Patter_Prototype;

// Класс ConcretePrototype1, реализующий интерфейс Prototype
class ConcretePrototype1 implements Prototype
{
    @Override
    public Prototype clone()
    {
        return new ConcretePrototype1();
    }

    @Override
    public String toString()
    {
        return "ConcretePrototype1";
    }
}