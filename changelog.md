# Changelog 

## v0.3.1 for 1.20.1 and 1.20.4
- reworked the lang util package into a lang module. I will add more language stuff in there.
- revamped the mappings from yarn to Mojang's mappings. 
- updated to loom 1.5 and fabric loader 0.15.x
- small refactors to the registar package

## v0.3
- rewritten `Registar` module. See the module's `README.md`
- rewritten `Config` module. See the module's `README.md`
- moved classes away from `v1` to just `api/{module}` instead of `api/v1/{module}`.

## v0.2.1.2
- renamed `Food` to `FoodType`
- created a `Food` class for people to extend to instead of FoodType

## v0.2.1 && v0.2.1.1
### v0.2.1.1 only:
- fixed a crash relating to the rework of foodstuff.
### v0.2.1
- updated the way how you make foodstuff. Now you have an abstract class you would need to extend to and create your own food class to register.

## version 0.2

- Added a config module.
- Added a TagRegistar class for registering tags a bit easier. 
- Updated the Registar class.
- Renamed ArmorConstructor to ArmorBuilder.
- Added DamageableToolCraftingItem & adjusted a small thing in DamageableCraftingItem.