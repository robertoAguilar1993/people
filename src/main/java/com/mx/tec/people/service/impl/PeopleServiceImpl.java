package com.mx.tec.people.service.impl;

import com.mx.tec.people.dto.PeopleVO;
import com.mx.tec.people.entity.PeopleEntity;
import com.mx.tec.people.exception.BusinessException;
import com.mx.tec.people.exception.PeopleDataException;
import com.mx.tec.people.exception.RecordNotFoundException;
import com.mx.tec.people.mappers.PeopleMaper;
import com.mx.tec.people.repository.PeopleRepository;
import com.mx.tec.people.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service("peopleService")
public class PeopleServiceImpl implements PeopleService {

    private PeopleRepository peopleRepository;
    private PeopleMaper peopleMaper;

    private static final List<String> GENERS = Arrays.asList("F", "H");

    @Autowired
    public PeopleServiceImpl(PeopleRepository peopleRepository, PeopleMaper peopleMaper) {
        this.peopleRepository = peopleRepository;
        this.peopleMaper = peopleMaper;
    }

    @Override
    public PeopleVO crated(PeopleVO people) throws  PeopleDataException{

        if(people.getAge() == null || people.getAge().equals(0)){
            throw new BusinessException("Edad no permitida", "Guardar la informacion", "Error data");
        }

        if(!GENERS.contains(people.getGender())){
            throw new BusinessException("Error en  G", "guardar infirmacion", "Error data");
        }

        var peopleEntity = this.peopleMaper.convertPeopleVOToPeopleEntity(people);
        var peopleVO = this.peopleMaper.convertPeopleEntityToPeopleVO(this.peopleRepository.save(peopleEntity));

        return peopleVO;
    }

    @Override
    public List<PeopleVO> getPeopleAll() throws PeopleDataException {
        var results = this.peopleRepository.findAll();
        if(results == null || results.size() == 0){
            throw new RecordNotFoundException("No hay informacion", "Consulta de personas", "Data no found");
        }
        return this.peopleMaper.convertPeopleEntityListToPeopleVOList(results);
    }

    @Override
    public PeopleVO getPeopleById(Integer id) throws PeopleDataException {
        var people= this.peopleRepository.findById(id);
        if (people.isEmpty()){
            throw new RecordNotFoundException("No exuste informacion","Fallo en la consulta", "Data not found");
        }
        var peopleVO = this.peopleMaper.convertPeopleEntityToPeopleVO(people.get());

        return peopleVO;
    }

    @Override
    public PeopleVO updatePeople(PeopleVO peopleEntity) throws PeopleDataException {
        getPeopleById(peopleEntity.getId());
        var peopleEntityConvert = this.peopleMaper.convertPeopleVOToPeopleEntity(peopleEntity);
        var peopleVO = this.peopleMaper.convertPeopleEntityToPeopleVO(this.peopleRepository.save(peopleEntityConvert));

        return peopleVO;
    }

    @Override
    public PeopleVO deletePeople(Integer id) throws PeopleDataException{
        var people=this.peopleRepository.findById(id);
        if (people.isPresent()){
            this.peopleRepository.delete(people.get());
            var peopleVO = this.peopleMaper.convertPeopleEntityToPeopleVO(people.get());
            return peopleVO;
        }
        throw new RecordNotFoundException("No existe informacion", "Fallo en la consulta", "Data not found");
    }


}
