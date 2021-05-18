package Common.client;

import Common.Remote.CalculateYear;
import Common.Options.OptionsProvider;
import Common.Options.ServerOptions;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {

    public Client() {

    }

    private int enterYear() {
        Scanner in = new Scanner(System.in);
        int year;
        do {
            System.out.print("Input a year(from 1000 to 2050): ");
            while (!in.hasNextInt()) {
                System.out.println("That not a number!\nInput a year(from 1000 to 2050): ");
                in.next();
            }
            year = in.nextInt();
        } while (year <= 1000 || year >= 2050);
        return year;
    }

    public void startClient() {
        try {
            StringBuilder filePath=new StringBuilder();
            filePath.append(System.getProperty("user.dir"));
            filePath.append("/src/Common/Options.json");
            Path path= Paths.get(filePath.toString());
            OptionsProvider options = new OptionsProvider(path);
            ServerOptions serverOptionsProvider = options.getOptions();
            Registry registry = LocateRegistry.getRegistry(serverOptionsProvider.getPort());
            CalculateYear stub = (CalculateYear) registry.lookup(serverOptionsProvider.getName());
            int year = enterYear();
            boolean response = stub.isLeap(year);
            StringBuffer answer = new StringBuffer();
            answer.append("response: ");
            answer.append(year);
            if (response) {
                answer.append(" - leap year. ");
            } else {
                answer.append(" - not leap year. ");
            }
            System.out.println(answer);

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }


    }
}
