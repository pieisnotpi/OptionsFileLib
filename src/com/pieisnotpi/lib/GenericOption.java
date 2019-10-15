package com.pieisnotpi.lib;

import java.io.PrintWriter;

public abstract class GenericOption
{
    private String name;
    private String comment;
    private boolean hidden;

    public GenericOption(String name, String comment, boolean hidden)
    {
        this.name = name;
        this.comment = comment;
        this.hidden = hidden;
    }

    public abstract void setFromString(String unparsed);
    public abstract void reset();
    public abstract String getWrittenValue();

    public String getName() { return name; }
    public boolean isHidden() { return hidden; }
    public void setHidden(boolean hidden) { this.hidden = hidden; }
    
    void write(PrintWriter writer)
    {
        if(!hidden && comment != null) writer.println("\t#" + comment);
        if(!hidden) writer.println(String.format("\t%s:%s", name, getWrittenValue()));
    }
}
