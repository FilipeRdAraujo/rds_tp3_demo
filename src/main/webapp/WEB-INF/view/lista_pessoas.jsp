<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
            <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

                <!DOCTYPE html>
                <html lang="en">

                <head>
                    <meta charset="UTF-8">
                    <meta http-equiv="X-UA-Compatible" content="IE=edge">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Lista Pessoas</title>
                </head>

                <body>
                    <h1>Cadastro de pessoa ;D wink</h1>
                    <form:form action="/cadastrar" method="POST" modelAttribute="nPessoa" enctype="multipart/form-data">
                        <div>
                            <div>
                                <input id="image_input" type="file" name="file"/>
                            </div>
                        </div>
                        <spring:bind path="nome">
                            <div class="${status.error ? 'has-error' : ''}">
                                <form:input id="nome_input" type="text" path="nome" placeholder="Nome" />
                                <form:errors path="nome"></form:errors>
                            </div>
                        </spring:bind>
                        <spring:bind path="email">
                            <div class="${status.error ? 'has-error' : ''}">
                                <form:input id="email_input" type="text" path="email" placeholder="Email" />
                                <form:errors path="email"></form:errors>
                            </div>
                        </spring:bind>
                        <spring:bind path="telefone">
                            <div class="${status.error ? 'has-error' : ''}">
                                <form:input id="telefone_input" type="text" path="telefone" placeholder="Telefone" />
                                <form:errors path="telefone"></form:errors>
                            </div>
                        </spring:bind>
                        <spring:bind path="cep">
                            <div class="${status.error ? 'has-error' : ''}">
                                <form:input id="cep_input" type="text" path="cep" placeholder="CEP" />
                                <form:errors path="cep"></form:errors>
                            </div>
                        </spring:bind>
                        <form:button type="submit">Cadastrar</form:button>
                    </form:form>

                    <h1>Lista de pessoas</h1>
                    <table>
                        <c:forEach items="${pessoas}" var="pessoa">
                            <tr>
                                <td>
                                    <img src="#" alt="${pessoa.nome}-image">
                                </td>
                                <td>
                                    ${pessoa.nome}
                                </td>
                                <td><a href="/editar/${pessoa.id}"><button>Editar</button></a></td>
                                <td><a href="/deletar/${pessoa.id}"><button>Deletar</button></a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </body>

                </html>