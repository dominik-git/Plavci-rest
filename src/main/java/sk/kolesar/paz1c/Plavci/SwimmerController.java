package sk.kolesar.paz1c.Plavci;

import org.springframework.web.bind.annotation.RestController;

import ar.paz.pool2.DAO.SwimmersDao;
import ar.paz.pool2.Entities.Swimmer;
import ar.paz.pool2.Factory.DAOFactory;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@RestController
public class SwimmerController {

	private SwimmersDao swimmersDao = DAOFactory.INSTANCE.getSwimmersDao();

	@RequestMapping("/getAll")
	public List<Swimmer> getGroups() {
		return swimmersDao.getAll();
	}

	@RequestMapping("/getSwimmersByGroupId/{id}")
	public List<Swimmer> getGroupsByCoach(@PathVariable int id) {
		return swimmersDao.getSwimmerByGroup(id);
	}

	@PostMapping("/createSwimmer")
	public ResponseEntity<Swimmer> addSwimmer(@RequestBody Swimmer swimmer) {
		if (swimmer == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		swimmersDao.addswimmer(swimmer);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteSwimmer/{id}")
	public ResponseEntity<Integer> deleteSwimmer(@PathVariable int id) {
		if (id == -1) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		swimmersDao.deleteswimmer(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/editSwimmer")
	public ResponseEntity<Swimmer> updateSwimmer(@RequestBody Swimmer swimmer) {
		if (swimmer.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		swimmersDao.edit(swimmer);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
