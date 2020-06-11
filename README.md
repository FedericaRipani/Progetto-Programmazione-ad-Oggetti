
## Introduzione al Progetto

Di seguito verrà spiegato il funzionamento e la composizione del progetto d'esame denominato "OOP-Project-TwitterTimeline" svolto nel corso di "Programmazione ad Oggetti" A.A.2019/2020. Il programma ha come obiettivo l'analisi della Timeline di Twitter relativa ai post inerenti il terremoto. Questa timeline è estrapolata da un URL e sono stati presi in considerazione solo i dati più caratteristici di ogni tweet. L'utente, tramite apposite richieste, potrà effettuare filtri e statistiche, le statistiche possono essere effettuate sia sull'intera collezione di dati che su una sua parte applicando prima un filtraggio.

[Pre requisiti ed avvio del progetto](https://github.com/FedericaRipani/Progetto-Programmazione-ad-Oggetti#pre-requisiti-ed-avvio-del-progetto)

[Funzionamento del progetto](https://github.com/FedericaRipani/Progetto-Programmazione-ad-Oggetti#funzionamento)

[Struttura del progetto](https://github.com/FedericaRipani/Progetto-Programmazione-ad-Oggetti#struttura)



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


---

#### Filtri 
I filtri disponibili sono riportati nella seguente tabella:
!!!!!!Verificare che non siano stati invertiti i filtri UpperBound e LowerBound + specificare che del testo si considera la sua lunghezza come parametro!!!!!!
////Metteremo tabella////


## **Struttura**

Il progetto è strutturato con vari package rispettando il pattern architetturale MVC come di seguito dimostrato:

<img src="https://github.com/FedericaRipani/Progetto-Programmazione-ad-Oggetti/blob/master/Images/Package.svg" style="zoom: 5%;" style="align: center;"/>

Per il Class Diagram completo di metodi e relazioni, e per gli altri diagrammi UML, si faccia riferimento a questa [cartella](https://github.com/FedericaRipani/Progetto-Programmazione-ad-Oggetti/tree/master/UML).




## Autori


[**Federica Ripani**](https://twitter.com/RipaniFederica) - S1086993

[**Camilla D'Andrea**](https://twitter.com/CamillaDAndrea2) - S1087888

Studentesse del 2° anno di Ing. Informatica e dell'Automazione presso l'UNIVPM.

Il link rimanda al profilo Twitter creato in occasione dello sviluppo del progetto.
