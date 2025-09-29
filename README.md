# **Fatec\_LP\_Atividade\_E1**

Este repositório documenta a atividade "E1: Classes, métodos, atributos e objetos \- parte 1". O projeto explora Programação Orientada a Objetos (POO) em Java, abordando classes, métodos, atributos e objetos, com a adição de **Interfaces Gráficas (GUI)** para interação e um **Sistema de Log em CSV** para persistência dos dados. Contém modelagem UML, um programa para cálculo de média e a implementação de classes inspiradas em música, arte e vídeos.  

## **Descrição das Atividades**

### **1\. Teste de Mesa e Cálculo de Média**

Análise e teste de mesa para 10 cenários diferentes, aplicando uma fórmula complexa para o cálculo da média. Inclui a implementação em Java da classe **MediaFatec**, que encapsula as seis entradas de notas (P1, E1, E2, X, SUB, API) como atributos e utiliza o método **calMedia()** para aplicar a fórmula de cálculo ponderada.

### **2\. Música: Modelagem de Classes**

Modelagem de três classes, cada uma com três atributos e um método, inspiradas em uma música de minha escolha ("Roman Empire Anthem"). As classes modeladas são:

* **Valour:** Focada na coragem e heroísmo (atributos: emotion, action, destination; método: **liftSouls()**).  
* **Honour:** Focada no reconhecimento e glória (atributos: virtude, expressao, mensagem; método: **singPraise()**).  
* **Power:** Focada na linhagem e força imperial (atributos: strength, identity, symbol; método: **declareLineage()**).

Link da música: https://www.google.com/search?q=https://www.youtube.com/watch%3Fv%3DTeCIZLXwkI8%26list%3DRDTeCIZLXwkI8%26start\_radio%3D1

<img width="1593" height="586" alt="Class Music  Roman Impire Anthem" src="https://github.com/user-attachments/assets/c3da46af-72fc-4219-877a-c5dfc0092cf2" />

### **3\. Imagem (Vik Muniz): Modelagem de Classes**

Modelagem de dois conjuntos de classes, cada um com foco em uma obra do artista Vik Muniz.

**Obra 1: "Double Mona Lisa (Peanut butter and jelly)"**

* **Classes:** Material, Canva, MonaLisa.  
* **Foco:** Modelagem dos elementos físicos da recriação da obra (e.g., a classe Material com atributos como name, amount e consistency).

<img width="630" height="470" alt="Double Mona Lisa (Peanut butter and jelly)" src="https://github.com/user-attachments/assets/cf1fbbc8-9cb6-463f-b8f9-70019bbe1e5f" />

<img width="1593" height="563" alt="Diagrama de Classe - Mona Lisa" src="https://github.com/user-attachments/assets/3c88514d-a33a-46b2-b2a5-a9d052d5d8df" />

**Obra 2: "Track Brawl"**

* **Classes:** Local, Fighter, Fight.  
* **Foco:** Modelagem do cenário e dos atores de um evento de luta (e.g., a classe Fighter com atributos name, age e weight, e a classe Local com coordenadas).

<img width="630" height="788" alt="Track brawl" src="https://github.com/user-attachments/assets/459c8b8a-db97-4c19-8942-28cf209d4bd0" />

<img width="1593" height="680" alt="Diagrama de Classe - Track brawl" src="https://github.com/user-attachments/assets/38eeff96-4b86-4fe0-a871-97ff0fcd40fc" />

### **4\. Imagem (Doodle): Modelagem de Classes**

Modelagem de três classes, cada uma com três atributos e **três métodos**, baseadas na imagem Doodle "LinkedIn Top Companies". As classes modelam um ecossistema corporativo:

* **Classes:** Companies, Employee, Vanancy.  
* **Foco:** Demonstração de métodos complexos que alteram o estado do objeto, como Company.hire(), Employee.salaryAdjustment() e Vanancy.advertiseVacancy().

<img width="955" height="566" alt="Doodle - Linkedin Top Companies 2021" src="https://github.com/user-attachments/assets/d22e06fa-1ed2-4154-bd82-3e5d5639c9e4" />

<img width="1593" height="636" alt="Diagrama de Classe - Doodle" src="https://github.com/user-attachments/assets/66a19c80-fd9b-42e0-a69a-3bd0ccab1f43" />

### **5\. Vídeo: Modelagem de Classes**

Modelagem de três classes, cada uma com três atributos e **três métodos**, inspiradas no vídeo "Desafio sob Fogo" (Forged in Fire). As classes representam os elementos chave da competição:

* **Classes:** Blacksmith, Tools, Knife.  
* **Foco:** Modelagem de processos e estados de recursos (e.g., Tools.use() reduz a durabilidade, Blacksmith.forge() inicia um processo, e Knife.cut() testa o produto final).

Link do Vídeo: https://www.youtube.com/watch?v=XB-Vsp7gvYI

<img width="1593" height="716" alt="Diagrama de Classe Video - Desafio sob Fogo" src="https://github.com/user-attachments/assets/50004439-3e01-4685-873e-6134b91955b3" />

### **6\. Implementação em Java**

Código-fonte em Java para todas as classes modeladas nos itens 2 a 5, além da classe de cálculo de média do item 1\. O código foi desenvolvido para exemplificar os conceitos de classes, atributos, métodos e objetos.

### **7\. Interfaces Gráficas (GUI) e Persistência CSV**

Implementação de interfaces gráficas baseadas nas classes dos itens 2 a 5, utilizando o JavaFX. O objetivo é permitir a interação do usuário com os objetos POO por meio de uma GUI.

**Funcionalidade Principal:**

* As interfaces gráficas leem os dados de entrada para os atributos.  
* Um botão de ação (como "Calcular", "Contratar" ou "Lutar") é adicionado.  
* Ao ser acionado, o botão **instancia o objeto** com os dados fornecidos e **registra o evento** em um arquivo de log CSV (output.csv) por meio da biblioteca **Apache Commons CSV**. Isso demonstra a persistência e o rastreamento das interações do sistema.

### **Tecnologias Utilizadas**

* Java: Linguagem de programação para a implementação das classes.  
* JavaFX: Framework para a criação das Interfaces Gráficas (GUI).  
* **Apache Commons CSV (ou OpenCSV):** Biblioteca utilizada para o registro persistente de dados.  
* Maven: Gerenciador de dependências do projeto.  
* Lucidchart: Ferramenta utilizada para a criação dos diagramas UML.

#### **Data de Conclusão**

**Atividade Inicial (Modelagem e Classes):** 09 de setembro de 2025

**Nova Atividade (GUI e CSV):** 30 de setembro de 2025
