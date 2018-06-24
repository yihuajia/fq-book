package com.web.action;

import com.domain.Employee;
import com.inf.EmployeeServiceInter;
import com.web.form.EmployeeForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction extends DispatchAction {

    @Resource
    private  EmployeeServiceInter employeeServiceInter;
    private int a = 0;

    public void setEmployeeServiceInter(EmployeeServiceInter employeeServiceInter) {
        this.employeeServiceInter = employeeServiceInter;
    }

    public ActionForward login(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
//       WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServlet().getServletContext());
//       EmployeeServiceInter esi = (EmployeeServiceInter) wac.getBean("employeeServiceInterfaceImpl");


        System.out.println("a="+(++a));
        EmployeeForm employeeForm = (EmployeeForm) form;
        Employee e = new Employee();
        e.setPassword(employeeForm.getPassword());
        e.setId(Integer.parseInt(employeeForm.getId()));
      e = employeeServiceInter.checkEmp(e);
       if (e!=null){
           request.getSession().setAttribute("loginuser",e);
           return  mapping.findForward("ok");
       }else {
           return  mapping.findForward("err");

       }
    }

    public ActionForward goMain(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getSession().getAttribute("loginuser")!=null){
            return  mapping.findForward("ok");
        }else {
            return  mapping.findForward("err");
        }
    }
}
