package com.company.Client;


import com.company.Controller.StudentsController;
import com.company.DIResolver.Container;

import javax.xml.rpc.ServiceException;
import java.io.IOException;

public class ClientMain {
    public static void main(String[] args) throws IOException, ServiceException {
        StudentsController controller = Container.getInstance().getController();
        controller.startClient();
    }
}
