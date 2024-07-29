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

# Buscar todas as reservas de veiculos
```
/reserva
```
# Buscar por uma reseva especifica 
```
/reserva/1
```
# Atualizar dados da reserva 
```
/reserva/1
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

# Remover uma reserva
```
/reserva/1
```
# Cadastar um veiculo 
```
/veiculo
```
```
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
```
/veiculo
```
# Buscar um veiculo especifico.
```
/veiculo/1
```

#  Atulizar dados de um veiculo 
```
/veiculo/1
```
```
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
```
/veiculo/1
```
# Cadastar uma multa
```
/multa
```
```
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
```
/multa
```

# Buscar uma multa especifica 
```
/multa/1
```

# Atualizar dados de uma multa especifica 
```
/multa/1
```
```
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
```
/multa/1
```
