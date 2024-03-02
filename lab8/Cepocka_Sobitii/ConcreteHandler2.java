package lab8.Cepocka_Sobitii;

// Класс ConcreteHandler2
class ConcreteHandler2 implements Handler
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
        if (request >= 10 && request <= 20)
        {
            System.out.println("Request " + request + " handled by ConcreteHandler2");
        } // Иначе передаём следующему обработчику
        else if (nextHandler != null)
        {
            nextHandler.handleRequest(request);
        }
    }
}
