package com.ana.mspizza.service;

import com.ana.mspizza.dto.request.PizzaDtoRequest;
import com.ana.mspizza.dto.response.PizzaDtoResponse;
import com.ana.mspizza.model.Pizza;
import com.ana.mspizza.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PizzaServiceImpl implements PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;


    @Override
    public void guardarPizza(PizzaDtoRequest pizza) {
        Pizza pizzaModel = new Pizza();
        pizzaModel.setNombrePizza(pizza.getNombrePizzaDto());
        pizzaModel.setDescripcion(pizza.getDescripcionDto());

        pizzaRepository.save(pizzaModel);

    }

    @Override
    public List<PizzaDtoResponse> listarPizzas() {
        List<PizzaDtoResponse> lista = new ArrayList<PizzaDtoResponse>(0);
        PizzaDtoResponse p = null;

        for(Pizza pizza :pizzaRepository.findAll()){
            p = new PizzaDtoResponse();
            p.setIdPizzaDto(pizza.getIdPizza());
            p.setNombrePizzaDto(pizza.getNombrePizza());
            p.setDescripcionDto(pizza.getDescripcion());
            lista.add(p);
        }
        return lista;
    }
}
