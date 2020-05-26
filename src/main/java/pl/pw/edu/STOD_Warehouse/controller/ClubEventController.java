package pl.pw.edu.STOD_Warehouse.controller;


import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pw.edu.STOD_Warehouse.dto.AddClubEventRequest;
import pl.pw.edu.STOD_Warehouse.entity.ClubEvent;
import pl.pw.edu.STOD_Warehouse.services.ClubEventService;

import javax.validation.Valid;
import java.util.List;

@Log
@CrossOrigin
@RestController
@RequestMapping("/api/clubevent")
public class ClubEventController {

    @Autowired
    private ClubEventService clubEventService;


    @GetMapping
    public ResponseEntity<?> getClubEvent(){
        List<ClubEvent> respons = clubEventService.getAllClubEvents();
        return new ResponseEntity<>( respons, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClubEvent(@PathVariable Long id){
        ClubEvent product = clubEventService.getOne(id);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addClubEvent(@RequestBody @Valid AddClubEventRequest request){
        clubEventService.addClubEvent(request.getName(),request.getHeadquarterId());
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClubEvent(@PathVariable String name){
        clubEventService.deleteClubEvent(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
