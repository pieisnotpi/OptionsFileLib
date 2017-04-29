package com.pieisnotpi.lib;

import com.pieisnotpi.lib.types.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Base class providing everything necessary to read and write option files.
 * Before reading or writing, the option database must be populated via registerOption()
 * Provides simple grouping for more organized files
 */

public class OptionsFile
{
    private File file;
    private Map<String, OptionsGroup> groups = new LinkedHashMap<>();

    /**
     * Initializes an OptionFile with associated File and main group
     * @param file The file used for reading from and writing to disk
     */

    public OptionsFile(File file)
    {
        this.file = file;
        groups.put("main", new OptionsGroup("main"));
    }

    /**
     * Registers an option to the main group
     * @param option The option to register
     */

    public void registerOption(GenericOption option)
    {
        registerOption("main", option);
    }

    /**
     * Registers an option to a specific group
     * @param groupName The name of the option's group
     * @param option The option to register
     */

    public void registerOption(String groupName, GenericOption option)
    {
        OptionsGroup group = groups.computeIfAbsent(groupName, OptionsGroup::new);
        group.registerOption(option);
    }

    /**
     * Attempts to retrieve a generic option in the main group
     * Not intended to be used externally, the type specific getter methods are preferred
     * @param name The name of the option, as declared with registerOption()
     * @return If found, the registered GenericOption. Otherwise, returns null
     */

    public GenericOption getOption(String name)
    {
        return getOption("main", name);
    }

    /**
     * Attempts to retrieve a generic option in the specified group
     * Not intended to be used externally, the type specific getter methods are preferred
     * @param groupName The name of the option's group, as declared with registerOption()
     * @param optionName The name of the option, as declared with registerOption()
     * @return If found, the registered GenericOption. Otherwise, returns null
     */

    public GenericOption getOption(String groupName, String optionName)
    {
        OptionsGroup group = groups.get(groupName);
        if(group != null) return group.getOption(optionName);
        else return null;
    }

    /**
     * Attempts to retrieve an option of type IntOption in the main group
     * @param name The name of the option, as declared with registerOption()
     * @return If found, the registered IntOption. Otherwise, returns null
     */

    public IntOption getIntOption(String name)
    {
        return getIntOption("main", name);
    }

    /**
     * Attempts to retrieve an option of type IntOption in the specified group
     * @param groupName The name of the option's group, as declared with registerOption()
     * @param optionName The name of the option, as declared with registerOption()
     * @return If found, the registered IntOption. Otherwise, returns null
     */

    public IntOption getIntOption(String groupName, String optionName)
    {
        GenericOption o = getOption(groupName, optionName);
        if(o instanceof IntOption) return (IntOption) o;
        invalidOptionPrint(IntOption.class, o.getClass());
        return null;
    }

    /**
     * Attempts to retrieve an option of type FloatOption in the main group
     * @param name The name of the option, as declared with registerOption()
     * @return If found, the registered FloatOption. Otherwise, returns null
     */

    public FloatOption getFloatOption(String name)
    {
        return getFloatOption("main", name);
    }

    /**
     * Attempts to retrieve an option of type IntOption in the specified group
     * @param groupName The name of the option's group, as declared with registerOption()
     * @param optionName The name of the option, as declared with registerOption()
     * @return If found, the registered IntOption. Otherwise, returns null
     */

    public FloatOption getFloatOption(String groupName, String optionName)
    {
        GenericOption o = getOption(groupName, optionName);
        if(o instanceof FloatOption) return (FloatOption) o;
        invalidOptionPrint(FloatOption.class, o.getClass());
        return null;
    }

    /**
     * Attempts to retrieve an option of type StringOption in the main group
     * @param name The name of the option, as declared with registerOption()
     * @return If found, the registered StringOption. Otherwise, returns null
     */

    public StringOption getStringOption(String name)
    {
        return getStringOption("main", name);
    }

    /**
     * Attempts to retrieve an option of type StringOption in the specified group
     * @param groupName The name of the option's group, as declared with registerOption()
     * @param optionName The name of the option, as declared with registerOption()
     * @return If found, the registered StringOption. Otherwise, returns null
     */

    public StringOption getStringOption(String groupName, String optionName)
    {
        GenericOption o = getOption(groupName, optionName);
        if(o instanceof StringOption) return (StringOption) o;
        invalidOptionPrint(StringOption.class, o.getClass());
        return null;
    }

    /**
     * Attempts to retrieve an option of type LongOption in the main group
     * @param name The name of the option, as declared with registerOption()
     * @return If found, the registered LongOption. Otherwise, returns null
     */

    public LongOption getLongOption(String name)
    {
        return getLongOption("main", name);
    }

