package DIResolver;

import BusinessLogic.ProgrammerControllerImpl;
import DataAccess.ProgrammerRepositoryImpl;

public class DIContainer {
    private static DIContainer container;

    private DIContainer() {
    }

    public static DIContainer getInstance() {
        if (container == null) container = new DIContainer();
        return container;
    }

    public ProgrammerControllerImpl createBean(){
        return new ProgrammerControllerImpl(ProgrammerRepositoryImpl.getInstance());
    }
}
