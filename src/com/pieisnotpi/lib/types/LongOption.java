package com.pieisnotpi.lib.types;

public class LongOption extends GenericOption
{
    public long defaultValue, value;

    public LongOption(String name, long defaultValue)
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
        try { value = Long.parseLong(unparsed); }
        catch(NumberFormatException e) { value = defaultValue; }
    }

    @Override
    public String getWrittenValue()
    {
        return Long.toString(value);
    }

    public long getValue()
    {
        return value;
    }

    public long getDefaultValue()
    {
        return defaultValue;
    }
}
