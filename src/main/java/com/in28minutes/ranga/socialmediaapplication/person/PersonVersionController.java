package com.in28minutes.ranga.socialmediaapplication.person;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersionController {
    //uri versoning
    @GetMapping(path = "/person/v1")
    public PersonV1 getPersonV1URI(){
       return new PersonV1("Bob Charlie");
    }
    @GetMapping(path = "/person/v2")
    public PersonV2 getPersonV2URI(){
        return new PersonV2(new Name("Bob","Charlie"));
    }
   //param versioning
    @GetMapping(path = "/person",params = "version1")
    public PersonV1 getPersonV1Param(){
        return new PersonV1("Bob Charlie");
    }
    @GetMapping(path = "/person",params = "version2")
    public PersonV2 getPersonV2Param(){
        return new PersonV2(new Name("Bob","Charlie"));
    }
    //header versioning
    @GetMapping(path = "/person",headers = "X-API-VERSION=1")
    public PersonV1 getPersonV1Header(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person",headers = "X-API-VERSION=2")
    public PersonV2 getPersonV2Header(){
        return new PersonV2(new Name("Bob","Charlie"));
    }

    //Content negotiation or Accept header versioning
    @GetMapping(path = "/person",produces ="application/vnd.company.app-v1+json" )
    public PersonV1 getPersonV1ContentNegotiation(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person",produces ="application/vnd.company.app-v2+json" )
    public PersonV2 getPersonV2ContentNegotiation(){
        return new PersonV2(new Name("Bob","Charlie"));
    }

}
