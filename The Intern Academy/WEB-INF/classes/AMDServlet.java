import com.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


public class AMDServlet extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
PrintWriter out = res.getWriter();
Student s1 = new Student();
try
{

s1.Name = req.getParameter("t1");
s1.Email = req.getParameter("t2");
try
{

s1.Phone  = Integer.parseInt(req.getParameter("t3"));
}
catch(Exception e)
{

}
s1.Message = req.getParameter("t4");

String op = req.getParameter("b1");
DataBase db = new DataBase();
int x=0;
if(op.equals("Add"))
{
x = db.insert(s1);
if(x>=1)
{

req.setAttribute("sms","Record inserted successfully");
}
else
{
req.setAttribute("sms","Record could not be inserted");
}
}

