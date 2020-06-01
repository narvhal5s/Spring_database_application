package pl.pw.edu.STOD_Warehouse.controller;


import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pw.edu.STOD_Warehouse.dto.AddEventMemberRequest;
import pl.pw.edu.STOD_Warehouse.entity.EventMember;
import pl.pw.edu.STOD_Warehouse.services.EventMemberService;

import javax.validation.Valid;
import java.util.List;

@Log
@CrossOrigin
@RestController
@RequestMapping("/api/eventmember")
public class EventMemberController {

    @Autowired
    private EventMemberService eventMemberService;

    @GetMapping
    public ResponseEntity<?> getSuppliers() {
        List<EventMember> response = eventMemberService.getAllSuppliers();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<?> addSupplier(@RequestBody @Valid AddEventMemberRequest request) {
        eventMemberService.addSupplier(request.getMemberId(), request.getClubeventId());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSupplier(@PathVariable Long id) {
        EventMember supplier = eventMemberService.getOne(id);
        return new ResponseEntity<>(supplier, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSupplier(@PathVariable Long id) {
        long result = eventMemberService.deleteSupplier(id);
        if (result == 0) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
