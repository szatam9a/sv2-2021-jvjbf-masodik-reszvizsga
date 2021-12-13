package filemanipulation;

import algorithms.Gender;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class HumanFileManager {
    public List<Human> humans = new ArrayList<>();

    public void readHumansFromFile(Path path) {
        try {
            putHumansProperlyInToTheList(Files.readAllLines(path));
        } catch (IOException io) {
            throw new IllegalStateException("Can't read file!", io);
        }
    }

    private void putHumansProperlyInToTheList(List<String> humans) {
        for (String human : humans
        ) {
            String[] temp = human.split(";");
            this.humans.add(new Human(temp[0], temp[1]));
            if (temp[1].startsWith("1") || temp[1].startsWith("3")) {
                this.humans.get(this.humans.size() - 1).setGender(Gender.MALE);
            } else {
                this.humans.get(this.humans.size() - 1).setGender(Gender.FEMALE);
            }
        }
    }

    public List<Human> getHumans() {
        return humans;
    }

    public void writeMaleHumansToFile(Path path) {
        try {
            Files.write(path, convertMaleHumansIntoStringList(humans));
        } catch (IOException io) {
            throw new IllegalArgumentException("Cant write the file", io);
        }
    }

    private List<String> convertMaleHumansIntoStringList(List<Human> humans) {
        List<String> result = new ArrayList<>();
        for (Human human : humans
        ) {
            if (human.getGender().equals(Gender.MALE)) {
                result.add(human.toString());
            }
        }
        return result;
    }
}
