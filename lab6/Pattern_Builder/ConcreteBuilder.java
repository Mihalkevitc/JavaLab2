package lab6.Pattern_Builder;

// Класс ConcreteBuilder, реализующий интерфейс Builder
class ConcreteBuilder implements Builder
{
    private String result = "";

    @Override
    public void buildPart() {
        result += "Built one part. ";
    }

    public String getResult()
    {
        return result;
    }
}