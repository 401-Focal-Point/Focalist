package com.focalpoint.Focalist.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
   @Query(value = "SELECT * FROM task u ORDER BY u.utc_time ASC", nativeQuery = true)
   List<Task> findAllOrderByUtcTime();
}
