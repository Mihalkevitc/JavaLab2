package lab6.FabricMethod;

// Класс ConcreteCreator, который расширяет Creator и реализует метод factoryMethod()
class ConcreteCreator extends Creator
{
    @Override
    protected Product factoryMethod()
    {
        return new ConcreteProduct();
    }
}