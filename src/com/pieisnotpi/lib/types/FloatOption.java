package com.pieisnotpi.lib.types;

public class FloatOption extends GenericOption
{
    private float defaultValue, value;

    public FloatOption(String name, float defaultValue)
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
        try { value = Float.parseFloat(unparsed); }
        catch(NumberFormatException e) { value = defaultValue; }
    }

    @Override
    public String getWrittenValue()
    {
        return Float.toString(value);
    }

    public float getValue()
    {
        return value;
    }

    public float getDefaultValue()
    {
        return defaultValue;
    }
}
