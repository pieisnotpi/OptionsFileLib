package com.pieisnotpi.lib.types;

public abstract class GenericOption
{
    private String name;

    public GenericOption(String name)
    {
        this.name = name;
    }

    public abstract void setFromString(String unparsed);
    public abstract void reset();
    public abstract String getWrittenValue();

    public String getName()
    {
        return name;
    }
}
