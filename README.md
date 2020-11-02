### Processo e sviluppo software: assignment 1
Per il progetto, è stato utilizzato un programma Java che permette a chi lo utilizza la lettura dei dati da una tabella. Il relational database management system scelto è stato MYSQL. Il programma Java permette una simulazione degli accesi Utente ad un determinato dominio. Il valore della colonna numero_accessi è aggiornato ogni volta che il programma viene eseguito. 

##### Componenti gruppo:
- Andrei G. Taraboi, 829904
- Alice Romagnoli, 829833

##### Fasi della pipeline
1. Build
2. Verify
3. Unit test
4. Integration test
5. Package
6. Release
7. Deploy

### Build
La fase di **Build** è stata realizzata utilizzando il goal *compile* di Maven:
```
mvn compile
```
### Verify
Durante la fase di **Verify**, sono stati utilizzati due plugin maven (Checkstyle e Spotbugs), rispettivamente per eseguire una verifica dello stile del source code e una analisi statica del source code.
Per la fase di Checkstyle non vengono considerati eventuali errori corrispondenti alla Javodoc:
```
mvn -Dmaven.javadoc.skip=true checkstyle:check
```
Per la fase di Spotbugs:
```
mvn spotbugs:check
```

### Unit test
Unit Test è una fase che ha come scopo quello di verificare la corretta esecuzione di un singolo modulo all'interno di un progetto.
In particolare si è scelto di utilizzare una classe java (Utente.java), che funge da Model, per garantire che si interfacci correttamente con il la classe di Test (AppTest). 
