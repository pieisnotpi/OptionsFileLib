package com.pieisnotpi.lib.types;

public class DoubleOption extends GenericOption
{
    private double defaultValue, value;

    public DoubleOption(String name, double defaultValue)
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
        try { value = Double.parseDouble(unparsed); }
        catch (NumberFormatException e) { value = defaultValue; }
    }

    @Override
    public String getWrittenValue()
    {
        return Double.toString(value);
    }

    public double getValue()
    {
        return value;
    }

    public double getDefaultValue()
    {
        return defaultValue;
    }
}
