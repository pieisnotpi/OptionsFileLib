package com.pieisnotpi.lib.types;

public class IntOption extends GenericOption
{
    private int defaultValue, value;

    public IntOption(String name, int defaultValue)
    {
        super(name);
        this.defaultValue = defaultValue;
        this.value = defaultValue;
    }

    @Override
    public void reset()
    {
        value = defaultValue;
    }

    @Override
    public void setFromString(String unparsed)
    {
        try { value = Integer.parseInt(unparsed); }
        catch(NumberFormatException e) { value = defaultValue; }
    }

    @Override
    public String getWrittenValue()
    {
        return Integer.toString(value);
    }

    public int getValue()
    {
        return value;
    }

    public int getDefaultValue()
    {
        return defaultValue;
    }
}
