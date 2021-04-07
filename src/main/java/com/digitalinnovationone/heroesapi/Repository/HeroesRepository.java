package com.digitalinnovationone.heroesapi.Repository;

import com.digitalinnovationone.heroesapi.Document.Heroes;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;


@EnableScan

public interface HeroesRepository extends CrudRepository<Heroes,String> {

}
