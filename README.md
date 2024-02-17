Boa boite.

Estou tentando cadastrar um item com essa Post: http://localhost:8084/api/CadastrarNovoAparelho

Adicionando o seguinte json:

{
    "modelo": "14 Pro Max",
    "marca": "IPHONE",
    "valor": 5900
}

Mas ainda que esteja como permitAll, o postman me devolve 401.


O mesmo não acontece com os GET's :  http://localhost:8084/api/todosAparelhos e http://localhost:8084/api/aparelhoPorId/436b90bc-dc9e-4324-bb8c-d21ce4ad7267
