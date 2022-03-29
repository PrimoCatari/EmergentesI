<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.te_tareas.Tareas"%>
<%
    if (session.getAttribute("tareapen") == null){
        ArrayList<Tareas> lisaux = new ArrayList<Tareas>();
        session.setAttribute("tareapen", lisaux);
    }
    
    ArrayList<Tareas> tareapen = (ArrayList<Tareas>)session.getAttribute("tareapen");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>REGISTRO DE TAREAS</h1>
        <%  if (!(sesion.isNew())) { %>
	
        <form action="PendienteServlet" method="post">
            <table>
                <tr>
                    <td>Id</td>
                    <td><input type="text" name="id" value="0" size="2"></td>
                </tr>
                <tr>
                    <td>Tarea</td>
                    <td><input type="text" name="tarea" value="" ></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="hidden" name="completado" value="0" ></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Procesar"></td>
                </tr>
            </table>
        </form>
        <% }  %> 
        <a href="PendienteServlet?op=vaciar">Vaciar</a>
        
        <h2>Tareas Pendientes</h2>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Tarea</th>
                <th>Completado</th>
                <th></th>
            </tr>
            <%
                if (tareapen != null){
                    for (Tareas p : tareapen){
            %>
            <tr>
                <td><%= p.getId() %></td>
                <td><%= p.getTarea() %></td>
                <td><a href="PendienteServlet?op=modificar&id=<%= p.getCompletado() %>">
                        <input type="checkbox" value="<%= p.getCompletado() %>" id="tableid" class="click">
                        </a></td>
                <td><a href="PendienteServlet?op=eliminar&id=<%= p.getId() %>">Eliminar</a></td>
            </tr>
            <%
                    }
                }  
            %>
        </table>
    </body>
</html>
