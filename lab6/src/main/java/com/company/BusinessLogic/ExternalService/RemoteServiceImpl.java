package com.company.BusinessLogic.ExternalService;

import com.company.BusinessLogic.ExternalService.Models.RemoteService;
import org.apache.axis.AxisFault;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.net.URL;

public class RemoteServiceImpl implements RemoteService {

    private static String SERVICE_URL = "http://localhost:8080/axis/StudentService.jws";
    private static Call call;
    private static RemoteService remoteService;

    private RemoteServiceImpl() {

    }

    public static RemoteService getInstance() throws MalformedURLException, ServiceException {
        if (remoteService == null) remoteService = new RemoteServiceImpl();
        if (call == null) call = create();
        return remoteService;
    }

    private static Call create() throws MalformedURLException, ServiceException {
        Service service = new Service();
        Call call = (Call) service.createCall();
        call.setTargetEndpointAddress(new URL(SERVICE_URL));
        return call;
    }

    @Override
    public String getStudentByLastname(String lastname) throws AxisFault {
        Object[] param = new Object[]{lastname};
        String student = (String) call.invoke("findStudentByLastname", param);
        return student;
    }

    @Override
    public String getStudentByAverageScore(String averageScore) throws AxisFault {
        Object[] param = new Object[]{averageScore};
        String student = (String) call.invoke("findStudentByAverageScore", param);
        return student;
    }
}
