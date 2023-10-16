package com.betrybe.agrix.controllers.dto;

/**
 * Classe estabelece um padrão de resposta da aplicação para a requisição.
 *
 * @param message mensagem da resposta da aplicação
 * @param data dados da resposta da aplicação
 * @param <T> Tipo genérico dos dados da resposta
 */
public record ResponseDto<T>(String message, T data) {}
