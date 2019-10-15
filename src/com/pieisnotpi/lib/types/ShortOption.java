package com.pieisnotpi.lib.types;

import com.pieisnotpi.lib.GenericOption;

public class ShortOption extends GenericOption
{
    public short defaultValue, value;

    public ShortOption(String name, short defaultValue)
    {
        this(name, defaultValue, null, false);
    }

    public ShortOption(String name, short defaultValue, String comment)
    {
        this(name, defaultValue, comment, false);
    }
    
    public ShortOption(String name, short defaultValue, String comment, boolean hidden)
    {
        super(name, comment, hidden);
        this.defaultValue = defaultValue;
        this.value = defaultValue;
    }

    @Override
    public void setFromString(String unparsed)
    {
        try { value = Short.parseShort(unparsed); }
        catch(NumberFormatException e) { value = defaultValue; }
    }
    
    @Override
    public void reset() { value = defaultValue; }

    @Override
    public String getWrittenValue() { return Short.toString(value); }

    public short getValue() { return value; }
    public short getDefaultValue() { return defaultValue; }
}
