package pl.pw.edu.STOD_Warehouse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pw.edu.STOD_Warehouse.entity.ClubMember;

import java.util.List;

@Service
public class ClubMemberService {
    @Autowired
    private ClubMemberRepository clubMemberRepository;

    public long addClubMember(String firstname, String lastname, String address, String city, String phoneNumber, String email, Long headquarterId, Boolean contributionPaid){
        return clubMemberRepository.save(new ClubMember(0L,firstname,lastname,address, city, phoneNumber, email,headquarterId,contributionPaid)).getId();
    }


    public long deleteClubMember(Long id){
        ClubMember toDelete = clubMemberRepository.findById(id).get();
        clubMemberRepository.delete(toDelete);
        return 0L;
    }

    public ClubMember getOne(Long id){
        return clubMemberRepository.getOne(id);
    }

    public List<ClubMember> getAllClubMembers(){
        return clubMemberRepository.findAll();
    }
}
