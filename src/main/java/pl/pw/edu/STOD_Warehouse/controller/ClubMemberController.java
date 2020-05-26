package pl.pw.edu.STOD_Warehouse.controller;


import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pw.edu.STOD_Warehouse.dto.AddClubMemberRequest;
import pl.pw.edu.STOD_Warehouse.entity.ClubMember;
import pl.pw.edu.STOD_Warehouse.services.ClubMemberService;
import javax.validation.Valid;
import java.util.List;

@Log
@CrossOrigin
@RestController
@RequestMapping("/api/clubmember")
public class ClubMemberController {

    @Autowired
    private ClubMemberService clubMemberService;

    @GetMapping
    public ResponseEntity<?> getClubMember(){
        List<ClubMember> respons = clubMemberService.getAllClubMembers();
        return new ResponseEntity<>( respons, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClubMember(@PathVariable Long id){
        ClubMember order =  clubMemberService.getOne(id);
        return new ResponseEntity<>( order,HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<?> addClubMember(@RequestBody @Valid AddClubMemberRequest request){
        clubMemberService.addClubMember(request.getFirstName(),request.getLastName(),request.getAddress(),request.getCity(),request.getPhoneNumber(),request.getEmail(),request.getHeadquarterId(),request.getContributionPaid());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClubMember(@PathVariable Long id){
        clubMemberService.deleteClubMember(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
