package mayven_project.model;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import mayven_project.model.Student;

public class Test {
	
	

	public static void main(String[] args) {

		
		Configuration cfg = new Configuration();
		cfg.configure("hiber.cfg.xml");
		
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		
		Scanner sc=new Scanner(System.in);
		
		boolean exit=false;
		
		while(!exit){
			
		
			
			System.out.println("Enter the name:-");
			String name=sc.nextLine();
			
			System.out.println("Enter the address:-");
			String address=sc.nextLine();
			
			
			Student s=new Student(name,address);
			
            System.out.print("Add student? (y/n): ");
            String choice = sc.nextLine().toLowerCase();

            if (!choice.equals("y")) {
                exit = true;
                
                
                
                Transaction t = session.beginTransaction();
    			
    			session.save(s);

    			t.commit();
    			session.close();
            }
			
		}
		
		
		
		
		
		System.out.println("Data inserted");
		
		
	}


}
