package com.ana.mspizza.service;

import com.ana.mspizza.dto.request.PizzaDtoRequest;
import com.ana.mspizza.dto.response.PizzaDtoResponse;

import java.util.List;

public interface PizzaService {

    public void guardarPizza(PizzaDtoRequest pizza);
    public List<PizzaDtoResponse> listarPizzas();
}
