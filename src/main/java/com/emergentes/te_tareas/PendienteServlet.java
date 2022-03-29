package com.emergentes.te_tareas;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "PendienteServlet", urlPatterns = {"/PendienteServlet"})
public class PendienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");

        if (op.equals("vaciar")) {
            // Vaciar carrito
            HttpSession ses = request.getSession();
            ses.invalidate();
            response.sendRedirect("index.jsp");
        }
        if (op.equals("eliminar")){
            int pos = -1;
            int buscado = -1;
            int id = Integer.parseInt(request.getParameter("id"));
            // Eliminar el producto
            HttpSession ses = request.getSession();
            ArrayList<Tareas> lista = (ArrayList<Tareas>)ses.getAttribute("tareapen");
            
            for(Tareas p : lista){
                pos++;
                if (p.getId() == id){
                    buscado = pos;
                }                
            }
            lista.remove(buscado);
            response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String tarea = request.getParameter("tarea");
        int completado = Integer.parseInt(request.getParameter("completado"));

        Tareas tar = new Tareas();

        tar.setId(id);
        tar.setTarea(tarea);
        tar.setCompletado(completado);

        HttpSession ses = request.getSession();

        ArrayList<Tareas> lista = (ArrayList<Tareas>) ses.getAttribute("tareapen");

        lista.add(tar);

        response.sendRedirect("index.jsp");

    }

}
