package work.normalian.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import work.normalian.demo.dto.Restaurant;
import work.normalian.demo.service.RestaurantRepository;

// https://qiita.com/MizoguchiKenji/items/2a041f3a3eb13274e55c
// https://stackoverflow.com/questions/41719142/how-to-return-a-set-of-objects-with-spring-boot
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantController.class);

    @Autowired
    private RestaurantRepository repository;

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Restaurant>> findAll(){
        final Iterable<Restaurant> result = repository.findAll();
        for (Restaurant restaurant : result) {
            LOGGER.info("RestaurantController#findAll = " + restaurant.getName());
        }
        return new ResponseEntity<Iterable<Restaurant>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/{genre}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Restaurant>> findByGenre(@PathVariable(required = true) String genre){
        final Iterable<Restaurant> result = repository.findByGenre(genre);
        final List<Restaurant> ret = new ArrayList<>();
        LOGGER.info("RestaurantController#findByGenre parameter = " + genre);
        for (Restaurant restaurant : result) {
            LOGGER.info("RestaurantController#findByGenre = " + restaurant.getName());
            Restaurant r1 = new Restaurant();
            r1.setId(restaurant.getId());
            r1.setGenre(restaurant.getGenre());
            r1.setDescription(restaurant.getDescription());
            r1.setGmapUrl(restaurant.getGmapUrl());
            r1.setName(restaurant.getName());
            ret.add(r1);
        }
        return new ResponseEntity<Iterable<Restaurant>>(ret, HttpStatus.OK);
    }
}
