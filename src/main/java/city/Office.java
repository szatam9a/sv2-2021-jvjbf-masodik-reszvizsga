package city;

public class Office extends Building {
    private String company;
    private int numberOfTablesPerLevel;

    public Office(double area, int floors, Address address, String name, int table) {
        super(area, floors, address);
        this.company = name;
        if (!isThereEnoughSpaceForTables(table)){
            throw new IllegalArgumentException("Table problems");
        }
        this.numberOfTablesPerLevel = table;

    }

    public Office(double area, Address address, String name, int table) {
        super(area, address);
        this.company = name;
        if (!isThereEnoughSpaceForTables(table)){
            throw new IllegalArgumentException("Table problems");
        }
        this.numberOfTablesPerLevel = table;

    }

    private boolean isThereEnoughSpaceForTables(int table) {
        if (getArea() / table > 5 || getArea() / table < 2) {
            return false;
        }
        return true;
    }

    @Override
    public int calculateNumberOfPeopleCanFit() {
        return numberOfTablesPerLevel*(getLevels()-1);

    }

    public String getCompany() {
        return company;
    }

    public int getNumberOfTablesPerLevel() {
        return numberOfTablesPerLevel;
    }
}
