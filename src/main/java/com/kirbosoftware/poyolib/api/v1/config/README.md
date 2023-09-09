## Using the Config module from PoyoLib

It's quite easy to follow to be honest. 

first you initialise the `ConfigHolder` class in your modInitialiser like so:

```java
import com.kirbosoftware.poyolib.api.v1.config.ConfigHolder;

public class ExampleMod implements ModInitializer {
    public ConfigHolder HOLDER = new ConfigHolder("fileOfName");

    @Override
    public void onInitialize() {

    }
}
```
it automatically sets the filename and will create a file in the `config` folder upon launch. 

Then create a class where you will store your values. As example:

```java
import com.kirbosoftware.poyolib.api.v1.config.ConfigHelper;
import com.kirbosoftware.poyolib.api.v1.config.ConfigValue;

public class ExampleConfig {
    private static final ConfigHelper helper = new ConfigHelper(ExampleMod.HOLDER);
    public static ConfigValue<Integer> TEST_INT = helper.getOrCreate("test_int", 11);
    public static ConfigValue<Boolean> TEST_BOOL = helper.getOrCreate("test_bool", false);
}
```
here we set 2 values, a int and a boolean. 

Then all you need to do is go back to the `ExampleMod` file and do this:
```java
import com.kirbosoftware.poyolib.api.v1.config.ConfigHolder;
import com.kirbosoftware.poyolib.api.v1.config.ConfigManager;

public class ExampleMod implements ModInitializer {
    public ConfigHolder HOLDER = new ConfigHolder("fileOfName");

    @Override

    public void onInitialize() {
        HOLDER.add(new ExampleConfig());
        ConfigManager.load(HOLDER);
        ConfigManager.store(HOLDER);
    }
}
```

and now enjoy the wonders that will generate your config.