package com.pieisnotpi.lib.types;

public class CharOption extends GenericOption
{
    public char defaultValue, value;

    public CharOption(String name, char defaultValue)
    {
        super(name);
        this.defaultValue = defaultValue;
        this.value = defaultValue;
    }

    @Override
    public void setFromString(String unparsed)
    {
        if(unparsed.length() > 0) value = unparsed.charAt(0);
        else value = defaultValue;
    }

    @Override
    public void reset()
    {
        value = defaultValue;
    }

    @Override
    public String getWrittenValue()
    {
        return Character.toString(value);
    }

    public char getValue()
    {
        return value;
    }

    public char getDefaultValue()
    {
        return defaultValue;
    }
}
