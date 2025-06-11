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
@WebServlet(name = "LightController", value = "/light")
public class LightController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String lightStatus = req.getParameter("lightStatus");
                String lightLevel = req.getParameter("lightLevel");
                
                double level=Double.parseDouble(lightLevel);
                double val=level*2.55;
                
                int value=(int)val;

        if (lightStatus == "true") {
            resp.getWriter().write("lightOff");
        } else {
            resp.getWriter().write("lightOn");
        }

        resp.getWriter().write(value);
        
        
    }

}
