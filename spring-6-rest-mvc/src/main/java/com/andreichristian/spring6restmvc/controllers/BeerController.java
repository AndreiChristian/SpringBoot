package com.andreichristian.spring6restmvc.controllers;

import com.andreichristian.spring6restmvc.models.Beer;
import com.andreichristian.spring6restmvc.services.BeerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/beers")
public class BeerController {
    private final BeerService beerService;

    @PutMapping("{beerId}")
    public ResponseEntity updateById( @PathVariable("beerId") UUID beerId,  @RequestBody Beer beer){

        beerService.updateById(beerId,beer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    //@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity handlePOST( @RequestBody Beer beer){
        Beer savedBeer = beerService.saveNewBeer(beer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","api/v1/beers/"+savedBeer.getId().toString());

        return new ResponseEntity(headers,HttpStatus.CREATED);

    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Beer> listBeers() {
        return beerService.listBeers();
    }

    @RequestMapping(value = "{beerId}", method = RequestMethod.GET)
    public Beer getBeerById( @PathVariable("beerId") UUID beerId) {
        return beerService.getBeerById(beerId);
    }

}
