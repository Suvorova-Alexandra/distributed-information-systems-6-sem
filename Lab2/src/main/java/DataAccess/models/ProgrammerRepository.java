package DataAccess.models;

import DataAccess.models.pojo.Programmer;

import java.nio.file.Path;
import java.util.ArrayList;

public interface ProgrammerRepository {
    ArrayList<Programmer> getProgrammers(Path path);
}
