package CustomersTask.WebFace.Controller;

import CustomersTask.BusinessLogicModels.CustomerService;
import CustomersTask.DIResolver.DIContainer;
import CustomersTask.BusinessLogicModels.pojo.Customer;
import CustomersTask.WebFace.util.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowCustomerServlet extends HttpServlet {
    private CustomerService customerService=DIContainer.getInstance().createCustomerController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(URL.BASE_URL);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html; charset=UTF-8;");
        resp.setCharacterEncoding("UTF-8");
        int number=0;
        if(req.getParameter("number").equals("")){


            req.setAttribute("result", "EMPTY");
        }
        else {

            number = Integer.parseInt(req.getParameter("number"));
            Customer customer = customerService.findCustomer(number);
            if (customer != null) {
                req.setAttribute("result", "OK");
                req.setAttribute("name", customer.getFullName());
                req.setAttribute("phone", customer.getPhone());
                req.setAttribute("creditLimit", customer.getCreditLimit());

            } else {
                req.setAttribute("result", "NOT OK");
            }

        }

        if(req.getParameter("creditLimit").equals("")){
            req.setAttribute("resultProcedure","EMPTY");
        }
        else {
            double limit=Double.parseDouble(req.getParameter("creditLimit"));
            List<Customer> customers=customerService.filterCustomersByLimit(limit);
            if(customers!=null){
                req.setAttribute("resultProcedure", "OK");
                req.setAttribute("customers",customers);
            }
            else{
                req.setAttribute("resultProcedure", "NOT OK");
            }
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(URL.SHOW_CUSTOMER);
        requestDispatcher.forward(req, resp);
    }
}
