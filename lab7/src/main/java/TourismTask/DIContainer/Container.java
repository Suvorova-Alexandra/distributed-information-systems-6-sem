package TourismTask.DIContainer;

import TourismTask.BusinessLogic.ExternalService.RemoteServiceImpl;
import TourismTask.BusinessLogic.ExternalService.models.RemoteService;

public class Container {
    private static Container container;
    private Container() {
    }

    public static Container getInstance() {
        if (container == null) container = new Container();
        return container;
    }
    public RemoteService createRemoteService(){
        return new RemoteServiceImpl();
    }
}
