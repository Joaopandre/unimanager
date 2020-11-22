package pt.iade.unimanage.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pt.iade.unimanage.models.Unit;
import pt.iade.unimanage.models.UnitRepository;
import pt.iade.unimanage.models.exceptions.NotFoundException;

@RestController
@RequestMapping(path="/api/units")

public class UnitController {
    private Logger logger = LoggerFactory.getLogger(UnitController.class);
    

@GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
public List<Unit> getUnits() {
    logger.info("Sending all units");
    return UnitRepository.getUnits();
}

@GetMapping(path = "{id}",
produces= MediaType.APPLICATION_JSON_VALUE)
public Unit getUnit(@PathVariable("id") int id) throws NotFoundException{
    logger.info("Sending unit with id "+id);
    Unit unit = UnitRepository.getUnit(id);
    if (unit != null) return unit;
    else throw new NotFoundException(""+id, "Unit", "id");
    }
   

@DeleteMapping(path = "{id}",
produces= MediaType.APPLICATION_JSON_VALUE)
    public Response deleteUnit(@PathVariable("id") int id) {
        logger.info("deleting unit with id "+id);
            if (UnitRepository.deleteUnit(id))
                return new Response(id+" was deleted.",null);
            else
                return new Response(id+" not found.",null);
    }

@PostMapping(path = "",
produces= MediaType.APPLICATION_JSON_VALUE)
public Unit addUnit(@RequestBody Unit unit) {
    logger.info("Adding unit --> " + unit);
    return addUnit(unit);
}

public class Response {
    private String message;
    private Object object;
    public Response(String message, Object object) {
        this.message = message;
        this.object = object;
    }
    public String getMessage() { return message; }
    public Object getObject() { return object; }
}