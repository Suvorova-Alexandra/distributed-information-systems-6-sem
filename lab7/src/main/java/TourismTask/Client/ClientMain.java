package TourismTask.Client;

import TourismTask.Controller.TourismController;

public class ClientMain {
    public static void main(String[] args) throws Exception {
        TourismController client = new TourismController();
        client.start();
        
    }
}
