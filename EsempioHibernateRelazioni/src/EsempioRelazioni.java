import hibernateUtil.HibernateUtil;
import model.*;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class EsempioRelazioni {

	public static void main(String[] args) {

		Persona p1= new Persona();
		p1.setNome("aaaaa");
		p1.setCognome("AAAAA");
		Computer c1 =new Computer();
		c1.setModello("Hp");
//		Computer c2= new Computer();
//		c2.setModello("Asus");
		p1.addComputer(c1);
//		p1.addComputer(c2);
//		c1.addPersona(p1);
//		c2.addPersona(p1);
		
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();

		session.save(c1);
//		session.save(c2);
		session.save(p1);
		 
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}

	}

}
