package sk.kolesar.paz1c.Plavci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import ar.paz.pool2.DAO.CoachesDao;
import ar.paz.pool2.Entities.Coach;
import ar.paz.pool2.Factory.DAOFactory;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {	
    	   SpringApplication.run(App.class, args);
    }
}
