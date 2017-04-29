package com.pieisnotpi.lib.types;

public class BooleanOption extends GenericOption
{
    private boolean defaultValue, value;

    public BooleanOption(String name, boolean defaultValue)
    {
        super(name);
        this.defaultValue = defaultValue;
        this.value = defaultValue;
    }

    @Override
    public void setFromString(String unparsed)
    {
        String lower = unparsed.toLowerCase();
        value = lower.equals("true") || !lower.equals("false") && defaultValue;
    }

    @Override
    public void reset()
    {
        value = defaultValue;
    }

    @Override
    public String getWrittenValue()
    {
        return Boolean.toString(value);
    }

    public boolean getValue()
    {
        return value;
    }

    public boolean getDefaultValue()
    {
        return defaultValue;
    }
}
