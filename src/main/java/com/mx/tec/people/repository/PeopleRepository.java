package com.mx.tec.people.repository;

import com.mx.tec.people.entity.PeopleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<PeopleEntity, Integer> {
}
