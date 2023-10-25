package com.mx.tec.people.cotroller;

import com.mx.tec.people.dto.PeopleVO;
import com.mx.tec.people.entity.PeopleEntity;
import com.mx.tec.people.exception.PeopleDataException;
import com.mx.tec.people.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/people")
public class PeopleController {

    private PeopleService peopleService;

    @Autowired
    public PeopleController( PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hola munndo";
    }

    @PostMapping(value = "",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public @ResponseBody PeopleVO created(@RequestBody PeopleVO peopleEntity) {
        return this.peopleService.crated(peopleEntity);
    }

    @GetMapping()
    public List<PeopleVO> getPeopleAll() throws PeopleDataException {
        return this.peopleService.getPeopleAll();
    }

    @GetMapping("/{id}")
    public PeopleVO getPeopleById(@PathVariable Integer id) throws  PeopleDataException{

        return this.peopleService.getPeopleById(id);
    }
    @PutMapping
    public PeopleVO updatePeople(@RequestBody PeopleVO peopleEntity) throws  PeopleDataException{
        return this.peopleService.updatePeople(peopleEntity);
    }
    @DeleteMapping("/{id}")
    public PeopleVO deletePeople(@PathVariable Integer id) throws PeopleDataException{
       return this.peopleService.deletePeople(id);
    }

}
