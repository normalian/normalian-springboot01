package work.normalian.demo.service;

import org.springframework.stereotype.Repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;

import work.normalian.demo.dto.Restaurant;

@Repository
public interface RestaurantRepository extends CosmosRepository<Restaurant, String>{
    Iterable<Restaurant> findByGenre(String genre);
    long countByGenre(String genre);
    //Restaurant findOne(String id, String name);
}
