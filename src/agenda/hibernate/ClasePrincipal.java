package agenda.hibernate;

import java.util.List;

import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class ClasePrincipal {

	public static void main(String[] args) {
		StandardServiceRegistry s=new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sf=new MetadataSources(s).buildMetadata().buildSessionFactory();
		Session sesion=sf.openSession();
		Transaction t=sesion.beginTransaction();
		
		
		Contacto c=new Contacto("Jorge", "Perez", "jjp@mail.com");
		//sesion.save(p);
		sesion.save(c);
		t.commit();
		/*Para recuperar los contactos:*/
		/*Query q=sesion.createQuery("FROM Contacto");//Query usando JPQL*/
		Query q=sesion.createNamedQuery("consulta_por_nombre").setString("nombre", "Sebeas");//Query usando una NamedQuery (ver clase Contacto)*/
		List<Contacto> lista=q.getResultList();
		System.out.println(lista);
	}

}
