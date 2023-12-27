package com.example.parkview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.parkview.entity.Restaurant;


@Repository
public interface RestaurantDao extends JpaRepository<Restaurant, String> {

	public List<Restaurant> findByName(String name);

	public List<Restaurant> findByPublished(boolean published);

	//¦³published·j´M
	@Query("SELECT e FROM Restaurant e WHERE "
			+ "e.name LIKE %:name% AND e.region LIKE %:region% AND e.published = :published")
	List<Restaurant> findThreeCondetionRestaurants(@Param("name") String name, @Param("region") String region,
			@Param("published") boolean published);

	//µLpublished·j´M
	@Query("SELECT e FROM Restaurant e WHERE " + "e.name LIKE %:name% AND e.region LIKE %:region% ")
	List<Restaurant> findTwoCondetionRestaurants(@Param("name") String name, @Param("region") String region);

}
