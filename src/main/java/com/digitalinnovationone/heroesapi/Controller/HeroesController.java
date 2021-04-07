package com.digitalinnovationone.heroesapi.Controller;
import com.digitalinnovationone.heroesapi.Document.Heroes;
import com.digitalinnovationone.heroesapi.Repository.HeroesRepository;
import com.digitalinnovationone.heroesapi.Service.HeroesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import static com.digitalinnovationone.heroesapi.Constans.HeroesConstant.HEROES_ENDPROINT_LOCAL;

@RestController
@Slf4j
public class HeroesController {
    HeroesService heroesService;
    HeroesRepository heroesRepository;

    private static final org.slf4j.Logger log =
            org.slf4j.LoggerFactory.getLogger(HeroesController.class);

    public HeroesController(HeroesService heroesService, HeroesRepository heroesRepository) {
        this.heroesRepository=heroesRepository;
        this.heroesService=heroesService;
    }

    @GetMapping(HEROES_ENDPROINT_LOCAL)
    public Flux<Heroes> getAllItens() {
    log.info("requesting the list all heroes");
    return heroesService.findAll();

    }
    @GetMapping(HEROES_ENDPROINT_LOCAL+ "/id")
    public Mono <ResponseEntity<Heroes>> findByIdHero(@PathVariable String id) {
        log.info("requesting the here with id {}", id);
        return heroesService.findByIdHero(id)
                .map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(HEROES_ENDPROINT_LOCAL)
    @ResponseStatus(code=HttpStatus.CREATED)
    public Mono <Heroes> createHero(@RequestBody Heroes heroes ) {
        log.info("a new hero was created");
        return heroesService.save(heroes);
    }

    @DeleteMapping(HEROES_ENDPROINT_LOCAL+"/id")
    @ResponseStatus(code = HttpStatus.CONTINUE)
    public Mono <HttpStatus> deletebyIDHero(@PathVariable String id) {
        heroesService.deletebyIDHero(id);
        log.info("Deleting the hero with id {}", id);
        return Mono.just(HttpStatus.NOT_FOUND);
    }
}

