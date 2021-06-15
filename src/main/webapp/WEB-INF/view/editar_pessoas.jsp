<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
            <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

                <!DOCTYPE html>
                <html lang="pt-br">

                <head>
                    <meta charset="UTF-8">
                    <meta http-equiv="X-UA-Compatible" content="IE=edge">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Editar Pessoas</title>
                </head>

                <body>
                    <h1>Você está editando uma pessoa heh</h1>
                    <form:form action="/editar/${pessoa.id}/" method="POST" modelAttribute="nPessoa">
                        <spring:bind path="nome">
                            <div class="${status.error ? 'has-error' : ''}">
                                <form:input id="nome_input" type="text" path="nome" placeholder="Nome" value="${pessoa.nome}" />
                                <form:errors path="nome"></form:errors>
                            </div>
                        </spring:bind>
                        <spring:bind path="email">
                            <div class="${status.error ? 'has-error' : ''}">
                                <form:input id="email_input" type="text" path="email" placeholder="Email" value="${pessoa.email}" />
                                <form:errors path="email"></form:errors>
                            </div>
                        </spring:bind>
                        <spring:bind path="telefone">
                            <div class="${status.error ? 'has-error' : ''}">
                                <form:input id="telefone_input" type="text" path="telefone" placeholder="Telefone" value="${pessoa.telefone}" />
                                <form:errors path="telefone"></form:errors>
                            </div>
                        </spring:bind>
                        <spring:bind path="cep">
                            <div class="${status.error ? 'has-error' : ''}">
                                <form:input id="cep_input" type="text" path="cep" placeholder="CEP" value="${pessoa.cep}" />
                                <form:errors path="cep"></form:errors>
                            </div>
                        </spring:bind>
                        <form:button type="submit">Alterar</form:button>
                    </form:form>
                </body>

                </html>