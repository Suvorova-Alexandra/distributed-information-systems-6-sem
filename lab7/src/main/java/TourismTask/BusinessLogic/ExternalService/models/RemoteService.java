package TourismTask.BusinessLogic.ExternalService.models;

import javax.xml.soap.SOAPException;
import java.io.IOException;

public interface RemoteService {
    void createSOAPRequest(String fileXml) throws SOAPException;
    void createSOAPResponse() throws SOAPException, IOException;
}
