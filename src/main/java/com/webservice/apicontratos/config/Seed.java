package com.webservice.apicontratos.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.webservice.apicontratos.entities.State;
import com.webservice.apicontratos.repositories.StateRepository;

@Configuration
public class Seed implements CommandLineRunner {
	@Autowired
	private StateRepository stateRepository;

	@Override
	public void run(String... args) throws Exception {
		if(this.stateRepository.count() == 0) {
			State state1 = new State(null, "Acre", "AC");
			State state2 = new State(null, "Alagoas", "AL");
			State state3 = new State(null, "Amazonas", "AM");
			State state4 = new State(null, "Amapá", "AP");
			State state5 = new State(null, "Bahia", "BA");
			State state6 = new State(null, "Ceará", "CE");
			State state7 = new State(null, "Distrito Federal", "DF");
			State state8 = new State(null, "Espírito Santo", "ES");
			State state9 = new State(null, "Goiás", "GO");
			State state10 = new State(null, "Maranhão", "MA");
			State state11 = new State(null, "Minas Gerais", "MG");
			State state12 = new State(null, "Mato Grosso do Sul", "MS");
			State state13 = new State(null, "Mato Grosso", "MT");
			State state14 = new State(null, "Pará", "PA");
			State state15 = new State(null, "Paraíba", "PB");
			State state16 = new State(null, "Pernambuco", "PE");
			State state17 = new State(null, "Piauí", "PI");
			State state18 = new State(null, "Paraná", "PR");
			State state19 = new State(null, "Rio de Janeiro", "RJ");
			State state20 = new State(null, "Rio Grande do Norte", "RN");
			State state21 = new State(null, "Rondônia", "RO");
			State state22 = new State(null, "Roraima", "RR");
			State state23 = new State(null, "Rio Grande do Sul", "RS");
			State state24 = new State(null, "Santa Catarina", "SC");
			State state25 = new State(null, "Sergipe", "SE");
			State state26 = new State(null, "São Paulo", "SP");
			State state27 = new State(null, "Tocantins", "TO");
			
			this.stateRepository.saveAll(
				Arrays.asList(
					state1,
					state2,
					state3,
					state4,
					state5,
					state6,
					state7,
					state8,
					state9,
					state10,
					state11,
					state12,
					state13,
					state14,
					state15,
					state16,
					state17,
					state18,
					state19,
					state20,
					state21,
					state22,
					state23,
					state24,
					state25,
					state26,
					state27
				)
			);
		}
		else {
			System.out.println("The table states already has records");
		}
		
	}

}
