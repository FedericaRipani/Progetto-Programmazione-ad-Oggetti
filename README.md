
## Introduzione al Progetto

Di seguito verranno illustrati il funzionamento e la struttura del progetto d'esame denominato "OOP-Project-TwitterTimeline", svolto nel corso di "Programmazione ad Oggetti" A.A.2019/2020. Il progetto ha come obiettivo l'analisi della Timeline di Twitter relativa ai post inerenti il terremoto. Questa timeline è estrapolata da un [URL](https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/search/tweets.json?q=terremoto&count=100) e sono stati presi in considerazione solo i dati più caratteristici di ogni tweet. L'utente, tramite apposite richieste, potrà effettuare filtri e statistiche, le statistiche possono essere effettuate sia sull'intera collezione di dati che su una sua parte applicando prima un filtraggio.

---

## INDICE

[Pre requisiti ed avvio del progetto](https://github.com/FedericaRipani/Progetto-Programmazione-ad-Oggetti#pre-requisiti-ed-avvio-del-progetto)

[Funzionamento del progetto](https://github.com/FedericaRipani/Progetto-Programmazione-ad-Oggetti#funzionamento)

[Struttura del progetto](https://github.com/FedericaRipani/Progetto-Programmazione-ad-Oggetti#struttura)

[Test](https://github.com/FedericaRipani/Progetto-Programmazione-ad-Oggetti#test)

[JARs e linguaggio Java](https://github.com/FedericaRipani/Progetto-Programmazione-ad-Oggetti#jars-e-linguaggio-java)

[Autori e JavaDoc](https://github.com/FedericaRipani/Progetto-Programmazione-ad-Oggetti#autori)

---

## **Pre requisiti ed avvio del progetto**

Il progetto è stato sviluppato utilizzando l'IDE [Eclipse](https://www.eclipse.org/downloads/) con plugin "<u>Spring Tools</u>".

Se si utilizzasse il nostro stesso IDE, una volta aperto l'ambiente di sviluppo, bisognerà effettuare i seguenti passaggi:

- Tasto destro nel `Package Explorer -> Import -> Project from GIT (with Smart Import)`;

- Copiare nella finestra che si è appena aperta l'[URL del progetto](https://github.com/FedericaRipani/Progetto-Programmazione-ad-Oggetti);

- Una volta importato, basterà selezionare il progetto nel `Package Explorer`, tasto destro, opzione `Run As -> Spring Boot App`;

  Il progetto è dunque pronto, difatti apparirà in console il seguente messaggio di conferma:


```java
			             ----------------------
		                    |**********************|
		                    |*  APPLICATION READY *|
		                    |**********************|
			             ----------------------
```



  

#### **Download**

Nel momento in cui si clicca su `Run as -> Spring Boot App`, automaticamente verrà effettuato il download di una collezione di **tweets**. Ogni tweet presenta moltissimi campi, per il progetto sono stati scelti i più caratteristici:

```json
[
    {
        "name": "data",
        "sourceField": "Data di creazione del tweet",
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
        "sourceField": "Lingua del tweet",
        "type": "String"
    },
    {
        "name": "userMentions",
        "sourceField": "Descrive gli utenti menzionati",
        "type": "String"
    },
    {
        "name": "hashtag",
        "sourceField": "Descrive gli Hashtag utilizzati nel post",
        "type": "String"
    }
]
```

La collezione di json verrà scaricata e rappresentata come insieme di `Tweet` in fase di generazione del server, con il nome *database*. 
Ad operazione conclusa il programma mostra in console il particolare messaggio sopracitato.

Sarà possibile, d'ora in poi, effettuare delle manipolazioni e ottenere informazioni sul *database*.


---


## **Funzionamento**


Il seguente Diagramma dei casi d'uso mostra le richieste che il client può effettuare tramite API REST GET.


<img src="https://github.com/FedericaRipani/Progetto-Programmazione-ad-Oggetti/blob/master/Images/Use%20Case%20Diagram.svg" style="zoom: 5%;" style="align: center;"/>


#### Come effettuare le richieste

E' possibile effettuare le seguenti chiamate sia installando un API Testing (ad esempio Postman) sia tramite richiesta all' URL http://localhost:8080/.

##### ! TUTTI I DATI RESTITUITI SONO IN FORMATO JSON !


| DESTINAZIONI                                                 | DESCRIZIONE                                                  |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| `/getTweets`                                                 | Visualizza tutti i Tweet (rappresentati dai parametri piu importanti) presenti nel Dataset |
| `/getMeta`                                                   | Visualizza tutti gli alias utilizzati per la descrizione del tweet |
| `/filtering?filter={"type":"nome_filtro","fields":"campo_esaminato","parametro":valore}` | Visualizza la collezione di Tweet filtrata in base a parametri formato JSON |
| `/stats?field=campo&filter{"type":"nome_filtro","fields":"campo_esaminato","parametro":valore}` | Visualizza le statistiche su un campo dei Tweet. Il dataset  di provenienza può essere intero o parziale, applicando prima un filtro |


---

### Filtri 
I filtri disponibili e alcuni esempi di chiamata sono riportati nella seguente tabella:
|        Filtro        |                         Descrizione                          | Tipo dei field applicabili |              Esempio del filtro in formato JSON              |
| :------------------: | :----------------------------------------------------------: | :------------------------: | :----------------------------------------------------------: |
|      UpperBound      | Cerca i valori del campo scelto (**fields**) minori della soglia **upper**. |          Numerici          |     {"type":"UpperBound","fields":"TextPost","upper":200}      |
| UpperBound and equal | DescrizioneDescrizioneCerca i valori del campo scelto (**fields**) minori o uguali della soglia **upper**. |          Numerici          |     {"type":"UpperBoundE","fields":"TextPost","upper":200}     |
|      LowerBound      | Cerca i valori del campo scelto (**fields**) maggiori della soglia **lower**. |          Numerici          |     {"type":"LowerBound","fields":"TextPost","lower":40}     |
| LowerBound and equal | Cerca i valori del campo scelto (**fields**) maggiori o uguali della soglia **lower**. |          Numerici          |    {"type":"LowerBoundE","field":"TextPost","lower":40}     |
|       Included       | Cerca i valori del campo scelto (**fields**)nei valori compresi tra la soglia **lower** e **upper**. |          Numerici          | {"type":"Included","fields":"TextPost","lower":20,"upper":500} |
|  Included and equal  | Cerca i valori del campo scelto (**fields**) nei valori compresi o uguali tra la soglia **lower** e **upper**. |          Numerici          | {"type":"IncludedE","fields":"numPost","lower":20,"upper":500} |
|        Search        | Cerca le stringhe del campo scelto (**fields**) uguali ad una determinata parola (**value**) |          Stringhe          | {"type":"Search", "fields": "Hashtag","value"= "terremoto"}  |

> I filtri di tipo numerico sono applicabili ai campi: `TextPost` e `numPost`. In questo caso per il `TextPost` si fa riferimento alla sua lunghezza.

> I filtri di tipo stringa sono applicabili ai campi: `TextPost`, `NameUser` e `Hashtag`.


---

### Statistiche

E' possibile eseguire delle statistiche su un campo.

La statistica può riferirsi a tutta la Timeline di Tweet o ad una parte di essa, applicando prima un filtro.
|        Statistica         |                         Descrizione                          |       Tipo        |
| :-----------------------: | :----------------------------------------------------------: | :---------------: |
|       Minimo (Min)        | Dato il campo (**field**), calcola il minimo valore in quel campo |  Numerico (int)   |
|       Massimo (Max)       | Dato il campo (**field**), calcola il massimo valore in quel campo |  Numerico (int)   |
|        Media (Avg)        | Dato il campo (**field**), calcola la media dei valori di quel campo | Numerico (double) |
|        Somma (Sum)        | Dato il campo (**field**), calcola la somma di tutti i valori di quel campo |  Numerico (int)   |
| Deviazione Standard (Std) | Dato il campo (**field**), calcola la dev.standard di tutti i valori di quel campo | Numerico (double) |
|     Occorrrenze (Occ)     |      Dato il campo (**field**),  calcola le occorrenze       |      Stringa      |


> Le statistiche numeriche sono applicabili sui campi: `idPost`, `idUser` e `numPost`;
>
> *Esempio di chiamata per le statistiche numeriche: http://localhost:8080/stats?field=numPost.*

> Le statistiche di tipo stringa sono applicabili sui campi: `data`, `textPost`, `nameUser` e  `languagePost`;
>
> *Esempio di chiamata per le statistiche di tipo stringa: http://localhost:8080/stats?field=nameUser.*



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

##### Esempio di risposta parziale alla chiamata   http://localhost:8080/getTweets
La risposta è parziale perchè, per ragioni di spazio, ne è stata inserita solo una parte.


```
 {
        "data": "Thu Jun 11 09:11:55 +0000 2020",
        "idPost": -677994489,
        "textPost": "RT @JorgeGlas: \"Un pueblo empoderado abraza a sus hermanos cuando lo necesitan y así abrazamos a nuestros hermanos víctimas del terremoto d…",
        "idUser": 356867567,
        "nameUser": "mariaordofer",
        "numPost": 8,
        "languagePost": "es",
        "userMentions": [
            "JorgeGlas"
        ],
        "hashtag": []
    },
    {
        "data": "Thu Jun 11 09:11:49 +0000 2020",
        "idPost": 852815872,
        "textPost": "#nowPlaying on Surf Rock Radio: Terremoto Stomp [2zQ] by Didi Wray! Listen live on https://t.co/7PJjXKxOwv… https://t.co/qAT8kBdMMp",
        "idUser": 1558614182,
        "nameUser": "SurfRockRadio",
        "numPost": 19,
        "languagePost": "en",
        "userMentions": [],
        "hashtag": [
            "nowPlaying"
        ]
    },
```
---
### HTTP-response

Al fine di rendere il progetto di maggior comprensione per l'utente,  non sono state create eccezioni personalizzate, se non oltre a quelle già definite nelle apposite librerie, bensì sono stati utilizzati i seguenti codici HTTP- response:


|   Codice Riposta    |           Chiamate possibili            |                         Significato                          |
| :-----------------: | :-------------------------------------: | :----------------------------------------------------------: |
|     `200 - OK`      | `getMeta, getTweets,  filtering, stats` | L'operazione è andata a buon fine, il risultato prodotto è quello aspettato. |
| `400 - BAD REQUEST` |           `filtering, stats`            | Il filtro o il field immesso non è stato implementato oppure è incorretto. |
| `204 - NO CONTENT`  |               `filtering`                | L'operazione è andata a buon fine ma non ha prodotto risultato, la selezione è vuota. |
|  `404 - NOT FOUND`  |                  `stats`                 | Dopo aver richiesto le statistiche è stato immesso un filtro o un field incorretto. |


Il client invia la richiesta al server, quindi attende la risposta (response). Il compito del server è quello di interpretare la richiesta del client e restituire una risposta correlata da un codice ben visibile sull' applicazione di testing (ad esempio [Postman](https://www.postman.com/)) come mostra la seguente immagine.


<img src="https://github.com/FedericaRipani/Progetto-Programmazione-ad-Oggetti/blob/master/Images/PostmanCodiceHttp.JPG" style="zoom: 5%;" style="align: center;"/>

---

## **Struttura**

Il progetto è diviso in package, rispettando il pattern architetturale MVC, come mostrato di seguito:

<img src="https://github.com/FedericaRipani/Progetto-Programmazione-ad-Oggetti/blob/master/Images/Package.svg" style="zoom: 5%;" style="align: center;"/>

Per il Class Diagram completo di metodi e relazioni, e per gli altri diagrammi UML, si faccia riferimento alla cartella denominata [UML](https://github.com/FedericaRipani/Progetto-Programmazione-ad-Oggetti/tree/master/UML) presente nella repository.

---

## Test

Successivamente alla fase di sviluppo del progetto sono stati creati dei test appositi, utilizzando JUnit5, per verificare la correttezza di alcuni metodi, eccezioni e HTTPStatuses.

- `TestException` : Controlla la generazione di un' eccezione causata da un JSONObject errato;

- `TestMetodsStats` : Controlla il risultato dato dalle funzioni che calcolano le statistiche;

- `TestHttpStatuses` : Controlla che il codice Http generato sia corretto;


---

## **JARs e linguaggio java**

Sono stati utilizzati i seguenti JARs, definiti come dipendenze Maven nel [pom.xml](https://github.com/FedericaRipani/Progetto-Programmazione-ad-Oggetti/blob/master/OOP-Poject-TwitterTimeline/pom.xml) del progetto :
- [Apache common I/O](https://mvnrepository.com/artifact/commons-io/commons-io)
- [Apache HttpClient](https://mvnrepository.com/artifact/org.apache.httpcomponents/httpclient)
- [JUnit Jupiter API](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api)
- [Json](https://mvnrepository.com/artifact/org.json/json)

Sono state implementate le seguenti strutture dati:
- `ArrayList<>`
- `HashMap<,>`

---

## Autori e JavaDoc


[**Federica Ripani**](https://twitter.com/RipaniFederica) - S1086993

[**Camilla D'Andrea**](https://twitter.com/CamillaDAndrea2) - S1087888

Studentesse del 2° anno di Ing. Informatica e dell'Automazione presso l'UNIVPM.

Il link rimanda al profilo Twitter creato in occasione dello sviluppo del progetto.

Il progetto è stato svolto in completa collaborazione e, ove possibile, sono state fatte opportune suddivisioni dei compiti.
Per le suddivisioni specifiche si rimanda alla consultazione degli `@author` nel [JavaDoc](https://federicaripani.github.io/Progetto-Programmazione-ad-Oggetti/).
