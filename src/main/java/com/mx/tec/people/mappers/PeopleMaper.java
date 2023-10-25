package com.mx.tec.people.mappers;

import com.mx.tec.people.dto.PeopleVO;
import com.mx.tec.people.entity.PeopleEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PeopleMaper {

    public PeopleEntity convertPeopleVOToPeopleEntity(PeopleVO peopleVO) {

        if (peopleVO == null) {
            return null;
        }
        PeopleEntity peopleEntity = new PeopleEntity();
        peopleEntity.setId(peopleVO.getId());
        peopleEntity.setName(peopleVO.getName());
        peopleEntity.setLastNameFather(peopleVO.getLastNameFather());
        peopleEntity.setLastNameMother(peopleVO.getLastNameMother());
        peopleEntity.setGender(peopleVO.getGender());
        peopleEntity.setAge(peopleVO.getAge());

        return peopleEntity;
    }

    public PeopleVO convertPeopleEntityToPeopleVO(PeopleEntity peopleEntity) {

        if (peopleEntity == null) {
            return null;
        }
        PeopleVO peopleVO = new PeopleVO();
        peopleVO.setId(peopleEntity.getId());
        peopleVO.setName(peopleEntity.getName());
        peopleVO.setLastNameFather(peopleEntity.getLastNameFather());
        peopleVO.setLastNameMother(peopleEntity.getLastNameMother());
        peopleVO.setGender(peopleEntity.getGender());
        peopleVO.setAge(peopleEntity.getAge());

        return peopleVO;
    }

    public List<PeopleVO> convertPeopleEntityListToPeopleVOList(List<PeopleEntity> peopleEntityList) {
        if (peopleEntityList == null) {
            return null;
        }

        List<PeopleVO> peopleVOList = peopleEntityList
                .stream()
                .map(peopleEntity -> convertPeopleEntityToPeopleVO(peopleEntity))
                .collect(Collectors.toList());
        return peopleVOList;
    }


}
