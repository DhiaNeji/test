package ConsomiTounsi.controllers.accounts;

import ConsomiTounsi.Service.ClientManagerInterface;
import ConsomiTounsi.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ressources/client")
@CrossOrigin(origins = "*")
@RestController
public class ClientRessources {
    @Autowired
    ClientManagerInterface cs;

    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAllEmployees () {
        List<Client> employees = cs.retrieveAllClient();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Client> getEmployeeById (@PathVariable("id") Long id) {
        Client employee = cs.FindClientById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Client> updateEmployee(@RequestBody Client employee) {
        Client updateEmployee = cs.updateClient(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        cs.deleteClientById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
