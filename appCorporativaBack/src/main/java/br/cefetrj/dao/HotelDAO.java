package br.cefetrj.dao;

import br.cefetrj.model.Hotel;

public class HotelDAO extends GenericDAO<Hotel> {

    public HotelDAO() {
        super(Hotel.class);
    }

}