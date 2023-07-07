package vidal.falcon.ef.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vidal.falcon.ef.entities.ClvfMember;
import vidal.falcon.ef.services.ClvfMemberService;

@CrossOrigin(origins = "https://localhost:4200")
@RestController
@RequestMapping("/api")
public class ClvfMemberController {
    @Autowired
    ClvfMemberService clvfMemberService;

   @PostMapping("/members")
    public ResponseEntity<ClvfMember> createMember(@RequestBody ClvfMember clvfMember) {
        ClvfMember clvfSavedMember = clvfMemberService.clvfSave(clvfMember);
        return new ResponseEntity<ClvfMember>(clvfSavedMember, HttpStatus.CREATED);
    }

    @GetMapping("/members/status/{month}")
    public ResponseEntity<Integer> getMemberPaymentCount(@PathVariable("month") String clvfMonth) {
        Integer clvfCount = clvfMemberService.clvfGetPaymentCount(clvfMonth);
        return new ResponseEntity<Integer>(clvfCount, HttpStatus.OK);
    }
}
