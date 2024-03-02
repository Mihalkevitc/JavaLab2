package lab7.Adapter;

// Adapter class
class Adapter implements Target
{
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee)
    {
        this.adaptee = adaptee;
    }

    @Override
    public void request()
    {
        adaptee.specificRequest();
    }
}
