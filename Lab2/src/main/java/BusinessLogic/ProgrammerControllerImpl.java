package BusinessLogic;

import BusinessLogic.models.ProgrammerController;
import DataAccess.models.pojo.Programmer;
import DataAccess.models.ProgrammerRepository;
import javax.ejb.Stateless;
import java.nio.file.Path;
import java.util.ArrayList;

@Stateless
public class ProgrammerControllerImpl implements ProgrammerController {
    private  ProgrammerRepository repository;

    public ProgrammerControllerImpl(ProgrammerRepository repository) {
        this.repository=repository;
    }

    @Override
    public Programmer showHighPaidProgrammer(Path path) {
        ArrayList<Programmer> programmers = repository.getProgrammers(path);
        Programmer max = programmers.get(0);
        for (Programmer programmer : programmers)
            if (programmer.getSalary() > max.getSalary()) max = programmer;
        return max;
    }

    @Override
    public ArrayList<Programmer> showProgrammerByPosition(String position, Path path) {
        ArrayList<Programmer> filteredProgrammers = new ArrayList<>();
        for (Programmer programmer : repository.getProgrammers(path))
            if (programmer.getPosition().equals(position)) filteredProgrammers.add(programmer);
        return filteredProgrammers;
    }
}
