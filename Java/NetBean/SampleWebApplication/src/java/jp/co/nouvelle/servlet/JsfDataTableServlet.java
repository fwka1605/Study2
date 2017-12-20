/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.nouvelle.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NVLCLT13
 */
@WebServlet(name = "JsfDataTableServlet", urlPatterns = {"/jsfsample"})
public class JsfDataTableServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Map> dataList = new ArrayList();
        
        Map dataMap = null;
        
        dataMap = new HashMap();
        dataMap.put("day", "2011/4/29");
        dataMap.put("name", "昭和の日");
        dataList.add(dataMap);
        
        dataMap = new HashMap();
        dataMap.put("day", "2011/5/3");
        dataMap.put("name", "憲法記念日");
        dataList.add(dataMap);

        dataMap = new HashMap();
        dataMap.put("day", "2011/5/4");
        dataMap.put("name", "みどりの日");
        dataList.add(dataMap);

        dataMap = new HashMap();
        dataMap.put("day", "2011/5/5");
        dataMap.put("name", "こどもの日");
        dataList.add(dataMap);

        dataMap = new HashMap();
        dataMap.put("day", "2011/5/8");
        dataMap.put("name", "母の日");
        dataList.add(dataMap);
        
        request.setAttribute("dataList", dataList);
        
        RequestDispatcher rd = request.getRequestDispatcher("faces/samplejsf.xhtml");
        rd.forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
