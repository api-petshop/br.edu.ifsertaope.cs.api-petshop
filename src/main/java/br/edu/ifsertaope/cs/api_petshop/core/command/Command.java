package br.edu.ifsertaope.cs.api_petshop.core.command;

public interface Command<T> {
    T execute();
}
