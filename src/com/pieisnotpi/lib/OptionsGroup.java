package com.pieisnotpi.lib;

import com.pieisnotpi.lib.types.GenericOption;

import java.util.LinkedHashMap;
import java.util.Map;

class OptionsGroup
{
    public String name;
    public Map<String, GenericOption> options = new LinkedHashMap<>();

    public OptionsGroup(String name)
    {
        this.name = name;
    }

    public void registerOption(GenericOption option)
    {
        options.put(option.getName(), option);
    }

    public GenericOption getOption(String name)
    {
        return options.get(name);
    }
}
