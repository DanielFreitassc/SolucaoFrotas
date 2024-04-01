# Solução de Frotas
### Em um mundo cada vez mais conectado e dependente de mobilidade, a administração eficiente de frotas de veículos é essencial para empresas de diversos setores. Para simplificar e otimizar esse processo, uma API especializada pode ser uma ferramenta poderosa. Esta API foi desenvolvida com o intuito de oferecer uma solução abrangente para as necessidades de gestão de frotas, fornecendo uma ampla gama de funcionalidades e recursos.

# Cadastro de motorista
``` 
/motorista
```
```
{
    "nome":"nome do motoristas",
    "sobrenome":"Sobrenome",
    "cpf":"1131321331",
    "categoria":"D"
}
```
# Buscar todos os motorista cadastrados
``` 
/motorista
```
# Buscar apenas um motorista
``` 
/motorista/1
```
# Atualizar dados do motorista.
``` 
/motorista/1
```
```
{
    "nome":"nome do motoristas",
    "sobrenome":"Sobrenome",
    "cpf":"1131321331",
    "categoria":"D"
}
```
# Apagar dados de um motorista.
```
/motorista/1
```
# Fazer uma reserva de veiculo 
```
/reserva
```
```
{
    "reservado": "2023-01-01T00:00:00",
    "saida": "2023-01-01T00:00:00",
    "chegada": "2023-01-01T00:00:00",
    "veiculo": {
        "id_veiculo": 1
    },
    "motorista": {
        "id_motorista": 1
    },
    "organograma": "/organograma/organograma",
    "finalidade": "Finalidade tal tal tal",
    "observacoes": "observação sobre o veiculo ou algo mais"
}

```
