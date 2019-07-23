package com.github.sejoung.repositories;

import com.github.sejoung.domain.MeetingRoom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRoomRepository extends CrudRepository<MeetingRoom, Long> {

}
