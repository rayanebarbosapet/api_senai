package com.api_senai.api.entities;

import lombok.Data;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "Enderecos")
public class Endereco {
    @Id
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String localidade; //cidade
    private String uf;

    public static Endereco getEnderecoByCep(String cep){
        Endereco endereco = new Endereco();

        //Mandar o cep para o viaCep
        HttpGet request = new HttpGet("https://viacep.com.br/ws/"+ cep +"/json/");

        try(
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            CloseableHttpResponse response = httpClient.execute(request);
        ) {
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);
            System.out.println(result);

            Gson gson = new Gson();
            endereco = gson.fromJson(result, Endereco.class);
            endereco.setComplemento(null);
            System.out.println(endereco);

        } catch (Exception e){
            e.printStackTrace();
        }

        //Tratar a resposta do via cep

        //montar o meu Endereco endereco

        return endereco;
    }
}
