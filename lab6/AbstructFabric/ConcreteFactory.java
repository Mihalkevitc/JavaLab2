package lab6.AbstructFabric;

// Класс ConcreteFactory, реализующий интерфейс AbstractFactory
class ConcreteFactory implements AbstractFactory
{
    @Override
    public AbstractProduct createProductA()
    {
        return new ConcreteProductA();
    }
    @Override
    public AbstractProduct createProductB()
    {
        return new ConcreteProductB();
    }
}