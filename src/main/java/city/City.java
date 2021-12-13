package city;

import java.util.ArrayList;
import java.util.List;

public class City {
    private String name;
    private long fullArea;
    private List<Building> buildings = new ArrayList<>();

    public City(String name, long fullArea) {
        this.name = name;
        this.fullArea = fullArea;
    }

    public void addBuilding(Building building) {
        if (isThereSpaceToAdd(building)) {
            buildings.add(building);
        } else {
            throw new IllegalArgumentException("City can't be larger than "+getFullArea());
        }
    }

    private boolean isThereSpaceToAdd(Building victim) {
        long totalArea = 0;
        for (Building building : buildings
        ) {
            totalArea += building.getFullArea();
        }
        if (fullArea > totalArea + victim.getFullArea()) {
            return true;
        }
        return false;
    }

    public Building findHighestBuildingInCity() {
        Building theWinner = null;
        int maxLevelYet = Integer.MIN_VALUE;
        for (Building building : buildings
        ) {
            if (theWinner == null || building.getLevels() > maxLevelYet) {
                theWinner = building;
                maxLevelYet = building.getLevels();
            }
        }
        return theWinner;
    }

    boolean isThereBuildingWithMorePeopleThan(int numberOfPeople) {
        for (Building building : buildings
        ) {
            if (building.calculateNumberOfPeopleCanFit() > numberOfPeople) {
                return true;
            }
        }
        return false;
    }


    public Building findHighestBuilding() {
        Building theWinner = null;
        int maxLevelYet = Integer.MIN_VALUE;
        for (Building building : buildings
        ) {
            if (theWinner == null || building.getLevels() > maxLevelYet) {
                theWinner = building;
                maxLevelYet = building.getLevels();
            }
        }
        return theWinner;
    }

    public List<Building> findBuildingsByStreet(String street) {
        List<Building> result = new ArrayList<>();

        for (Building building : buildings
        ) {
            if (building.getAddress().getStreet().equals(street)) {
                result.add(building);
            }
        }
        return result;
    }


    public String getName() {
        return name;
    }

    public long getFullArea() {
        return fullArea;
    }

    public List<Building> getBuildings() {
        return buildings;
    }
}
