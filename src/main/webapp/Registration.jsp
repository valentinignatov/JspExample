<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="ISO-8859-1">
        <title>Insert title here</title>
    </head>

    <body>
        <%=request.getAttribute("error")%>

            <body bgcolor="White">
                <form method="post" action="registrationServlet">
                            <label> Username </label> <input type="text" name="Username" size="15" /> <br> <br> <label>
                                Nickname: </label> <input type="text" name="Nickname" size="15" /> <br> <br> <label>
                                Gender : </label><br> <input type="radio" name="gender" value="male" />
                            Male <br> <input type="radio" name="gender" value="female" />
                            Female <br>
                            <!-- <input type="radio" name="other"/> Other   -->
                            <br> <br> <label> Phone : +373 </label>
                            <!-- <input type="text" name="country code"  value="+373" size="0"/>    -->
                            <!-- <input type="text" name="country code"  value="+373"/>    -->
                            <!-- <input type="number" name="phone" size="8"/> <br> <br>   -->
                            <input type="number" name="phone" size="8" maxlength="11" /> <br>
                            <br> Address Email: <input type="email" id="email" name="email" />
                            <br> <br> <br> Password: <input type="Password" id="pass" name="pass"> <br> <br> <br>
                            Re-type
                            password: <input type="Password" id="repass" name="repass"> <br>
                            <br>
                            <button onclick="myFunction()" type="Submit" value="Registration">Registration
                            </button>
                </form>
            </body>
    </body>

    </html>