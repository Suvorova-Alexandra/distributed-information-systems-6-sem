package Common.server;

import Common.Remote.CalculateYearObject;
import Common.Options.OptionsProvider;
import Common.Options.ServerOptions;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

    public void startServer() {
        try {
            StringBuilder filePath=new StringBuilder();
            filePath.append(System.getProperty("user.dir"));
            filePath.append("/src/Common/Options.json");
            Path path= Paths.get(filePath.toString());
            OptionsProvider options = new OptionsProvider(path);
            ServerOptions serverOptionsProvider=options.getOptions();
            CalculateYearObject calculateYearObject=new CalculateYearObject();
            Registry registry = LocateRegistry.createRegistry(serverOptionsProvider.getPort());
            registry.bind(serverOptionsProvider.getName(), calculateYearObject);
            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();

        }
    }

}
