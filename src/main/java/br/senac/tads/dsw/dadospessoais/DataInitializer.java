package br.senac.tads.dsw.dadospessoais;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.senac.tads.dsw.dadospessoais.entidade.ConhecimentoEntity;
import br.senac.tads.dsw.dadospessoais.entidade.PessoaEntity;
import br.senac.tads.dsw.dadospessoais.repositorio.PessoaRepository;
import jakarta.annotation.PostConstruct;

@Component
public class DataInitializer {

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostConstruct
    public void init() {
        ConhecimentoEntity java = new ConhecimentoEntity();
        java.setNome("java");

        ConhecimentoEntity docker = new ConhecimentoEntity();
        docker.setNome("Docker");

        PessoaEntity pessoa = new PessoaEntity();
        pessoa.setUsername("joao");
        pessoa.setNome("João Silva");
        pessoa.setEmail("joao@email.com");
        pessoa.setSenha("123456");
        pessoa.setDataNascimento(LocalDate.now());
        pessoa.getConhecimentos().add(java);
        pessoa.getConhecimentos().add(docker);
        pessoaRepository.save(pessoa);

        pessoaRepository.save(pessoa);
    }
}
