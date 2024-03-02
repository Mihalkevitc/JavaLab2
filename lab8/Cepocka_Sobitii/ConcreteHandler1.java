package lab8.Cepocka_Sobitii;

// Класс ConcreteHandler1
class ConcreteHandler1 implements Handler
{
    private Handler nextHandler;

    @Override
    public void setNextHandler(Handler nextHandler)
    {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(int request)
    {
        // Какое-то улсовие для выполнения данного запроса именно этим обработчиком
        if (request < 10)
        {
            System.out.println("Request " + request + " handled by ConcreteHandler1");
        } // Иначе передаём следующему обработчику
        else if (nextHandler != null)
        {
            nextHandler.handleRequest(request);
        }
    }
}