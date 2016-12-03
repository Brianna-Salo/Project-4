/*Name: Jesse Martinez
 *Class Section: 6909
 *Instructor: Dr. Kyla McMullen
 *Date: November 15, 2016
 *Destription: Creates a pokemon object with certain attributes, 
 *allows user to store these objects in an array,
 *allow users to obtain the attributes of a pokemon object. 
 *Users may sort and list the pokemon in the created array.
 *Removed package declaration
 */


public class Pokemon {
    //Declare varaibles belonging to object
    String species = null;
    int attack;
    int defense; 
    int speed;
    
    //Constructor based on string, default constructor will return null
    public Pokemon(String species) {
       this.species = species;
       attack = (species.length() * 4) + 2;
       defense = (species.length() * 2) + 7;
       speed = (species.length() * 3) + 5;
    }
    
    //Return String species
    public String getSpecies() {
        return species;
    }
    
    //Set String species to new String
    public void setSpecies(String spc) {
        species = spc; 
    }
    
    //Return int attack
    public int getAttack() {
        return attack;
    }
    
    //Set int attack to nrw int
    public void setAttack(int attack) {
        this.attack = attack;
    }
    
    //Return int defense
    public int getDefense() {
        return defense;
    }
    
    //Set int defense to nrw int
    public void setDefense (int def) {
        defense = def;
    }
    
    //Return int speed
    public int getSpeed(){
        return speed;
    }
    
    //Set int speed to new speed
    public void setSpeed(int spd) {
        speed = spd;
    }
    
    //Increase attack by set integer
    public void grow(int boost) {
        attack += boost;
    }
    
    //Increase defense by set integer
    public void harden(int boost) {
        defense += boost;
    }
    
    //Increase speed by set integer
    public void haste(int boost) {
        speed += boost;
    }
    
}
