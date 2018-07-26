package com.email;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;

/**
 * Servlet implementation class FetchEmail
 */
@WebServlet("/FetchEmail")
public class FetchEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//static  AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion("ap-south-1").build();
//	DynamoDBMapper mapper=new DynamoDBMapper(client);
//	DynamoDB dynamoDB = new DynamoDB(client);
//	Table table = dynamoDB.getTable("ECREATORS_VIL_USER_DATA");
	private String successMessage;

    /**
     * Default constructor. 
     */
    public FetchEmail() {
        // TODO Auto-generated constructor stub
    	String successMessage = null;
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mobileNo = request.getParameter("mobile");
//		GetItemSpec spec = new GetItemSpec().withPrimaryKey("MOBILE_NUMBER",mobileNo);
		String email = null;
		try {
//			Item outcome = table.getItem(spec);
//			email = (String) outcome.get("EMAIL_ID");
		}catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html> <body> <form action=# method=POST>");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
		out.println(successMessage + "<div class=\"starter-template\">");
		out.println(request.getParameter("mobile"));
		out.println("<h1>Your Registered Email is " + email + "</h1>");
		out.println("<h2> If you want to change email Enter email in text box and click on submit button</h1>");
		out.println("Email : <input type=textbox name=email> ");
		out.println("<button type=\"submit\" class=\"btn btn-primary\">Submit</button>");
		out.println("</div></form></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmailBean emailBean = new EmailBean();
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		System.out.println(mobile + "   " + email);
		emailBean.setEmailId(email);
		emailBean.setMobileNo(mobile);
	//	mapper.save(emailBean);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		successMessage = "<div class=\"alert alert-success\" role=\"alert\">\r\n" + 
				"    <strong>Well done!</strong> You successfully Changed Email Address"+ email + mobile +
				"</div>";
		
		out.println(successMessage);
		successMessage = "";
		
		
	}

}
