# Villager Trade Helper

This is a simple helper method to adjust villager trades upon your need. 

## Example

This is how you would alter a villager's trade based upon it's ItemListing. Super easy and useful to do! 
```java
import com.kirbosoftware.poyolib.api.world.entity.npc.VillagerTradeHelper;
import net.minecraft.world.entity.npc.VillagerProfession;

public class ModifyTrades {
    public static void init() {
        VillagerTradeHelper.modifyTrades(villagerProfession, tier, tradeList -> {
            tradeList.add("tradeList");
            tradeList.add("tradeList");
        });
        // or 
        VillagerTradeHelper.modifyTrades(villagerProfession, tier, tradeId, "tradeList");
    }
}
```