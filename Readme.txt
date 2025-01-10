Por enquanto esse programa registra sempre a consulta
no mesmo paciente e mesmo medico, não mostra os dias disponíveis pra consulta e
nem apresenta erro se houverem mais de uma consulta na mesma hora com o 
mesmo medico, mas futuramente será corrigido esses problemas!

para rodar precisa adicionar o drive "mysql-connector-j-9.1.0.jar"
na biblioteca de referencia da IDE,
rodar o banco de dados "dbconsulta.mwb",
e fazer essas duas inserts: 

INSERT INTO `dbconsulta`.`medico` (`idmedico`, `nome`, `crm`) 
VALUES (1, 'Dr. Pedro Almeida', 'CRM-12345');

INSERT INTO `dbconsulta`.`medico` (`idmedico`, `nome`, `crm`) 
VALUES 
(1, 'Dr. Ricardo Lima', 'CRM-54321');
