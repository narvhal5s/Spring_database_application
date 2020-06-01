package pl.pw.edu.STOD_Warehouse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pw.edu.STOD_Warehouse.entity.Headquarter;

import java.util.List;

@Service
public class HeadquarterService {
    @Autowired
    private HeadquarterRepository headquarterRepository;

    public long addHeadquarter(String address, String city, String phoneNumber){
        return headquarterRepository.save(new Headquarter(0L,address,city,phoneNumber)).getId();
    }


    public long deleteHeadquarter(Long id){
        if(headquarterRepository.findById(id).isPresent()) {
            Headquarter toDelete = headquarterRepository.findById(id).get();
            headquarterRepository.delete(toDelete);
            return 0L;
        } else  {
            return 1L;
        }
    }

    public Headquarter getOne(Long id){
        return headquarterRepository.getOne(id);
    }

    public List<Headquarter> getAllHeadquarters(){
        return headquarterRepository.findAll();
    }
}
