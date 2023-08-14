package com.andreichristian.spring6restmvc.services;

import com.andreichristian.spring6restmvc.models.Beer;

import java.util.List;
import java.util.UUID;

public interface BeerService {

    List<Beer> listBeers();

    Beer getBeerById(UUID id);

    Beer saveNewBeer(Beer beer);

    void updateById(UUID beerId, Beer beer);
}
