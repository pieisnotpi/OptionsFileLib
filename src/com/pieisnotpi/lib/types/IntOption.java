package com.pieisnotpi.lib.types;

import com.pieisnotpi.lib.GenericOption;

public class IntOption extends GenericOption
{
    private int defaultValue, value;

    public IntOption(String name, int defaultValue)
    {
        this(name, defaultValue, null, false);
    }

    public IntOption(String name, int defaultValue, String comment)
    {
        this(name, defaultValue, comment, false);
    }

    public IntOption(String name, int defaultValue, String comment, boolean hidden)
    {
        super(name, comment, hidden);
        this.defaultValue = defaultValue;
        this.value = defaultValue;
    }

    @Override
    public void setFromString(String unparsed)
    {
        try { value = Integer.parseInt(unparsed); }
        catch(NumberFormatException e) { value = defaultValue; }
    }

    @Override
    public void reset() { value = defaultValue; }

    @Override
    public String getWrittenValue() { return Integer.toString(value); }

    public int getValue() { return value; }
    public int getDefaultValue() { return defaultValue; }
}
