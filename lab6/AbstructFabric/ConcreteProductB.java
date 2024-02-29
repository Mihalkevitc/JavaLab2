package lab6.AbstructFabric;

// Класс ConcreteProductB, реализующий интерфейс AbstractProduct
class ConcreteProductB implements AbstractProduct
{
    @Override
    public void doSomething() {
        System.out.println("ConcreteProductB is doing something.");
    }
}