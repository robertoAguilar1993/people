package com.mx.tec.people.service;

import com.mx.tec.people.dto.PeopleVO;
import com.mx.tec.people.entity.PeopleEntity;
import com.mx.tec.people.exception.PeopleDataException;

import java.util.List;

public interface PeopleService {

    PeopleVO crated(PeopleVO people);

    List<PeopleVO> getPeopleAll() throws PeopleDataException;

    PeopleVO getPeopleById(Integer id) throws  PeopleDataException;

    PeopleVO updatePeople(PeopleVO peopleEntity) throws PeopleDataException;

    PeopleVO deletePeople(Integer id) throws PeopleDataException;


}
