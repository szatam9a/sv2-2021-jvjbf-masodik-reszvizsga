package city;

public class Home extends Building{
    public static final int SQUARE_METERS_NEED_PER_PERSON = 20;
    public Home(double area, int levels, Address address) {
        super(area, levels, address);
        if (levels>3){
            throw new IllegalArgumentException("Cant be more than 3 floors");
        }
    }

    public Home(double area, Address address) {
        super(area, address);
    }
    public int calculateNumberOfPeopleCanFit(){
        return (int) getFullArea()/SQUARE_METERS_NEED_PER_PERSON;
    }
}
