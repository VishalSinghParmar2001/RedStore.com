import com.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


public class LoginServlet extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
PrintWriter out = res.getWriter();
User u = new User();
u.Name  = req.getParameter("t1");
u.Password  = req.getParameter("t2");
DataBase db = new DataBase();
String target="";
boolean b = db.check(u);
if(p1==true)
{

req.setAttribute("sms","ValidUser");
target="index.html";
}
else
{
req.setAttribute("sms","InValidUsername/password");
target="index.jsp";
}

RequestDispatcher rd =  getServletContext().getRequestDispatcher("/"+target);
rd.include(req,res);
}
}

