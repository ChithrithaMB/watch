package com.example.demo.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.watch.Watch;
@Repository
public interface WatchRepo extends JpaRepository<Watch, Long>{

}
