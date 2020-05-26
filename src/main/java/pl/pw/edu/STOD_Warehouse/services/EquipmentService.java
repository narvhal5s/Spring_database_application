package pl.pw.edu.STOD_Warehouse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pw.edu.STOD_Warehouse.entity.Equipment;

import java.util.List;

@Service
public class EquipmentService {
    @Autowired
    private EquipmentRepository equipmentRepository;

    public long addEquipment(String name, String year, String headquarter){
        return equipmentRepository.save(new Equipment(0L,name,year,headquarter)).getId();
    }


    public long deleteEquipment(Long id){
        Equipment toDelete = equipmentRepository.findById(id).get();
        equipmentRepository.delete(toDelete);
        return 0L;
    }

    public Equipment getOne(Long id){
        return equipmentRepository.getOne(id);
    }

    public List<Equipment> getAllEquipment(){
        return equipmentRepository.findAll();
    }
}
