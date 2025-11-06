package br.cefetrj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.cefetrj.model.Quarto;

public interface QuartoRepository extends JpaRepository<Quarto, Long> {
}
