/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
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
@WebServlet(name = "weather", value = "/weather")
public class Weather extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String temp=req.getParameter("temp");
        String humidity=req.getParameter("hum");
        
        Gson gson =new Gson();
        JsonObject response=new JsonObject();
        temp="20";
        humidity="50";
        response.addProperty("temp", temp);
        response.addProperty("humidity",humidity);
        
        resp.setContentType("application/json");
        resp.getWriter().write(gson.toJson(response));
        
    }

}
