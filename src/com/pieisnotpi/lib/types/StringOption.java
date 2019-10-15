package com.pieisnotpi.lib.types;

import com.pieisnotpi.lib.GenericOption;

public class StringOption extends GenericOption
{
    private String defaultValue, value;
    
    public StringOption(String name, String defaultValue)
    {
        this(name, defaultValue, null, false);
    }

    public StringOption(String name, String defaultValue, String comment)
    {
        this(name, defaultValue, comment, false);
    }
    
    public StringOption(String name, String defaultValue, String comment, boolean hidden)
    {
        super(name, comment, hidden);
        this.defaultValue = defaultValue;
        this.value = defaultValue;
    }

    @Override
    public void setFromString(String unparsed)
    {
        if(unparsed.equals("")) value = defaultValue;
        else value = unparsed;
    }

    @Override
    public void reset() { value = defaultValue; }

    @Override
    public String getWrittenValue() { return value; }

    public String getValue() { return value; }
    public String getDefaultValue() { return defaultValue; }
}
