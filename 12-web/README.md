# Serwowanie statycznych zasobów z "embedded Jetty"

Potrzebne zależności:
```xml
<properties>
    <jetty.version>9.4.10.v20180503</jetty.version>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
  </properties>

  <dependencies>
    <dependency>
      <groupId>org.eclipse.jetty</groupId>
      <artifactId>jetty-server</artifactId>
      <version>${jetty.version}</version>
    </dependency>
    <dependency>
      <groupId>org.eclipse.jetty</groupId>
      <artifactId>jetty-servlet</artifactId>
      <version>${jetty.version}</version>
    </dependency>
```

Konfiguracja:
```java
public static void main(String[] args) throws Exception {
    Server server = new Server(8080);

    ServletContextHandler servletHandler = new ServletContextHandler();
    servletHandler.addServlet(MySerlet.class, "/*");
    servletHandler.setContextPath("/rest");

    ContextHandler staticResourcesHandler = new ContextHandler("/*");
    ResourceHandler handler = new ResourceHandler();
    handler.setBaseResource(Resource.newClassPathResource("/webapp/"));
    staticResourcesHandler.setHandler(handler);

    ContextHandlerCollection handlers = new ContextHandlerCollection();
    handlers.setHandlers(new Handler[] { servletHandler, staticResourcesHandler });

    server.setHandler(handlers);


    server.start();

    server.join();
}
```

Przy powyższej konfiguracji umieszczamy pliki takie jak *index.html* umieszczamy w `src/main/resources/webapp`.

# Web vs Java
Kilka webowych frameworków:
- JavaServer Pages - stare, mieszają html z kodem Javy
- JavaServer Faces - trochę nowsze, też rzadko używane w dzisiejszych czasach, [tutorial Oracle'a](https://docs.oracle.com/javaee/7/tutorial/jsf-intro.htm)
- [Vaadin](https://vaadin.com) - kodujemy w Javie, interfejs użytkownika jest generowany z Javy.
- [Wicket](https://wicket.apache.org/) - strona w htmlu, łączona z modelem w Javie przez `wicket:id`
- [Play](https://www.playframework.com/)

Można też pisać frontend w htmlu i javascripcie.

# Wymiana danych między javascriptem a Javą

Dla servletu wystawionego na */rest* zwracającego:
```json
[{"id":123,"firstName":"foo","lastName":"bar"}]
```

index.html:
```html
<html>
<head>
  <!-- jeśli chcemy użyć jQuery:
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    -->
    <script src="js/myscripts.js"></script>
</head>
<body>
<h1>it works!</h1>
<span class="foo"></span>
</body>
</html>
```
## Czysty JavaScript
```javascript
window.onload = function() {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "/rest", true);
    xhr.onload = function (e) {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                var json = JSON.parse(xhr.responseText);
                document.getElementById("bar").innerText = json[0].firstName;
            } else {
            }
        }
    };
    xhr.onerror = function (e) {
        console.error(xhr.statusText);
    };
    xhr.send();
};
```


## jQuery

js/myscript.js:
```javascript
$(document).ready(function() {
    $.ajax({
        url: "/rest"
    }).then(function(data) {
        var json = jQuery.parseJSON(data);
        $('.foo').text(json[0].firstName);
    });
});
```

## Bardziej zaawansowane frameworki javascriptowe
- [Angular](https://angular.io/tutorial)
- [React](https://reactjs.org/)
- ...

# [WebSockety](https://en.wikipedia.org/wiki/WebSocket)

Poniżej przykład w Jetty. pokazuje niezbyt ładne zbieranie websocketowych sesji do statycznej zmiennej. Można je potem wykorzystać, żeby rozesłać jakąś wiadomość do wszystkich połączonych klientów.

```java
public static class MyWebSocketServlet extends WebSocketServlet {

        @Override
        public void configure(WebSocketServletFactory webSocketServletFactory) {
            webSocketServletFactory.register(WSListener.class);
        }
    }

    public static class WSListener implements WebSocketListener {

        public static List<Session> wsSessions = Collections.synchronizedList(new ArrayList<>());

        private Session session;

        @Override
        public void onWebSocketBinary(byte[] bytes, int i, int i1) {
        }

        @Override
        public void onWebSocketText(String s) {
            System.out.println(s);
        }

        @Override
        public void onWebSocketClose(int i, String s) {
            wsSessions.remove(session);
        }

        @Override
        public void onWebSocketConnect(Session session) {
            this.session = session;
            wsSessions.add(session);
        }

        @Override
        public void onWebSocketError(Throwable throwable) {
        }
    }

    // do metody main z przykładu z punktu o statycznych zasobach musimy dodać:
    public static void main(...) {
      ...
        ServletContextHandler servletHandler = new ServletContextHandler();
        // nowa linijka:
        servletHandler.addServlet(MyWebSocketServlet.class, "/ws");

        servletHandler.addServlet(MySerlet.class, "/*");
        servletHandler.setContextPath("/rest");
        ...
      }
```

JavaScript:
```javascript
// WebSockety potrzebują bezwzględnego URLa:
var url = "ws://" + window.location.host + window.location.pathname + "rest/ws";

var websocket = new WebSocket(url);
websocket.onopen = function(evt) { console.log("open"); };
websocket.onclose = function(evt) { console.log("close"); };
websocket.onmessage = function(evt) { console.log(evt.data); };
websocket.onerror = function(evt) { console.log("error!") };
```
