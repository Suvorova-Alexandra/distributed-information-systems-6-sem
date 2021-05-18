package BusinessLogic.models;

import DataAccess.models.pojo.Programmer;

import javax.ejb.Local;
import java.nio.file.Path;
import java.util.ArrayList;

@Local
public interface ProgrammerController {

    Programmer showHighPaidProgrammer(Path path);

    ArrayList<Programmer> showProgrammerByPosition(String position, Path path);
}
