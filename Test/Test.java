import com.pieisnotpi.lib.OptionsFile;
import com.pieisnotpi.lib.types.*;

import java.io.File;

public class Test
{
    public static void main(String[] args)
    {
        OptionsFile file = new OptionsFile(new File("options.cfg"));

        file.registerOption(new IntOption("int_test", 2));
        file.registerOption(new StringOption("str_test", "yeppers"));
        file.registerOption(new FloatOption("float_test", 4.56912f));
        file.registerOption(new BooleanOption("bool_test", true));
        file.registerOption(new DoubleOption("double_test", 62.1021438214));
        file.registerOption("test_group", new LongOption("long_test", System.currentTimeMillis()));
        file.registerOption("test_group", new ShortOption("shrt_test", (short) 1285));
        file.registerOption("test_group_2", new CharOption("char_test", '#', "this one has a comment"));
        file.registerOption("test_group_3", new StringOption("hidden_test", "bloop bloop", "this is invisible", true));

        file.readFromFile();
        
        System.out.println(file.getStringOption("test_group_3", "hidden_test").getValue());
        
        file.writeToFile();
    }
}
