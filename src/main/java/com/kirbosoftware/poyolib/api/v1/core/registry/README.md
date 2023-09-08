## How to use the Registar module from Poyolib
First you would want to setup a `Registar<T>` object like this
```java
import com.kirbosoftware.poyolib.api.v1.core.registry.Registar;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;

public class ExampleMod implements ModInitializer {
    public Registar<Item> ITEMS = new Registar<>(Registries.ITEM, "modId"); 
    // or
    public Registar<Item> ITEMS = Registar.set(Registries.ITEM, "modId");
    
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