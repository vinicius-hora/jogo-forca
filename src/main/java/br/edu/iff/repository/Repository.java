package br.edu.iff.repository;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public interface Repository {

	public long getProximoId();

}
