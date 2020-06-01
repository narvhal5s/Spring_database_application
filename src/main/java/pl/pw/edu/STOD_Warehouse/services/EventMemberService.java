package pl.pw.edu.STOD_Warehouse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pw.edu.STOD_Warehouse.entity.EventMember;

import java.util.List;

@Service
public class EventMemberService {

    @Autowired
    private EventMemberRepository eventMemberRepository;

    public long addSupplier(Long memberId, Long headquarterId) {
        return eventMemberRepository.save(new EventMember(0L, memberId, headquarterId)).getId();
    }

    public long deleteSupplier(Long id) {
        if (eventMemberRepository.findById(id).isPresent()) {
            EventMember toDelete = eventMemberRepository.findById(id).get();
            eventMemberRepository.delete(toDelete);
            return 0L;
        } else {
            return 1L;
        }
    }

    public EventMember getOne(Long id){
        return eventMemberRepository.getOne(id);
    }

    public List<EventMember> getAllSuppliers() {
        return eventMemberRepository.findAll();
    }

}
