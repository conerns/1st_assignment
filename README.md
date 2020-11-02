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
In particolare si è scelto di utilizzare una classe java (Utente.java), che funge da Model, per garantire che si interfacci correttamente con la classe di Test (AppTest). 
```
mvn test
```

### Integration Test
Integration Test è una fase che ha come scopo quello di testare il coordinamento tra due o più componenti, in paricolare tra un database MySQL e 
l'applicazione. Per poter eseguire correttamente la sola fase di Integration Test è state necessario apportare delle modifiche al *pom.xml*.
Modifiche file pom:
```
    <executions>
        <execution>
            <goals>
                <goal>integration-test</goal>
                <goal>verify</goal>
            </goals>
        </execution>
    </executions>
```
Per poi eseguire il comando:
```
mvn test-compile failsafe:integration-test failsafe:verify
```

### Package
Durante la fase di Package, il codice compilato viene compresso all'interno di un unico file, nel nostro caso un .jar, per permetterne una distribuizione più facile. Inoltre viene utilizzato DskipTests per non eseguire i test.
```
mvn -DskipTests clean package
```
Il file prodotto viene collocato all'interno della cartella impostata alla voce *paths*.

### Release 
Durante la fase di Release è stato utilizzato Docker per creare automaticamente un'immagine mediante il *Dockerfile*. 
La fase di Release utilizza il GitLab Container Registry per la creazione dell'immagine. 
```
- docker login -u $CI_REGISTRY_USER -p $CI_JOB_TOKEN $CI_REGISTRY
- docker build -t $CI_REGISTRY_IMAGE:$CI_COMMIT_REF_SLUG .
- docker push $CI_REGISTRY_IMAGE:$CI_COMMIT_REF_SLUG
```

### Deploy
Per la fase di Deploy è stato utilizzato Azure per la creazione di una macchina virtuale. Il collegamento e la condivisione dei file avviene trammite la ssh key.

## Problemi 
Durante la fase di Deploy, avendo comunque effettuato la verifica in locale della ssh-key tramite:
```
ssh -i <path-to-key> host@domain
```
Durante l'esecuzione in remoto la fase di ssh genera un errore. 
```
Permission denied (publickey,password).
```
Cercando di correggere, l'errore sembra sia dovuto ai permessi collegati al file contenente la chiave privata.
