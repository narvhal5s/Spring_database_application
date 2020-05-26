package pl.pw.edu.STOD_Warehouse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pw.edu.STOD_Warehouse.entity.ClubEvent;

import java.util.List;

@Service
public class ClubEventService {
    @Autowired
    private ClubEventRepository clubEventRepository;

    public long addClubEvent(String name, String headquarterId){
        return clubEventRepository.save(new ClubEvent(0L,name,headquarterId)).getId();
    }

    public long deleteClubEvent(String name){
        ClubEvent toDelete = clubEventRepository.findByName(name);
        clubEventRepository.delete(toDelete);
        return 0L;
    }

    public ClubEvent getOne(Long id){
        return clubEventRepository.getOne(id);
    }

    public List<ClubEvent> getAllClubEvents(){
        return clubEventRepository.findAll();
    }

}