    /**
     * Attempts to retrieve an option of type LongOption in the specified group
     * @param groupName The name of the option's group, as declared with registerOption()
     * @param optionName The name of the option, as declared with registerOption()
     * @return If found, the registered LongOption. Otherwise, returns null
     */

    public LongOption getLongOption(String groupName, String optionName)
    {
        GenericOption o = getOption(groupName, optionName);
        if(o instanceof LongOption) return (LongOption) o;
        invalidOptionPrint(LongOption.class, o.getClass());
        return null;
    }

    /**
     * Attempts to retrieve an option of type ShortOption in the main group
     * @param name The name of the option, as declared with registerOption()
     * @return If found, the registered ShortOption. Otherwise, returns null
     */

    public ShortOption getShortOption(String name)
    {
        return getShortOption("main", name);
    }

    /**
     * Attempts to retrieve an option of type ShortOption in the specified group
     * @param groupName The name of the option's group, as declared with registerOption()
     * @param optionName The name of the option, as declared with registerOption()
     * @return If found, the registered ShortOption. Otherwise, returns null
     */

    public ShortOption getShortOption(String groupName, String optionName)
    {
        GenericOption o = getOption(groupName, optionName);
        if(o instanceof ShortOption) return (ShortOption) o;
        invalidOptionPrint(ShortOption.class, o.getClass());
        return null;
    }

    /**
     * Attempts to retrieve an option of type BooleanOption in the main group
     * @param name The name of the option, as declared with registerOption()
     * @return If found, the registered BooleanOption. Otherwise, returns null
     */

    public BooleanOption getBooleanOption(String name)
    {
        return getBooleanOption("main", name);
    }

    /**
     * Attempts to retrieve an option of type BooleanOption in the specified group
     * @param groupName The name of the option's group, as declared with registerOption()
     * @param optionName The name of the option, as declared with registerOption()
     * @return If found, the registered BooleanOption. Otherwise, returns null
     */

    public BooleanOption getBooleanOption(String groupName, String optionName)
    {
        GenericOption o = getOption(groupName, optionName);
        if(o instanceof BooleanOption) return (BooleanOption) o;
        invalidOptionPrint(BooleanOption.class, o.getClass());
        return null;
    }

    /**
     * Attempts to retrieve an option of type CharOption in the main group
     * @param name The name of the option, as declared with registerOption()
     * @return If found, the registered CharOption. Otherwise, returns null
     */

    public CharOption getCharOption(String name)
    {
        return getCharOption("main", name);
    }

    /**
     * Attempts to retrieve an option of type CharOption in the specified group
     * @param groupName The name of the option's group, as declared with registerOption()
     * @param optionName The name of the option, as declared with registerOption()
     * @return If found, the registered CharOption. Otherwise, returns null
     */

    public CharOption getCharOption(String groupName, String optionName)
    {
        GenericOption o = getOption(groupName, optionName);
        if(o instanceof CharOption) return (CharOption) o;
        invalidOptionPrint(CharOption.class, o.getClass());
        return null;
    }

    /**
     * Resets all options to their default values
     * Useful for a settings reset/wipe
     */

    public void reset()
    {
        groups.forEach((gn, g) -> g.options.forEach((on, o) -> o.reset()));
    }

    /**
     * Reads option values from declared file
     * Ignores any line beginning with '#'
     * @return File read status (true if file was successfully read)
     */

    public boolean readFromFile()
    {
        if(!file.exists()) return false;

        try(Scanner scanner = new Scanner(file))
        {
            String group = "main";

            while(scanner.hasNextLine())
            {
                String line = scanner.nextLine();

                line = line.replaceAll("\t", "");

                if(line.charAt(0) == '#') continue;
                if(line.charAt(0) == '-') { group = line.substring(1); continue; }

                int colonIndex = line.indexOf(':');
                if(colonIndex == -1) continue;

                String name = line.substring(0, colonIndex), value = line.substring(colonIndex + 1);
                GenericOption option = getOption(group, name);

                if(option == null) continue;

                option.setFromString(value);
            }

            return true;
        }
        catch(IOException e) { return false; }
    }

    /**
     * Writes the currently declared options to the declared file
     * @return File write status (true if the file was successfully written)
     */

    public boolean writeToFile()
    {
        try(PrintWriter writer = new PrintWriter(file))
        {
            groups.forEach((gn, g) ->
            {
                if(g.options.size() == 0) return;
                writer.println("-" + gn);
                g.options.forEach((on, o) -> writer.println(String.format("\t%s:%s", on, o.getWrittenValue())));
            });
            return true;
        }
        catch(IOException e) { return false; }
    }

    private void invalidOptionPrint(Class attempted, Class actual)
    {
        System.err.println(String.format("Invalid option retrieval attempted%n\tAttempted class: %s%n\tActual class: %s", attempted, actual));
    }
}
