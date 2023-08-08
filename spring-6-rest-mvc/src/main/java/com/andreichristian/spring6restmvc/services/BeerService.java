package com.andreichristian.spring6restmvc.services;

import com.andreichristian.spring6restmvc.models.Beer;

import java.util.UUID;

public interface BeerService {

    Beer getBeerById(UUID id);
}
