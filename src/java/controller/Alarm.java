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
@WebServlet(name = "Alarm",value = "/alarm")
public class Alarm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String alarmStatus=req.getParameter("alarmStatus");
        
        if(alarmStatus=="true"){
            resp.getWriter().write("AlarmOff");
        }else if(alarmStatus=="false"){
            resp.getWriter().write("AlarmOn");
        }
        
    }
    
}
