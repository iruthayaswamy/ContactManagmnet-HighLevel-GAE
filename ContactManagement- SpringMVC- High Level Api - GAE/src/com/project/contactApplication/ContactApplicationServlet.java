package com.project.contactApplication;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.contactApplication.ContactJDO;
import com.project.contactApplication.PMF;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

@Controller
public class ContactApplicationServlet {
	 
	@RequestMapping(value = "/Add.ds", method = RequestMethod.POST)
	public void doPost(  HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, JSONException
	   {
		
		resp.setContentType("text/html");
		  PrintWriter out=resp.getWriter();
		  
		  String record=req.getParameter("data");
		  
		  JSONObject obj = new JSONObject(record);

		 
		 String FirstName= obj.get("Fname").toString();
		 String LastName= obj.get("Lname").toString();
		 String Gender= obj.get("Gender").toString();
		 String Phone= obj.get("Phone").toString();
		 String Mail= obj.get("Mail").toString();
		 String Address= obj.get("Address").toString();


		  
			ContactJDO c = new ContactJDO();
		  PersistenceManager pm = PMF.get().getPersistenceManager();
		  
		   
		   Query q = pm.newQuery(ContactJDO.class);
	       q.setFilter("PhoneNumber == '" + Phone + "'");
			List<ContactJDO> results = (List<ContactJDO>) q.execute(Phone);
			try
			  {
				if(results.isEmpty())
				{
					 
					  c.setFirstName(FirstName);
					  c.setLastName(LastName);
					  c.setGender(Gender);
					  c.setPhoneNumber(Phone);
					  c.setEmail(Mail);
					  c.setAddress(Address);
					 
					  
					  pm.makePersistent(c);

					  out.println("Contact Added");


			    }
			    else
			    {
			    	out.println("Contact Already exist");

				}
				
		  }
		  
		  finally{
			  
			  q.closeAll();
			
			}

	   }
	
	@RequestMapping(value = "Search.ds", method = RequestMethod.POST)
	public void SearchClass(HttpServletRequest req, HttpServletResponse resp)throws IOException , ServletException, JSONException {

		resp.setContentType("text/html");
		  PrintWriter out=resp.getWriter();
		  
		  String record=req.getParameter("data");
		  
		  JSONObject obj = new JSONObject(record);

		 
		 String search= obj.get("Search").toString();
		 
			PersistenceManager pm = PMF.get().getPersistenceManager();

//			Query q = pm.newQuery(ContactJDO.class);
			
			Query q = pm.newQuery("SELECT FROM " + ContactJDO.class.getName() + " WHERE FirstName =='"+search+"'");

//			q.setFilter(("FirstName == '" + search + "'"));
					

			List<ContactJDO> results = (List<ContactJDO>) q.execute(search);
			
			try{
				
				if(!results.isEmpty()){
					
					out.println("Contact found");
			    }  
			    else{  
			    	out.println("No Contact found");  
				}
			}
			finally{
				
				q.closeAll();
			}

		  
    	
    }
	
	@RequestMapping(value = "Update.ds", method = RequestMethod.POST)
	public void UpdateClass(HttpServletRequest req, HttpServletResponse resp)throws IOException , ServletException, JSONException {

		resp.setContentType("text/html");
		  PrintWriter out=resp.getWriter();
		  
String record=req.getParameter("data");
		  
		  JSONObject obj = new JSONObject(record);

		 
		 String FirstName= obj.get("Fname").toString();
		 String LastName= obj.get("Lname").toString();
		 String Gender= obj.get("Gender").toString();
		 String Phone= obj.get("Phone").toString();
		 String Mail= obj.get("Mail").toString();
		 String Address= obj.get("Address").toString();

		 
			PersistenceManager pm = PMF.get().getPersistenceManager();

			Query q = pm.newQuery(ContactJDO.class);

			q.setFilter("PhoneNumber == '" + Phone + "'");
					

			List<ContactJDO> results = (List<ContactJDO>) q.execute(Phone);
			
			
			
			try{
				
				if(!results.isEmpty()){
					
					  ContactJDO c= pm.getObjectById(ContactJDO.class,results.get(0).getKey());
					  c.setFirstName(FirstName);
					  c.setLastName(LastName);
					  c.setGender(Gender);
					  c.setPhoneNumber(Phone);
					  c.setEmail(Mail);
					  c.setAddress(Address);
					  pm.makePersistent(c);
					  out.println("Contact Updated ");
			    }  
			    else{  
			    	out.println("No Contact found");
			       
				}
			}
			finally{
				
				q.closeAll();
			}
    	
    }
	
	@RequestMapping(value = "delete.ds", method = RequestMethod.POST)
	public void DeleteClass(HttpServletRequest req, HttpServletResponse resp)throws IOException , ServletException, JSONException {

			resp.setContentType("text/html");
			PrintWriter out=resp.getWriter();
		  
			String record=req.getParameter("data");
			JSONObject obj = new JSONObject(record);

			String delete= obj.get("Delete").toString();
		 
			PersistenceManager pm = PMF.get().getPersistenceManager();

			Query q = pm.newQuery(ContactJDO.class);

			q.setFilter("PhoneNumber == '" + delete + "'");
					

			List<ContactJDO> results = (List<ContactJDO>) q.execute(delete);
			
			
			
			try{
				
				if(!results.isEmpty()){
					
					ContactJDO c= pm.getObjectById(ContactJDO.class,results.get(0).getKey()); 
					 
					  pm.deletePersistent(c);
					  out.println("Contact Deleted ");
			    }  
			    else{  
			    	
			    	out.println("No Contact found ");
			       
				}
			}
			finally{
				
				q.closeAll();
			}

    	
    }
	
    	
    }