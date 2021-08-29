package com;
import java.sql.*;
import com.*;

public class DataBase
{
Connection con;

public DataBase()
{
try
{
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindetail?user=root&password=vishal");
}
catch(Exception e)
{
}
}

public boolean check(User u)
{
boolean b = false;

try
{
PreparedStatement ps = con.prepareStatement("select * from login where Name = ? and Password = ?");

ps.setString(1,u.Name);
ps.setString(2,u.Password);

ResultSet rs = ps.executeQuery();

if(rs.next()==true)
{
b=true;
}
else
{
b=false;
}
}
catch(SQLException e)
{
System.out.println("SQL exception");
}
return b;
}

public int insert(Student s1)
{
int x=0;

try
{
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/contactdetail?user=root&password=vishal");
}
catch(Exception e)
{
}
try
{
PreparedStatement ps = con.prepareStatement("insert into contact values(?,?,?,?");




ps.setString(1,s1.Name);
ps.setString(2,s1.Email);
ps.setInt(3,s1.Phone);
ps.setString(4,s1.Message);

x= ps.executeUpdate();

}
catch(SQLException e)
{
System.out.println("SQL exception");
}
return x;
}

}



