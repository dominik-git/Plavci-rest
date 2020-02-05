package sk.kolesar.paz1c.Plavci;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;

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
import org.springframework.web.bind.annotation.RestController;

import ar.paz.pool2.DAO.TrainingGroupsDao;
import ar.paz.pool2.Entities.Coach;
import ar.paz.pool2.Entities.Training_group;
import ar.paz.pool2.Factory.DAOFactory;

@CrossOrigin
@RestController
public class TrainingGroupController {

	private TrainingGroupsDao trainingGroupsDao = DAOFactory.INSTANCE.getTrainingGroupsDao();

	@RequestMapping("/getGroups")
	public List<Training_group> getGroups() {
		return trainingGroupsDao.getAll();
	}

	@RequestMapping("/getGroupsByCoach/{id}")
	public List<Training_group> getGroupsByCoach(@PathVariable int id) {
		return trainingGroupsDao.getGroupsByCoach(id);
	}
	
	@PostMapping("/createGroup")
	public ResponseEntity<Coach> addUser(@RequestBody Training_group training_group) {
	 trainingGroupsDao.add(training_group.getName(), training_group.getCoach_id());
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteGroup/{id}")
	public ResponseEntity<Long> deletePost(@PathVariable Long id) {
		trainingGroupsDao.delete(id);
		return new ResponseEntity<>(id, HttpStatus.OK);
	}

}
