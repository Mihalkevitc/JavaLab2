package lab6.Pattern_Builder;

class Director
{
    private Builder builder;

    public Director(Builder builder)
    {
        this.builder = builder;
    }

    public void construct()
    {
        builder.buildPart();
        builder.buildPart();
    }
}
