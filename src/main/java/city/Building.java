package city;

public abstract class Building {
    private double area;
    private int levels =1;
    private Address address;

    public Building(double area, int floors, Address address) {
        this.area = area;
        this.levels = floors;
        this.address = address;
    }

    public Building(double area, Address address) {
        this.area = area;
        this.address = address;
    }
    public abstract int calculateNumberOfPeopleCanFit();

    public double  getFullArea(){
        return levels *area;
    }
    public double getArea() {
        return area;
    }

    public int getLevels() {
        return levels;
    }

    public Address getAddress() {
        return address;
    }
}
