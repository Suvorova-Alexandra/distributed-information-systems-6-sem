package com.company.BusinessLogic.ExternalService.Models;

import org.apache.axis.AxisFault;
import org.apache.axis.client.Call;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;

public interface RemoteService {
    String getStudentByLastname(String lastname) throws AxisFault;
    String getStudentByAverageScore(String averageScore) throws AxisFault;
}
