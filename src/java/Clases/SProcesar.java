/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adriangutna
 */
@WebServlet(name = "SProcesar", urlPatterns = {"/SProcesar"})
public class SProcesar extends HttpServlet {

    Alumnos alumno[] = new Alumnos[10];
    int cont = 0;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        if (request.getParameter("btnGuardar") != null) {
            alumno[cont] = new Alumnos("", "", "", "", "", "", "", 0.0);
            alumno[cont].setMatricula(request.getParameter("tfMatricula"));
            alumno[cont].setNombre(request.getParameter("tfNombre"));
            alumno[cont].setApellidoPaterno(request.getParameter("tfApellidoPaterno"));
            alumno[cont].setApellidoMaterno(request.getParameter("tfApellidoMaterno"));
            alumno[cont].setDdi(request.getParameter("tfDdi"));
            alumno[cont].setDwi(request.getParameter("tfDwi"));
            alumno[cont].setEcbd(request.getParameter("tfEcbd"));
            cont++;
        }

        if (request.getParameter("btnGuardar") != null) {
            out.println(""
                    + "<table class='table' id='tabla'>"
                    + "<thead >"
                    + "<tr class='table-danger'>"
                    + "<th scope='col'>Matricula</th>"
                    + "<th scope='col'>Alumno</th>"
                    + "<th scope='col'>DDI</th>"
                    + "<th scope='col'>DWI</th>"
                    + "<th scope='col'>ECBD</th>"
                    + "<th scope='col'>Promedio</th>"
                    + "</tr>"
                    + "</thead>"
                    + "<tbody>");
            for (int i = 0; i <= cont; i++) {
                out.println(""
                        + "<tr>"
                        + "<td>" + alumno[i].getMatricula() + "</td>"
                        + "<td>" + alumno[i].getNombre() + " " + alumno[i].getApellidoPaterno() + " " + alumno[i].getApellidoMaterno() + "</td>"
                        + "<td>" + alumno[i].getDdi() + "</td>"
                        + "<td>" + alumno[i].getDwi() + "</td>"
                        + "<td>" + alumno[i].getEcbd() + "</td>"
                        + "<td>" + alumno[i].getPromedio() + "</td>"
                        + "</tr>"
                );
            }
            out.println(
                    "</tbody>"
                    + "</table>"
            );

        };

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
