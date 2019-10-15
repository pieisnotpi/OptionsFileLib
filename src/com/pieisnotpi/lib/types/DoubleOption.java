package com.pieisnotpi.lib.types;

import com.pieisnotpi.lib.GenericOption;

public class DoubleOption extends GenericOption
{
    private double defaultValue, value;

    public DoubleOption(String name, double defaultValue)
    {
        this(name, defaultValue, null, false);
    }

    public DoubleOption(String name, double defaultValue, String comment)
    {
        this(name, defaultValue, comment, false);
    }

    public DoubleOption(String name, double defaultValue, String comment, boolean hidden)
    {
        super(name, comment, hidden);
        this.defaultValue = defaultValue;
        this.value = defaultValue;
    }

    @Override
    public void setFromString(String unparsed)
    {
        try { value = Double.parseDouble(unparsed); }
        catch (NumberFormatException e) { value = defaultValue; }
    }

    @Override
    public void reset() { value = defaultValue; }

    @Override
    public String getWrittenValue() { return Double.toString(value); }

    public double getValue() { return value; }
    public double getDefaultValue() { return defaultValue; }
}
