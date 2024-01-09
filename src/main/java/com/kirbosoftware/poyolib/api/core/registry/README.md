# How to use the Registry module from Poyo Lib

## The Registar class
First you would want to set up a `Registar<T>` object like this:

```java

import com.kirbosoftware.poyolib.api.core.registry.Registar;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;

public class ExampleMod implements ModInitializer {
    public static Registar<Item> ITEMS = Registar.add(Registries.ITEM, "modId");

    @Override
    public void onInitialize() {

    }
}
```
Then create a new file where you will store your items like this:
```java
import com.kirbosoftware.poyolib.api.core.registry.RegEntry;
import net.minecraft.item.Item;

public class ExampleItems {
    public static final RegEntry<Item> TEST_ITEM = ExampleMod.ITEMS.register("test_item", new Item(new Item.Settings()));
    
    public static void init() {
        ExampleMod.ITEMS.initialize();
    }
}
```
and then initialise the `ExampleItems` class like this:

```java

import com.kirbosoftware.poyolib.api.core.registry.Registar;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;

public class ExampleMod implements ModInitializer {
    public Registar<Item> ITEMS = Registar.add(Registries.ITEM, "modId");

    @Override
    public void onInitialize() {
        ExampleItems.init();
    }
}
```