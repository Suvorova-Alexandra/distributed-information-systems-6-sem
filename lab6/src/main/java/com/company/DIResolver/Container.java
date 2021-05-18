package com.company.DIResolver;

import com.company.BusinessLogic.ExternalService.Models.RemoteService;
import com.company.BusinessLogic.ExternalService.RemoteServiceImpl;
import com.company.Controller.StudentsController;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;

public class Container {
    private static Container container;
    private static StudentsController controller;
    private static RemoteService remoteService;

    public StudentsController getController() throws MalformedURLException, ServiceException {
        if(controller==null) controller = new StudentsController(getRemoteService());
        return controller;
    }

    public RemoteService getRemoteService() throws MalformedURLException, ServiceException {
        if(remoteService==null) remoteService = RemoteServiceImpl.getInstance();
        return remoteService;
    }

    private Container() {
    }

    public static Container getInstance() {
        if (container == null) container = new Container();
        return container;
    }
}
