package TourismTask.Controller;

import TourismTask.BusinessLogic.ExternalService.models.RemoteService;
import TourismTask.DIContainer.Container;

import javax.xml.soap.*;
import java.io.*;

public class TourismController {

    private RemoteService service= Container.getInstance().createRemoteService();

    public void start() throws SOAPException, IOException {
        String fileXml="";
        BufferedReader br = new BufferedReader(new
                InputStreamReader(System.in));
        try {
            System.out.println("Enter the path to the XML file:");
            fileXml = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        service.createSOAPRequest(fileXml);
        service.createSOAPResponse();
    }
}
