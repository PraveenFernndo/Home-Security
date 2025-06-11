/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author prave
 */
@WebServlet(name="GateController",value = "/gate")
public class ControlGate extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String gateStatus = req.getParameter("gateStatus");
        
         if(gateStatus=="true"){
            resp.getWriter().write("gateOpen");
        }else{
            resp.getWriter().write("gateClose");
        }
        
    }
    
    
    
}
