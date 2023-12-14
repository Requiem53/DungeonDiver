# Dungeon Diver
----------------------------------
Create a party of four adventurers embarking 
deep into a peculiar dungeon, for glory, wealth,
and the thrill of adventure, and 
with danger awaiting in every turn 

------------------------------------
Patterns used:

State Pattern: Every stage of the game is contained in a State
(all found in the state package) to easily add various isolated scenarios
like shopping, descending, and battling without the need for long, nested if statements

-----------------------------

Builder Pattern: Used to easily make equipments such as Armors and Weapons 
where not all the fields need to be changed on creation. 

(Used in Equipment/EquippableBuilder.java, 
Spells/SpellBuilder.java, Items/ItemBuilder.java, 
and Attacks/AttackBuilder.java)

-----------------------------
Command Pattern: Used to turn Actions into objects and 
placed into (once a sorted list) into a queue where they are executed one by one in battle

(Used in Actionable.java, Action.java and ActionTurn.java for the execution)

Actionables are objects the player has like items/spells
that can return actions (heal, damage, etc.). Actions themselves 
are objects and can be put on lists before they are executed.

-----------------------------

Singleton Pattern: Characters/AllyClassList.java is a singleton that contains
every class that the player can select their adventurer to be. Every time we add
a new choose-able class, we only need to update this in order for it to 
reflect to the entire game

-----------------------------

OOP Java Capstone by F1-Group4 Batch 2023 for CSIT-227

a project for sera2
