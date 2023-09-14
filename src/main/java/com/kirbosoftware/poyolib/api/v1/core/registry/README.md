# How to use the Registry module from Poyo Lib

## The Registar class
First you would want to set up a `Registar<T>` object like this:
```java
import com.kirbosoftware.poyolib.api.v1.core.registry.Registar;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;

public class ExampleMod implements ModInitializer {
    public Registar<Item> ITEMS = new Registar<>(Registries.ITEM, "modId");
    
    @Override
    public void onInitialize() {
        
    }
}
```
Then create a new file where you will store your items like this:
```java
import net.minecraft.item.Item;

public class ExampleItems {
    public static final Item TEST_ITEM = ExampleMod.ITEMS.register("test_item", new Item(new Item.Settings()));
    // or
    public static final Item TEST_ITEM = ExampleMod.ITEMS.register("test_item", () -> new Item(new Item.Settings()));


    public static void init() {
        
    }
}
```
and then initialise the `ExampleItems` class like this:
```java
import com.kirbosoftware.poyolib.api.v1.core.registry.Registar;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;

public class ExampleMod implements ModInitializer {
    public Registar<Item> ITEMS = new Registar<>(Registries.ITEM, "modId");
   
    @Override
    public void onInitialize() {
        ExampleItems.init();
    }
}
```

## The TagRegistar class
First you would want to set up a `TagRegistar<T>` object like this:

```java
import com.kirbosoftware.poyolib.api.v1.core.registry.TagRegistar;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;

public class ExampleMod implements ModInitializer {
    public TagRegistar<Item> ITEM_TAGS = new TagRegistar<>(Registries.ITEM, "modId");

    @Override
    public void onInitialize() {

    }
}
```
Then create a new file where you will store your item tags like this:

```java
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;

public class ExampleItemTags {
    public static final TagKey<Item> EXAMPLE_ITEM_TAG = ExampleMod.ITEM_TAGS.register("test_item");
}
```
and that's basically how you setup and create tags through this class.