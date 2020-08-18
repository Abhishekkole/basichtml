import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
class Ser extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		PrintWriter out=response.getWriter();
		String rolno=request.getParameter("rollno");
		HttpSession session;
        	session = request.getSession(false);
     		String delims="-";
	 	String s;
	   	String token[]=rolno.split(delims);
		switch(token[2])
		{
			case "732":s="civil";break;
			case "733":s="cse";break;
			case "734":s="EEE";break;
			case "735":s="ECE";break;
			case "736":s="Mechanical";break;
			case "737":s="Information Technology";break;
			default:s="wrong";break;
			
		}
		if(session==null){
            session = request.getSession(); 
            session.setAttribute(rolno, s);
       }	
		else{
            if((session.getAttribute(rolno))!= null){
               int value = (Integer) session.getAttribute(rolno);
                value++;
                session.setAttribute(rolno,s);   
            }
		else{   
                session.setAttribute(rolno,s);  
            }           
       
        out.println("<html>" +
                    "<head><title> BRANCH</title></head>" +
                    "<body>"+
                    "<h1> The Roll number "+rolno+"belongs to "+s+" Department"+"</h1>"+ 
                    "</body>"+
                    "</html>");
    }
}
}