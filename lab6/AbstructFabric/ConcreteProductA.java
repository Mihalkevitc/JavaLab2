package lab6.AbstructFabric;

// Класс ConcreteProductA, реализующий интерфейс AbstractProduct
class ConcreteProductA implements AbstractProduct {
    @Override
    public void doSomething()
    {
        System.out.println("ConcreteProductA is doing something.");
    }
}