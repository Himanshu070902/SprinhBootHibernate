package in.sp.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.sp.main.entity.User;

@SpringBootApplication
public class SbHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbHibernateApplication.class, args);

		Configuration cfg = new Configuration();

		cfg.configure("/in/sp/main/config/hibernate.cfg.xml");

		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		User user = session.get(User.class, 2);

		System.out.println(user.getName() + " " + user.getEmail());
//		Transaction transaction = session.beginTransaction();
		session.close();
		sf.close();
	}

}
