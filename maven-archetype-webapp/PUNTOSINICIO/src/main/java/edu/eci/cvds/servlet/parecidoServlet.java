package edu.eci.cvds.servlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import edu.eci.cvds.servlet.model.*;


@WebServlet(
		urlPatterns = "/Osamah"
)


public class parecidoServlet extends HttpServlet{
    public parecidoServlet(){
    	
    }

    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Writer responseWriter = resp.getWriter();
       Optional<String> optName = Optional.ofNullable(req.getParameter("id"));
       String id = optName.isPresent() && !optName.get().isEmpty() ? optName.get() : "";

       try {
    	   Todo todo = Service.getTodo(Integer.parseInt(id));
           resp.setStatus(HttpServletResponse.SC_OK);
           List<Todo> todos = Arrays.asList(todo);
           responseWriter.write(Service.todosToHTMLTable(todos));
           responseWriter.flush();
       }
       catch(MalformedURLException e) {
    	   resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    	   
       }catch(FileNotFoundException e) {
    	   resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
       }catch(NumberFormatException e) {
    	   resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
       }
       
    }
    
    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Writer responseWriter = resp.getWriter();
       try {
    	   Optional<String> optName = Optional.ofNullable(req.getParameter("id"));
           String id = optName.isPresent() && !optName.get().isEmpty() ? optName.get() : "";
           System.out.println(id);
    	   Todo todo = Service.getTodo(Integer.parseInt(id));
           resp.setStatus(HttpServletResponse.SC_OK);
           List<Todo> todos = Arrays.asList(todo);
           responseWriter.write(Service.todosToHTMLTable(todos));
           responseWriter.flush();
       }
       catch(MalformedURLException e) {
    	   resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
       }catch(FileNotFoundException e) {
    	   resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
       }catch(NumberFormatException e) {
    	   resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
       }     
    }
}
