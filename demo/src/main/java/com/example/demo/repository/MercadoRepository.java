package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.param.MercadoParam;
import com.example.demo.dto.request.MercadoRequest;

public class MercadoRepository {

	List<MercadoRequest> listMercados = constructList();
	
	public List<MercadoRequest> getListMercados() {
		return listMercados;
	}
	
	public List<MercadoRequest> constructList() {
		MercadoRequest mercado1 = new MercadoRequest();
		MercadoRequest mercado2 = new MercadoRequest();
		
		mercado1.setId("1");
		mercado1.setNome("Supermercado Bastos");
		mercado1.setRazaoSocial("Supermercado Bastos");
		mercado1.setCNPJ("17.716.149/0001-74");
		mercado1.setEndereco("Rua dos Filos, Nº 20, Paruru, Ibiuna SP");
		mercado1.setEmail("bastos@bastos.com.br");
		mercado1.setNumeroFilial("0001");
		mercado1.setTelefone("15-3289-1458");
		
		mercado2.setId("2");
		mercado2.setNome("Supermercado Ibiúna");
		mercado2.setRazaoSocial("Supermercado Ibiúna");
		mercado2.setCNPJ("28.962.120/0001-99");
		mercado2.setEndereco("Rua das Rosas, Nº 20, Centro, Ibiuna SP");
		mercado2.setEmail("contato@supermercadoibiuna.com.br");
		mercado2.setNumeroFilial("0001");
		mercado2.setTelefone("15-3289-1457");
		
		List<MercadoRequest> mercados = new ArrayList<MercadoRequest>();
		mercados.add(mercado1);
		mercados.add(mercado2);
		
		return mercados;
	}
	
	public MercadoRequest findById(String id) {
		MercadoRequest mercado = new MercadoRequest();
		List<MercadoRequest> list = this.listMercados;
		
		for (MercadoRequest mercadoRequest : list) {
			if(mercadoRequest.getId().equals(id)) {
				return mercadoRequest;
			}
		}
		
		return mercado;
	}
	
	public MercadoRequest findByName(String nome) {
		MercadoRequest mercado = new MercadoRequest();
		List<MercadoRequest> list = this.listMercados;
		
		for (MercadoRequest mercadoRequest : list) {
			if(mercadoRequest.getNome().trim().toLowerCase().contains(nome) 
					&& nome != null 
					&& !nome.equals("")) {
				return mercadoRequest;
			}
		}
		
		return mercado;
	}
	
	public void addMercado(MercadoParam mercadoParam) {
		MercadoRequest mercadoRequest = new MercadoRequest();
		mercadoRequest.setId(mercadoParam.getId());
		mercadoRequest.setNome(mercadoParam.getNome());
		mercadoRequest.setRazaoSocial(mercadoParam.getRazaoSocial());
		mercadoRequest.setCNPJ(mercadoParam.getCNPJ());
		mercadoRequest.setEndereco(mercadoParam.getEndereco());
		mercadoRequest.setEmail(mercadoParam.getEmail());
		mercadoRequest.setNumeroFilial(mercadoParam.getNumeroFilial());
		mercadoRequest.setTelefone(mercadoParam.getTelefone());
		
		this.listMercados.add(mercadoRequest);
	}
	
	public void updateMercado(MercadoRequest mercadoRequest, MercadoParam mercadoParam) {
		mercadoRequest.setNome(mercadoParam.getNome());
		mercadoRequest.setRazaoSocial(mercadoParam.getRazaoSocial());
		mercadoRequest.setCNPJ(mercadoParam.getCNPJ());
		mercadoRequest.setEndereco(mercadoParam.getEndereco());
		mercadoRequest.setEmail(mercadoParam.getEmail());
		mercadoRequest.setNumeroFilial(mercadoParam.getNumeroFilial());
		mercadoRequest.setTelefone(mercadoParam.getTelefone());
	}
	
	public void deleteMarcado(MercadoRequest mercado) {
		this.getListMercados().remove(mercado);
	}

}
