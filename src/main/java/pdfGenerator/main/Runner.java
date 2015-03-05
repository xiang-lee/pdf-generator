package pdfGenerator.main;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pdfGenerator.model.User;
import pdfGenerator.util.HtmlGenerator;
import pdfGenerator.util.PdfGenerator;


public class Runner {
	
    public static void main( String[] args ) throws Exception {
    	String outputFilePath = "C:\\PDFSample\\samplePDF.pdf";
    	String tampleFile = "freemarker_template.html";
    	
    	
    	Map<String,Object> variables = new HashMap<String,Object>();
    	
    	//set example of user list
    	List<User> users = createUserList();
    	//you can put any variables you want, so that you can use them in freemarker template
    	variables.put("users",users);
        String htmlStr = HtmlGenerator.generate(tampleFile, variables);        
        OutputStream out = new FileOutputStream(outputFilePath);   
        PdfGenerator.generate(htmlStr, out);  
    }
    
    private static List<User> createUserList() {
    	User user1 = createUser(1, "Luffy", 12);
    	User user2 = createUser(2, "Jonh", 34);
    	User user3 = createUser(3, "Tom", 26);
    	List<User> users = new ArrayList<User>();
    	users.add(user1);
    	users.add(user2);
    	users.add(user3);
    	return users;
    }
    
    private static User createUser(long id, String username, int age) {
    	User user = new User();
    	user.setId(id);
    	user.setUsername(username);
    	user.setAge(age);
    	return user;
    }
}
