/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package littlelibrary;

/**
 *
 * @author Admin
 */
public class Bookshelf {
    private String ID;
    private String Location;

    public Bookshelf(String ID, String Location) {
        this.ID = ID;
        this.Location = Location;
    }
    public Bookshelf() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getLocation() {
        if(Location.equals("GF"))
            return "Ground Floor";
        else if(Location.equals("1F"))
            return "First Floor";
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }
}
