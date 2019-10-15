package com.pieisnotpi.lib.types;

import com.pieisnotpi.lib.GenericOption;

public class LongOption extends GenericOption
{
    public long defaultValue, value;

    public LongOption(String name, long defaultValue)
    {
        this(name, defaultValue, null, false);
    }

    public LongOption(String name, long defaultValue, String comment)
    {
        this(name, defaultValue, comment, false);
    }
    
    public LongOption(String name, long defaultValue, String comment, boolean hidden)
    {
        super(name, comment, hidden);
        this.defaultValue = defaultValue;
        this.value = defaultValue;
    }

    @Override
    public void setFromString(String unparsed)
    {
        try { value = Long.parseLong(unparsed); }
        catch(NumberFormatException e) { value = defaultValue; }
    }
    
    @Override
    public void reset() { value = defaultValue; }

    @Override
    public String getWrittenValue() { return Long.toString(value); }

    public long getValue() { return value; }
    public long getDefaultValue() { return defaultValue; }
}
