package com.example.demo.api;
import com.example.demo.model.DonorDto;
import com.example.demo.repository.DonorRepository;
import com.example.demo.DonorResponse;
import com.example.demo.entity.Donor;
import com.example.demo.service.DonorService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Api("/donor")
public class DonorController {
    private static final String template = "Hello, %s!!";
    private static  Long cnt;


    @Autowired
    private DonorService donorService;


    @GetMapping (value = "/donors")
    @ApiOperation(httpMethod = "GET",value = "Get All Donors",notes = "Retrieving a list of all donors",response = DonorDto[].class)
    @ApiResponse(code = 200,message = "Success",response = DonorDto[].class)
    public List<DonorDto> getDonors(@RequestParam(value = "name", defaultValue = "XYZ") String name)
    {
         return donorService.getDonors();
    }


    @RequestMapping(value = "/v1/donors/{bloodGroup}", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET",value = "Find Donor by Blood Group",notes = "Multiple donors with given blood  returned")
    @ApiResponse(code = 200,message = "Success",response = DonorDto[].class)
    public List<DonorDto> getDonorByGroup(@ApiParam(value="Donors are filtered by this",required = true) @PathVariable String bloodGroup)
    {
        return donorService.getDonorsByBloodGroup(bloodGroup);
    }

    @RequestMapping(value = "/donors",method = RequestMethod.POST)
    @ApiOperation(httpMethod = "POST",value = "Creating Donor",notes = "Creating a new Donor")
    public void createDonor(@ApiParam(name="donor",value = "new donor",required = true)@RequestBody DonorDto donorDto)
    {

        donorService.createDonor(donorDto);
    }

    @RequestMapping(value = "/donors/{id}",method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET",value = "Find Donor",notes = "Find donor of specific identifier")
    public DonorDto getDonor(@ApiParam(name = "id",value = "id of donor which you want",required = true)@PathVariable long id){
        return donorService.getDonorById(id);
    }

    @RequestMapping(value = "/donors/{id}",method = RequestMethod.PUT)
    @ApiOperation(httpMethod = "PUT",value = "Update donor",notes = "Updating an existing donor")
    public void updateDonor(
            @ApiParam(required = true,name = "id",value = "id of donor you wanted to update")@PathVariable long id,
            @ApiParam(required = true,name="donor",value = "updated donor") @RequestBody DonorDto donorDto)
    {


        donorService.updateDonor(donorDto,id);
    }

    @RequestMapping(value = "/donors/{id}",method = RequestMethod.DELETE)
    @ApiOperation(httpMethod = "DELETE",value = "Delete donor",notes = "delete donor specified by id")
    public void deleteDonor(@ApiParam(required = true,name = "id",value = "id of donor you wanted to delete")@PathVariable long id)
    {
        donorService.deleteDonor(id);
    }







}
