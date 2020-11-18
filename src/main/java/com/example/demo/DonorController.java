package com.example.demo;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DonorController {
    private static final String template = "Hello, %s!!";
    private static  Long cnt;

    @Autowired
    private DonorRepository donorRepository;


    @GetMapping (value = "/donors")
    public List<Donor> getDonor(@RequestParam(value = "name", defaultValue = "XYZ") String name)
    {
         return donorRepository.findAll();
    }

    @RequestMapping(value = "/donors/post",method = RequestMethod.POST)
    public DonorResponse postDonor(@RequestBody Donor donor)
    {
        DonorResponse donorResponse = new DonorResponse();
        donorResponse.setId(donor.getId());
        donorResponse.setMessage("Name:"+donor.getName()+" Blood:"+donor.getBloodGroup());
        donorResponse.setExtra(donor.getContact());
        return donorResponse;
    }

    @RequestMapping(value = "/v1/donors/{bloodGroup}", method = RequestMethod.GET)
    public List<Donor> getDonorByGroup(@PathVariable String bloodGroup)
    {
        return donorRepository.findByBloodGroup(bloodGroup);
    }

    @RequestMapping(value = "/donors",method = RequestMethod.POST)
    public void createDonor(@RequestBody Donor donor)
    {
        donorRepository.save(donor);
    }




}
