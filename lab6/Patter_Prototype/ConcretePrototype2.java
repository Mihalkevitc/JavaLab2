package lab6.Patter_Prototype;

// Класс ConcretePrototype2, реализующий интерфейс Prototype
class ConcretePrototype2 implements Prototype
{
    @Override
    public Prototype clone()
    {
        return new ConcretePrototype2();
    }

    @Override
    public String toString()
    {
        return "ConcretePrototype2";
    }
}