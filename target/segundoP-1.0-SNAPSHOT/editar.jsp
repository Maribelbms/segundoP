<%@page import="com.emergentes.Modelo.productos"%>
<%
    productos item = (productos)request.getAttribute("miproducto"); 
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar</title>
    </head>
    <body>
        <h1>Nuevo Registro</h1>
        <form action="Sesion" method="post">
            <input type="hidden" name="id" value="<%=item.getId()%>">
            <table>
                <tr>
                    <td>Descripcion</td>
                    <td><input type="text" name="descripcion" value="<%=item.getDescripcion()%>"></td>
                   
                </tr>
                <tr>
                    <td>Cantidad</td>
                    <td><input type="text" name="cantidad" value="<%=item.getCantidad()%>"></td>
                   
                </tr>
                <tr>
                    <td>Precio</td>
                    <td><input type="text" name="precio" value="<%=item.getPrecio()%>"></td>
                   
                </tr>
                <tr>
                    <td>Categoria</td>
                    <td><input type="text" name="categoria" value="<%=item.getCategoria()%>"></td>
                   
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit"  value="Enviar"></td>
                   
                </tr>
                
            </table>
        </form>
    </body>
</html>
