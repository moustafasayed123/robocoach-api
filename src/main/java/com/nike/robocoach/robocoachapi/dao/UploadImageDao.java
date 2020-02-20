package com.nike.robocoach.robocoachapi.dao;

import com.nike.robocoach.robocoachapi.model.ActivityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadImageDao extends JpaRepository<ActivityModel, Long> {

}
