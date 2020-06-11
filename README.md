
## Introduzione al Progetto

Di seguito verrà spiegato il funzionamento e la composizione del progetto d'esame denominato "OOP-Project-TwitterTimeline" svolto nel corso di "Programmazione ad Oggetti" A.A.2019/2020. Il programma ha come obiettivo l'analisi della Timeline di Twitter relativa ai post inerenti il terremoto. Questa timeline è estrapolata da un URL e sono stati presi in considerazione solo i dati più caratteristici di ogni tweet. L'utente, tramite apposite richieste, potrà effettuare filtri e statistiche, le statistiche possono essere effettuate sia sull'intera collezione di dati che su una sua parte applicando prima un filtraggio.

[Pre requisiti ed avvio del progetto](https://github.com/FedericaRipani/Progetto-Programmazione-ad-Oggetti#pre-requisiti-ed-avvio-del-progetto)

[Funzionamento del progetto](https://github.com/FedericaRipani/Progetto-Programmazione-ad-Oggetti#funzionamento)

[Struttura del progetto](https://github.com/FedericaRipani/Progetto-Programmazione-ad-Oggetti#struttura)

[Autori](https://github.com/FedericaRipani/Progetto-Programmazione-ad-Oggetti#autori)

## **Pre requisiti ed avvio del progetto**


Per il corretto funzionamento è necessario istallare l'IDE [Eclipse](https://www.eclipse.org/downloads/) con plugin "<u>Spring Tools</u>".

Successivamente, una volta aperto l'ambiente di sviluppo, bisognerà effetttuare i seguenti passaggi:

- Tasto destro nel Package Explorer, e cliccare "Import", poi "Project from GIT (with Smart Import)"

- Copiare nella finestra che si è appena aperta l'[URL del progetto](https://github.com/FedericaRipani/Progetto-Programmazione-ad-Oggetti)

- Una volta importato, basterà selezionare il progetto nel Package Explorer, tasto destro, opzione "Run As" e scegliere "Spring Boot App"

  Il progetto è dunque pronto, difatti apparirà in un console il seguente particolare messaggio di conferma:


```java
			             ----------------------
		                    |**********************|
		                    |*  APPLICATION READY *|
		                    |**********************|
			            ----------------------
```



  

#### **Download**

Nel momento in cui si clicca su `Run as -> Spring Boot App`, automaticamente verrà effettuato il download di una collezione di **tweets**. Ogni elemento presenta molti campi, ma il progetto si basa su una selezione di essi, i più caratteristici:

```json
[
    {
        "name": "data",
        "sourceField": "Data di creazione del twitt",
        "type": "String"
    },
    {
        "name": "idPost",
        "sourceField": "Descrive in modo univoco il post",
        "type": "Integer"
    },
    {
        "name": "textPost",
        "sourceField": "Campo testuale del post",
        "type": "String"
    },
    {
        "name": "idUser",
        "sourceField": "Descrive in modo univoco l'utente",
        "type": "Integer"
    },
    {
        "name": "nameUser",
        "sourceField": "Nome dell'utente",
        "type": "String"
    },
    {
        "name": "numPost",
        "sourceField": "Numero dei tweet di quell'utente",
        "type": "Integer"
    },
    {
        "name": "languagePost",
        "sourceField": "Lingua del twitt",
        "type": "String"
    },
    {
        "name": "userMentions",
        "sourceField": "Descrive gli utenti menzionati",
        "type": "String"
    },
    {
        "name": "hashtag",
        "sourceField": "Descrive gli Hashtag impiegati nel post",
        "type": "String"
    }
]
```

La collezione di json scaricata viene rappresentata, mediante una collezione di oggetti specificatamente creati con i campi d'interesse chiamati `Tweet`, in fase di generazione del server. Ad operazione conclusa il programma da conferma tramite il server, mostrando in console il particolare messaggio sopracitato.

Sarà possibile, d'ora in poi, effettuare delle manipolazioni e ottenere informazioni sul *database*.


## **Funzionamento**


Tramite il Diagramma dei casi d'uso riportato di seguito viene spiegato quali sono le richieste  che il client può effettuare tramite API REST GET.


<img src="https://github.com/FedericaRipani/Progetto-Programmazione-ad-Oggetti/blob/master/Images/Use%20Case%20Diagram.svg" style="zoom: 5%;" style="align: center;"/>


#### Come effettuare le richieste

E' possibile effettuare le seguenti chiamate sia installando un API Testing (ad esempio Postman) che tramite richiesta all' URL http://localhost:8080/.



---

#### Filtri 
I filtri disponibili sono riportati nella seguente tabella:
!!!!!!Verificare che non siano stati invertiti i filtri UpperBound e LowerBound + specificare che del testo si considera la sua lunghezza come parametro!!!!!!
////Metteremo tabella////


#### Statistiche

E' possibile eseguire delle statistiche su un campo.

Il campo può riferirsi a tutta la Timeline di Tweet o ad una scala ridotta, quindi applicando prima un filtro.

(INSERIRE TABELLA)

##### ! TUTTI I DATI RESTITUITI SONO IN FORMATO JSON !
##### Esempio di risposta alla chiamata  http://localhost:8080/stats?field=numPost&filter={"type":"UpperBound","fields":"TextPost","lower":100}.
```
{

  "m": {

​    "Deviazione standard": 69.40997754134797,

​    "Field": "numPost",

​    "Massimo": 499.0,

​    "Media": 26.90909090909091,

​    "Minimo": 0.0,

​    "Sommatoria": 2072.0

  }

}
```

#### HTTP-response

Al fine di rendere il progetto di maggior comprensione all'utente finale,  non sono state create eccezioni personalizzate, se non oltre a quelle già definite nelle apposite librerie bensì sono stati utilizzati dei codici HTTP- response.

Il client invia la richiesta al server, quindi attende la risposta (response). L'obiettivo del server è quindi di interpretare la richiesta del client e restituire una risposta correlata da un codice ben visibile sull' applicazione di testing [Postman](https://www.postman.com/).



## **Struttura**

Il progetto è strutturato con vari package rispettando il pattern architetturale MVC come di seguito dimostrato:

<img src="https://github.com/FedericaRipani/Progetto-Programmazione-ad-Oggetti/blob/master/Images/Package.svg" style="zoom: 5%;" style="align: center;"/>

Per il Class Diagram completo di metodi e relazioni, e per gli altri diagrammi UML, si faccia riferimento a questa [cartella](https://github.com/FedericaRipani/Progetto-Programmazione-ad-Oggetti/tree/master/UML).




## Autori


[**Federica Ripani**](https://twitter.com/RipaniFederica) - S1086993

[**Camilla D'Andrea**](https://twitter.com/CamillaDAndrea2) - S1087888

Studentesse del 2° anno di Ing. Informatica e dell'Automazione presso l'UNIVPM.

Il link rimanda al profilo Twitter creato in occasione dello sviluppo del progetto.
