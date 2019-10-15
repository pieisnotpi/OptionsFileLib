package com.pieisnotpi.lib;

import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

class OptionsGroup
{
    public String name;
    private Map<String, GenericOption> options = new LinkedHashMap<>();

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
    
    public void reset()
    {
        options.forEach((s, opt) -> opt.reset());
    }
    
    void write(PrintWriter writer)
    {
        boolean hasUnhidden = false;
        for(GenericOption opt : options.values()) if(!opt.isHidden()) { hasUnhidden = true; break; }
        if(!hasUnhidden) return;
    
        writer.println("-" + name);
        options.forEach((on, o) -> o.write(writer));
    }
}
