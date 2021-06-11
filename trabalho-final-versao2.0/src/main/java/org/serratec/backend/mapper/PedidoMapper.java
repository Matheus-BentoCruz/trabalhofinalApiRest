//package org.serratec.backend.mapper;
//
//import org.serratec.backend.dto.PedidoDTO;
//import org.serratec.backend.entity.PedidoEntity;
//import org.springframework.stereotype.Component;
//
//@Component
//public class PedidoMapper {
//
//	public PedidoEntity toEntity(PedidoDTO dto) {
//		PedidoEntity entity = new PedidoEntity();
//		entity.setDataPedido(dto.getDataPedido());
//		entity.setClienteId(dto.getClienteId());
//		entity.setStatus(dto.getStatus());
//		entity.setValorTotal(dto.getValorTotal());
//		entity.setProdutosPedido(dto.getProdutosPedido());
//		return entity;
//	}
//	public PedidoDTO toDto(PedidoEntity cliente) {
//		PedidoDTO dto = new PedidoDTO();
//		dto.setDataPedido(cliente.getDataPedido());
//		dto.setClienteId(cliente.getClienteId());
//		dto.setStatus(cliente.getStatus());
//		dto.setValorTotal(cliente.getValorTotal());
//		dto.setProdutosPedido(cliente.getProdutosPedido());
//		return dto;
//	}
//
//	
//}
