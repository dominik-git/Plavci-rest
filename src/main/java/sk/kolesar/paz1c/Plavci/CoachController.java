package sk.kolesar.paz1c.Plavci;



import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.paz.pool2.DAO.CoachesDao;
import ar.paz.pool2.Entities.Coach;
import ar.paz.pool2.Factory.DAOFactory;

@CrossOrigin
@RestController
public class CoachController {
	
	private CoachesDao coachesDao = DAOFactory.INSTANCE.getCoachesDao();
	

	@RequestMapping("/coaches")
	public List<Coach> getUsers() {
		return coachesDao.getAll();
	}
	
	@PostMapping("/coach/login")
	public ResponseEntity<Coach> addUser(@RequestBody Coach coach) {
		Coach coach2 = coachesDao.getCoachByLogin(coach.getLogin(),coach.getPassword());
		if(coach2 == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Coach>(coach2, HttpStatus.CREATED);
	}
	@PutMapping("/coach/changepassword")
	public ResponseEntity<Coach> updateUser(@RequestBody Coach coach) {
		if (coach == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		coachesDao.upgradePass(coach, coach.getPassword());
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
