package lab7.Most;

// Класс ConcreteImplementor
class ConcreteImplementor implements Implementor
{
    @Override
    public void operationImp()
    {
        System.out.println("ConcreteImplementor's operationImp method is called.");
    }
}