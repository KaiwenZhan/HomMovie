package com.cinema.business.entities.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cinema.business.entities.Schedule;


@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, Integer>  {
    @Query(value = "select * from Schedule", nativeQuery = true)
    public List<Schedule> findAll();

    @Query(value = "select * from Schedule where UserId = ?1", nativeQuery = true)
    public Schedule findByCustomerId(final Integer id);

    @Query(value = "select * from Schedule where CinemaId = ?1", nativeQuery = true)
    public Schedule findByCinemaId(final Integer id);
    

}
