
package com.emergentes.Controlador;

import com.emergentes.Modelo.productos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "Sesion", urlPatterns = {"/Sesion"})
public class Sesion extends HttpServlet {

  
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     HttpSession ses= request.getSession();
     int id,pos;
     if(ses.getAttribute("listaprod")==null){
         ArrayList<productos> listaux= new ArrayList<productos>();
         ses.setAttribute("listaprod",listaux);
         
     }
     ArrayList<productos> lista=(ArrayList<productos>)ses.getAttribute("listaprod");
     String op=request.getParameter("op");
     String opcion=(op!=null)?op: "view";
     productos obj1= new productos();
     switch(opcion){
         case "nuevo":
             request.setAttribute("miproducto", obj1);
             request.getRequestDispatcher("editar.jsp").forward(request, response);
             break;
         case "editar":
             id=Integer.parseInt(request.getParameter("id"));
             pos = buscarIndice(request,id);
             obj1= lista.get(pos);
             request.setAttribute("miproducto", obj1);
             request.getRequestDispatcher("editar.jsp").forward(request, response);
             break;
             
         case "eliminar":
             id=Integer.parseInt(request.getParameter("id"));
             pos = buscarIndice(request,id);
             lista.remove(pos);
             response.sendRedirect("index.jsp");
             
         case "view":
             ses.setAttribute("listaprod", lista);
             response.sendRedirect("index.jsp");
             break;
                
     }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession();
        ArrayList<productos> lista= (ArrayList<productos>) ses.getAttribute("listaprod");
        productos obj1= new productos();
        
        int idt;
        obj1.setId(Integer.parseInt(request.getParameter("id")));
        obj1.setDescripcion(request.getParameter("descripcion"));
        obj1.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
        obj1.setPrecio(Double.parseDouble(request.getParameter("precio")));
        obj1.setCategoria(request.getParameter("categoria"));
        

        
        idt =obj1.getId();
        if(idt ==0){
        obj1.setId(ultimoId(request));
        lista.add(obj1);  
        }else{
            lista.set(buscarIndice(request,idt), obj1);    
        }
        
        
        
        response.sendRedirect("index.jsp");
       
    }
    private int ultimoId(HttpServletRequest request){
        HttpSession ses=request.getSession();
        ArrayList<productos> lista= (ArrayList<productos>)ses.getAttribute("listaprod");
        
        int idaux=0;
        for(productos item:lista){
            idaux=item.getId();
        }
        return idaux +1;
    }
    private int buscarIndice(HttpServletRequest request, int id)
    {
        HttpSession ses=request.getSession();
        ArrayList<productos> lista= (ArrayList<productos>)ses.getAttribute("listaprod");
        int i=0;
        if(lista.size()>0){
            while(i < lista.size()){
                if(lista.get(i).getId() == id){
                    break;
                }else{
                    i++;
                }
            }
        }
        return i;
    }
    

   
  
}
