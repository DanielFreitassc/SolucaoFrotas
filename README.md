# Solução de Frotas
### Em um mundo cada vez mais conectado e dependente de mobilidade, a administração eficiente de frotas de veículos é essencial para empresas de diversos setores. Para simplificar e otimizar esse processo, uma API especializada pode ser uma ferramenta poderosa. Esta API foi desenvolvida com o intuito de oferecer uma solução abrangente para as necessidades de gestão de frotas, fornecendo uma ampla gama de funcionalidades e recursos.

# Cadastro de motorista
```yml
/motorista
```
```json
{
    "nome":"nome do motoristas",
    "sobrenome":"Sobrenome",
    "cpf":"1131321331",
    "categoria":"D"
}
```
# Buscar todos os motorista cadastrados
```yml
/motorista
```
# Buscar apenas um motorista
```yml 
/motorista/1
```
# Atualizar dados do motorista.
```yml 
/motorista/1
```
```json
{
    "nome":"nome do motoristas",
    "sobrenome":"Sobrenome",
    "cpf":"1131321331",
    "categoria":"D"
}
```
# Apagar dados de um motorista.
```yml
/motorista/1
```
# Fazer uma reserva de veiculo 
```yml
/reserva
```
```json
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

# Buscar todas as reservas de veiculos
```yml
/reserva
```
# Buscar por uma reseva especifica 
```yml
/reserva/1
```
# Atualizar dados da reserva 
```yml
/reserva/1
```
```json
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

# Remover uma reserva
```yml
/reserva/1
```
# Cadastar um veiculo 
```yml
/veiculo
```
```json
{
    "placa":"MTX-1224",
    "modelo":"GOL",
    "categoria":"B",
    "ano":"2023",
    "cor":"azul",
    "quilometragem":999,
    "numero_de_chassi":"3323-zzzww32"
}
```
# Buscar todos os veiculos cadastrados
```yml
/veiculo
```
# Buscar um veiculo especifico.
```yml
/veiculo/1
```

#  Atulizar dados de um veiculo 
```yml
/veiculo/1
```
```json
{
    "placa":"MTX-1224",
    "modelo":"GOL",
    "categoria":"B",
    "ano":"2023",
    "cor":"azul",
    "quilometragem":999,
    "numero_de_chassi":"3323-zzzww32"
}
```
# Remover cadastro de um veiculo.
```yml
/veiculo/1
```
# Cadastar uma multa
```yml
/multa
```
```json
{
    "id_multa": 1,
    "veiculo": {
        "id_veiculo": 1
    },
    "multado_em": "2024-03-29T10:15:30",
    "motorista": {
        "id_motorista": 1
    },
    "num_notificacao": "ABC123456",
    "vencimento": "2024-04-15T00:00:00",
    "observacao": "Observação da Multa",
    "local": "Local da Infração",
    "municipio": "Município da Infração",
    "bairro": "Bairro da Infração",
    "logradouro": "Logradouro da Infração",
    "complemento": "Complemento do Endereço da Infração",
    "infracao": "Descrição da Infração",
    "valor": 500.00,
    "recurso": "2024-03-29T10:15:30",
    "situacao": "Pendente",
    "data_pagamento":"2024-03-29T10:15:30",
    "valor_juros": 2,
    "valor_desconto": 2,
    "valor_pago": 2
}
```
# Buscar todas as multas
```yml
/multa
```

# Buscar uma multa especifica 
```yml
/multa/1
```

# Atualizar dados de uma multa especifica 
```yml
/multa/1
```
```json
{
    "id_multa": 1,
    "veiculo": {
        "id_veiculo": 1
    },
    "multado_em": "2024-03-29T10:15:30",
    "motorista": {
        "id_motorista": 1
    },
    "num_notificacao": "ABC123456",
    "vencimento": "2024-04-15T00:00:00",
    "observacao": "Observação da Multa",
    "local": "Local da Infração",
    "municipio": "Município da Infração",
    "bairro": "Bairro da Infração",
    "logradouro": "Logradouro da Infração",
    "complemento": "Complemento do Endereço da Infração",
    "infracao": "Descrição da Infração",
    "valor": 500.00,
    "recurso": "2024-03-29T10:15:30",
    "situacao": "Pendente",
    "data_pagamento":"2024-03-29T10:15:30",
    "valor_juros": 2,
    "valor_desconto": 2,
    "valor_pago": 2
}

```

# Remover cadastro de uma multa especifica 
```yml
/multa/1
```
