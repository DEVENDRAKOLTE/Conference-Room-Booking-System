package com.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.ConferenceRoom;
@Repository
public interface DatabaseConnetivity extends JpaRepository<ConferenceRoom, Integer>{

}
