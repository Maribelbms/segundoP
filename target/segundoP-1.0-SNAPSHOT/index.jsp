<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.Modelo.productos"%>
<%
    ArrayList<productos> lista= (ArrayList<productos>)session.getAttribute("listaprod");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Segundo Parcial</title>
    </head>
    <body align=" center">
         <p>SEGUNDO PARCIAL TEM-742</p>
        <p>Nombre: Brigida Maribel Surco Navarro</p>
        <p>Carnet:14185681</p>
        <br>
        
        <h1 align="center">Productos</h1>
        <br>
        <a href= "Sesion?op=nuevo">Nuevo Producto</a>
        <table border="1">
            <tr>
                <th>id</th>
                <th>Descripcion</th>
                <th>Cantidad</th>
                <th>Precio</th>
                <th>Categoria</th>
                <th>Editar</th>
                <th>Eliminar</th>
                <%
                    if(lista !=null){
                        for(productos item:lista){
                %>  
            <tr>
                <td><%=item.getId()%></td>
                <td><%=item.getDescripcion()%></td>
                <td><%=item.getCantidad()%></td>
                <td><%=item.getPrecio()%></td> 
                <td><%=item.getCategoria()%></td> 
                <td><a href ="Sesion?op=editar&id= <%=item.getId()%>">Editar</a></td> 
                <td><a href ="Sesion?op=eliminar&id= <%=item.getId()%>"
                       onclick="return confirm('Esta seguro de eliminar?')">Eliminar</a></td> 
                
            </tr>
                <%        
                    }
                    }
                %>
                
            </tr>
        </table>
        
    </body>
</html>
