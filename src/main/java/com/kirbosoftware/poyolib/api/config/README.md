## Using the Config module from PoyoLib

It's quite easy to follow to be honest. 

first you initialise the `ConfigHolder` class in your modInitialiser like so:

```java


import com.kirbosoftware.poyolib.api.config.ConfigManager;

public class ExampleMod implements ModInitializer {

    @Override
    public void onInitialize() {
        new ConfigManager().register("fileName", ExampleConfig.class).initialize();
    }
}
```
it automatically sets the filename and will create a file in the `config` folder upon launch. 

Then create a class where you will store your values. As example:

```java

import com.kirbosoftware.poyolib.api.config.Config;
import com.kirbosoftware.poyolib.api.config.ConfigValue;

public class ExampleConfig extends Config {
    public static ConfigValue<Integer> TEST_INT = addInteger("test_int", 11);
    public static ConfigValue<Boolean> TEST_BOOL = addBoolean("test_bool", false);
}
```
here we set 2 values, an int and a boolean. 

Then all you need to do is go back to the `ExampleMod` file and do this:

```java

import com.kirbosoftware.poyolib.api.config.ConfigManager;

public class ExampleMod implements ModInitializer {

    @Override
    public void onInitialize() {
        new ConfigManager().register("fileName", ExampleConfig.class).initialize();
    }
}
```
and now enjoy the wonders that will generate your config.