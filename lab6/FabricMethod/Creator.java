package lab6.FabricMethod;

// Абстрактный класс Creator с методами factoryMethod() и anOperation()
abstract class Creator
{
    public void anOperation()
    {
        Product product = factoryMethod();
        product.doSomething();
    }

    protected abstract Product factoryMethod();
}

