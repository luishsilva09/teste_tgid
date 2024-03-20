### Cliente:
#### Atributos:
- Nome
- CPF
- Saldo
#### Métodos:
- RealizarDeposito(valor)
- RealizarSaque(valor)
### Empresa:
#### Atributos:
- Nome
- CNPJ
- Saldo
- Taxa de Sistema
#### Métodos:
- RealizarDepositoCliente(cliente, valor)
- RealizarSaqueCliente(cliente, valor)
- NotificarCliente(cliente, mensagem)
- EnviarCallback(mensagem)

## Funcionalidades:
- Validação de CPF e CNPJ: Implementar funções para validar CPF e CNPJ.

- Taxa de Sistema: Ao realizar transações, a taxa de sistema deve ser deduzida do saldo da empresa.

- Depósitos e Saques: As empresas podem realizar depósitos e saques para os clientes, desde que tenham saldo suficiente.

- Notificações: Após cada transação, o cliente deve ser notificado. Isso pode ser feito por e-mail, SMS ou qualquer outro método de notificação.

- Callback: Após cada transação, a empresa deve receber um callback informando sobre a transação. Isso pode ser simulado usando um serviço como webhook.site.