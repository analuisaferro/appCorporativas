package br.cefetrj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.cefetrj.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
