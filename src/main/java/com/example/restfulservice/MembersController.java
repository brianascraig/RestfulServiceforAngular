package com.example.restfulservice;

import com.example.restfulservice.models.Members;
import com.example.restfulservice.repositories.MembersRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/members")
public class MembersController {

    @Autowired
    private MembersRepository repository;
// Get All
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Members> getAllMembers() {
        return repository.findAll();
    }
//Get
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Members getMemberById(@PathVariable("id")ObjectId id) {
        return repository.findBy_id(id);
    }

    //Put
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyMemberById(@PathVariable("id") ObjectId id, @Valid
    @RequestBody Members members) {
        members.set_id(id);
        repository.save(members);
    }


    //Post
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Members createMembers(@Valid @RequestBody Members members) {
        members.set_id(ObjectId.get());
        repository.save(members);
        return members;
    }


    //Delete
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteMember(@PathVariable ObjectId id) {
        repository.delete(repository.findBy_id(id));
    }
}
