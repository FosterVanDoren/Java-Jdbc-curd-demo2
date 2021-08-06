package com.company;

public class EmployeeDAOFactory {
    private static EmployeeDAO dao;

    private EmployeeDAOFactory(){}

    public static EmployeeDAO getEmployeeDao(){
        if(dao==null)
            dao = new EmployeeDAOImpl();
        return dao;
    }
}
