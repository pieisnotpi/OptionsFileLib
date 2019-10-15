package com.pieisnotpi.lib.types;

import com.pieisnotpi.lib.GenericOption;

public class FloatOption extends GenericOption
{
    private float defaultValue, value;

    public FloatOption(String name, float defaultValue)
    {
        this(name, defaultValue, null, false);
    }

    public FloatOption(String name, float defaultValue, String comment)
    {
        this(name, defaultValue, comment, false);
    }
    
    public FloatOption(String name, float defaultValue, String comment, boolean hidden)
    {
        super(name, comment, hidden);
        this.defaultValue = defaultValue;
        this.value = defaultValue;
    }

    @Override
    public void setFromString(String unparsed)
    {
        try { value = Float.parseFloat(unparsed); }
        catch(NumberFormatException e) { value = defaultValue; }
    }
    
    @Override
    public void reset() { value = defaultValue; }

    @Override
    public String getWrittenValue() { return Float.toString(value); }

    public float getValue() { return value; }
    public float getDefaultValue() { return defaultValue; }
}
