package com.example.parkview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.parkview.entity.Comment;
import com.example.parkview.entity.Facility;

@Repository
public interface CommentDao extends JpaRepository<Comment, String> {

	//·j´M³]¬Iªº¯d¨¥
	@Query(value=" SELECT * FROM park.comment "
			+ " where factility_name = :facilityName",nativeQuery = true)
	public List<Comment> searchComments(@Param("facilityName") String facilityName);
	
}
