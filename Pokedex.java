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

import java.util.Scanner;
public class Pokedex {
    // Declare global pokemon array 
    Pokemon [] database;
    //Keep track of the amount of pokemon stored in array
    int gottaCatchThemAll = -1;
    
    //Declare constructor 
    public Pokedex(int size) {
        database = new Pokemon [size];
        gottaCatchThemAll = -1;

    }
    
    //Method that returns a string array, lists pokemon objects in array 
    public String[] listPokemon(){
        
        //Find size of array that must be created 
        int counter;
         for(counter = 0; counter < database.length; counter++) {
             if(database[counter] == null)
                 break;
         }
        
        //Create string array that will be returned 
        String[] dexContainer = new String [counter];
        
        //Traverse array, retrieving each objects respective string 
        for(int i = 0; i < dexContainer.length; i++) {
           
            dexContainer[i] = database[i].getSpecies();
        }
        
        //Bug, array not evaluating to null when empty && called by project4.java; Solution: Hardcode case in
        if (gottaCatchThemAll == -1) {
            return null;
        }
        //Return string array
        return dexContainer;
    }
    
    //Method to add pokemon to array
    public boolean addPokemon(String species) {
        boolean valid = true;
        gottaCatchThemAll++;
        
        //Tests if object would exceed limit of array
        if (gottaCatchThemAll > (database.length -1)) {
            valid = false;
            System.out.println("Max");
            gottaCatchThemAll--;
        }
        
        if (valid != false) {
            //Traverses array to see if duplicate object exists
            for (int i = 0; i < database.length; i++) {
                
                if ((database[i] != null) && species.equalsIgnoreCase(database[i].getSpecies())) {
                   valid = false; 
                   System.out.println("Duplicate");
                   gottaCatchThemAll--;
                }
            }
        }
        //If max and duplicate conditions are false, proceed with adding object to array
        if (valid == true) {
            //Calls pokemon constructor depended upon string
            Pokemon store = new Pokemon(species);
            //Stores newly created object into array
            database[gottaCatchThemAll] = store; 
        }
          
         
        
        //Return boolean on whether addition was successful
        return valid;
    }

    //Lists the statistics of a pokemon assuming that said pokemon is contained within array
    public int[] checkStats (String species) {
        
        //Creates int array of a size equal to number of statistics
        int [] statBlock = new int [3];
        //Creates boolean to determine whether statistics should be checked and returned 
        boolean proceed = false;
        
        //Checks array to see if contains the desired pokemon species
        for (int i = 0; i < (database.length); i++) {
            
            if ((database[i] != null) && species.equalsIgnoreCase(database[i].getSpecies())) {
               proceed = true; 
            }
        }
        
        //If previous for loop meets if conditional, a new pokemon object may be created based on method parameters
        if (proceed == true) {
            for (int i = 0; i < (database.length); i++) {
                if ((database[i] != null) && (database[i].getSpecies().equalsIgnoreCase(species))) {
                    statBlock[0] = database[i].getAttack();
                    statBlock[1] = database[i].getDefense();
                    statBlock[2] = database[i].getSpeed(); 
                }
                    
            }
            
            //Return int array
            return statBlock;
        }
        //If proceed remains in default state a null int[] will be returned
        else 
            return null;
        
   }
   //Sorts pokemon in array with a selection sort algorithm, each object is assigned a string upon creation these strings are used to sort the pokemon in array
   public void sortPokemon() {
       //Algorithm swaps objects based on a low index, this low index increases based on number of objects correctly sorted until entire array is correctly sorted
       for (int i = 0; i < database.length; i++) {
           int lowIndex = i;
           
           for (int j = (i+1); j < database.length; j++){
               //Ensures that elements in array that remain null, due to not being completely filled by user are not sorted
               if ((database[j] != null) && (database[j].getSpecies()).compareToIgnoreCase(database[lowIndex].getSpecies()) < 0)
                   lowIndex = j;
           }
           Pokemon placeholder = database[i];
           database[i] = database[lowIndex];
           database[lowIndex] = (placeholder);
           
       }
   }









}
