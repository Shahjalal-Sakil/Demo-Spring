package com.example.demo.api;
import com.example.demo.model.DonorDto;
import com.example.demo.repository.DonorRepository;
import com.example.demo.DonorResponse;
import com.example.demo.entity.Donor;
import com.example.demo.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DonorController {
    private static final String template = "Hello, %s!!";
    private static  Long cnt;


    @Autowired
    private DonorService donorService;


    @GetMapping (value = "/donors")
    public List<DonorDto> getDonors(@RequestParam(value = "name", defaultValue = "XYZ") String name)
    {
         return donorService.getDonors();
    }


    @RequestMapping(value = "/v1/donors/{bloodGroup}", method = RequestMethod.GET)
    public List<DonorDto> getDonorByGroup(@PathVariable String bloodGroup)
    {
        return donorService.getDonorsByBloodGroup(bloodGroup);
    }

    @RequestMapping(value = "/donors",method = RequestMethod.POST)
    public void createDonor(@RequestBody DonorDto donorDto)
    {

        donorService.createDonor(donorDto);
    }

    @RequestMapping(value = "/donors/{id}",method = RequestMethod.GET)
    public DonorDto getDonor(@PathVariable long id){
        return donorService.getDonorById(id);
    }

    @RequestMapping(value = "/donors/{id}",method = RequestMethod.PUT)
    public DonorDto updateDonor(@RequestBody DonorDto donorDto,@PathVariable long id)
    {
        return  donorService.updateDonor(donorDto,id);
    }

    @RequestMapping(value = "/donors/{id}",method = RequestMethod.DELETE)
    public void deleteDonor(@PathVariable long id)
    {
        donorService.deleteDonor(id);
    }







}
